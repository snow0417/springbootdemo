package com.example.demo.mybatis.config;

/**
 * @author xueyu
 * @date 2020/6/30 18:39
 */
public class DbContextHolder {
    private static final ThreadLocal<DBTypeEnum> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void set(DBTypeEnum dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static DBTypeEnum get() {
        return CONTEXT_HOLDER.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);

    }

    public static void slave() {
        set(DBTypeEnum.SLAVE);
    }

    public static void remove() {
        CONTEXT_HOLDER.remove();
    }
}
