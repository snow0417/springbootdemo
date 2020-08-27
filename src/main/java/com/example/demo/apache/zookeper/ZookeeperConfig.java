package com.example.demo.apache.zookeper;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author xueyu
 * @date 2020/8/25 11:02
 */
@Configuration
public class ZookeeperConfig {

    @Bean
    public ZooKeeper zooKeeper() throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("39.105.185.187:2181", 60000, new ClientWatcher());
        return zooKeeper;
    }


}
