package com.example.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xueyu
 * @date 2020/5/21 14:43
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("country_tele_code", "+86");
        map.put("phone_code", "18500361569");
        map.put("sms_content", "1234");
        map.put("trace_id", "test_123");
        map.put("deliver_type", "rst_test");
        map.put("shareit_id", "shareit_id");
        map.put("user_id", "userid");
        map.put("app_version", "4040548");
        map.put("channel_code", "beelink");
        map.put("user_request_id", "user_request_id");
        System.out.println(JSONObject.toJSONString(map));
        System.out.println(UUID.randomUUID().toString());
    }
}
