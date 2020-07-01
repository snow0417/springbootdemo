package com.example.demo.jackson;

import com.example.demo.Model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xueyu
 * @date 2020/5/29 15:14
 */
public class JacksonClient {

    public static void main(String[] args) {
        try {
            Person person = new Person();
            person.setName("xueyu");
            person.setAge(18);
            person.setAddress("beijing");


            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(person);
            System.out.println(json);

            Person p2 = mapper.readValue(json, Person.class);
            int i = 0;
        } catch (Exception e) {

        }

    }

}
