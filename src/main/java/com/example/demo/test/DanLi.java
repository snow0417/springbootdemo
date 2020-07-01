package com.example.demo.test;

/**
 * @author xueyu
 * @date 2020/6/2 15:05
 */
public class DanLi {
    private static DanLi danLi = null;

    private DanLi() {

    }

    private static DanLi create() {
        if(danLi != null){
            synchronized (DanLi.class){
                if(danLi == null){
                    danLi = new DanLi();
                }
            }
        }
        return danLi;
    }
}
