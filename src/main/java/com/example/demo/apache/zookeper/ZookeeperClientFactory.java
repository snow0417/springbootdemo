package com.example.demo.apache.zookeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author xueyu
 * @date 2020/8/26 15:42
 */
@Slf4j
@Component
public class ZookeeperClientFactory {

    public ZooKeeper newInstance() throws IOException {
        return new ZooKeeper("39.105.185.187:2181", 60000, new ZooKeeperConnectionWatcher());
    }

    public static class ZooKeeperConnectionWatcher implements Watcher {
        @Override
        public void process(WatchedEvent watchedEvent) {
            log.info("zookeeper connection stat:{}", watchedEvent);
        }
    }
}
