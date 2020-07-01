package com.example.demo.disruptor;

import com.example.demo.disruptor.event.MsEvent;
import com.example.demo.disruptor.event.MsEventFactory;
import com.example.demo.disruptor.handler.MsEventHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xueyu
 * @date 2020/5/14 18:03
 */
@Configuration
public class DisruptorConfig {

    @Bean
    public Disruptor<MsEvent> disruptor(){
        Disruptor<MsEvent> disruptor = new Disruptor<MsEvent>(new MsEventFactory(), 8, DaemonThreadFactory.INSTANCE);
        disruptor.handleEventsWith(new MsEventHandler());
        disruptor.start();
        return disruptor;
    }
}
