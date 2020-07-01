package com.example.demo.mybatis.config;

/**
 * @author xueyu
 * @date 2020/6/30 18:39
 */
public class DbContextHolder {
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        set(DBTypeEnum.SLAVE);
        System.out.println("切换到slave");
    }

}
