package com.example.demo.disruptor.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.disruptor.event.MsEvent;
import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xueyu
 * @date 2020/5/14 17:42
 */
@Slf4j
public class MsEventHandler implements EventHandler<MsEvent> {

    @Override
    public void onEvent(MsEvent msEvent, long l, boolean b) throws Exception {
        log.info("get msEvent:{}", JSONObject.toJSONString(msEvent));
    }
}
