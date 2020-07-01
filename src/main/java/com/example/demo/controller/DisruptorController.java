package com.example.demo.controller;

import com.example.demo.disruptor.event.MsEvent;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueyu
 * @date 2020/5/14 18:02
 */
@Slf4j
@RequestMapping("/disruptor")
@RestController
public class DisruptorController {
    @Autowired
    private Disruptor<MsEvent> disruptor;
    private OkHttpClient okHttpClient = new OkHttpClient();

    @GetMapping("/test")
    public String test(String user, String content) {
        long sequence = disruptor.getRingBuffer().next();
        MsEvent event = disruptor.getRingBuffer().get(sequence);
        event.setName(user);
        event.setContent(content);
        disruptor.getRingBuffer().publish(sequence);
        return "ok";
    }

    @GetMapping("/send")
    public String send() throws Exception{
        for (int i = 0; i < 10; i++) {
            Request request = new Request.Builder().get().url("http://localhost:8080/disruptor/test?user=xueyu&content=test" + i).build();
            Response response = okHttpClient.newCall(request).execute();
        }
        return "ok";
    }

}
