package com.example.demo.controller;

import com.example.demo.apache.zookeper.ZookeeperClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * @author xueyu
 * @date 2020/8/25 17:45
 */
@Slf4j
@RequestMapping("/zookeeper")
@RestController
public class ZookeeperController {
    @Autowired
    private ZooKeeper zooKeeper;
    @Autowired
    private ZookeeperClientFactory zookeeperClientFactory;


    @GetMapping("/add")
    public String zookeeper() throws Exception {
        zookeeperClientFactory.newInstance().create("/xueyu", "xueyu test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        return "ok";
    }


    @GetMapping("/addLock")
    public String addLock() throws Exception {
        String path = "/xueyu_locks/lock";
        String preNode = zooKeeper.create(path, path.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        log.info("create pre node.{}", preNode);

        String preNode2 = zooKeeper.create(path, path.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        log.info("create pre node.{}", preNode2);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        String nowNode = zooKeeper.create(path, path.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        zooKeeper.getChildren("/xueyu_locks", watchedEvent -> {
            log.info("get data wathch:{}", watchedEvent);
            if (watchedEvent.getType().getIntValue() == Watcher.Event.EventType.NodeDeleted.getIntValue()) {
                try {
                    List<String> children = zooKeeper.getChildren("/xueyu_locks", false);
                    String[] node = nowNode.split("/");
                    String name = node[node.length - 1];
                    if (isMin(children, name)) {
                        countDownLatch.countDown();
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        });

        countDownLatch.await();
        log.info("get lock...{}", nowNode);

        return "ok";
    }

    @GetMapping("removeLock")
    public String removeLock(String path) throws Exception {
        zooKeeper.delete(path, -1);
        return "ok";
    }

    private boolean isMin(List<String> datas, String node) {
        return datas.stream().sorted().collect(Collectors.toList()).get(0).equals(node);
    }
}
