package com.example.demo.proxy;

/**
 * @author xueyu
 * @date 2020/6/16 15:19
 */
public class Student implements IStudent{

    @Override
    public void study() {
        System.out.println("i am studying...");
    }
}
