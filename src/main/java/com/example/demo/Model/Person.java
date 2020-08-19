package com.example.demo.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xueyu
 * @date 2020/6/4 17:02
 */
@Getter
@Setter
@Builder
public class Person {
    private String name;
    private int age;
    private String address;
}
