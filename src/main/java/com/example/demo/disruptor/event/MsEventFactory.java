package com.example.demo.disruptor.event;

import com.lmax.disruptor.EventFactory;

/**
 * @author xueyu
 * @date 2020/5/14 17:41
 */
public class MsEventFactory implements EventFactory<MsEvent> {


    @Override
    public MsEvent newInstance() {
        return new MsEvent();
    }
}
