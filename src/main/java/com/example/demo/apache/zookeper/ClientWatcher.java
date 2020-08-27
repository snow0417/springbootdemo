package com.example.demo.apache.zookeper;

import com.example.demo.utils.JacksonJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author xueyu
 * @date 2020/8/25 17:31
 */
@Slf4j
public class ClientWatcher implements Watcher {

    @Override
    public void process(WatchedEvent watchedEvent) {
        log.info("client watcher:{}", JacksonJsonUtil.toJsonString(watchedEvent));
    }
}
