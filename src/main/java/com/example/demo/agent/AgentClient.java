package com.example.demo.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author xueyu
 * @date 2020/9/4 16:30
 */
public class AgentClient {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("pre main start");
    }
}
