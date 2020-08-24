package com.example.demo.disruptor.handler;

import com.example.demo.disruptor.event.MsEvent;
import com.example.demo.utils.JacksonJsonUtil;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xueyu
 * @date 2020/5/14 17:42
 */
@Slf4j
public class MsEventHandler implements EventHandler<MsEvent>, WorkHandler<MsEvent> {

    @Override
    public void onEvent(MsEvent msEvent, long l, boolean b) throws Exception {
        this.onEvent(msEvent);
    }

    @Override
    public void onEvent(MsEvent msEvent) throws Exception {
        log.info("get msEvent:{}, thread:{}", JacksonJsonUtil.toJsonString(msEvent), Thread.currentThread().getName());
    }
}
