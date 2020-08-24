package com.example.demo.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author xueyu
 * @date 2020/8/24 17:55
 */
@Slf4j
public class ForkJoinClient {
    static Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

    public static void main(String[] args) throws Exception {

        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> task = pool.submit(new TestTask(arr, 0, arr.length - 1, Thread.currentThread().getName(), pool));

        Integer res = task.get();

        System.in.read();
    }


    public static class TestTask extends RecursiveTask<Integer> {
        Integer[] array;
        int start;
        int end;
        String name;
        ForkJoinPool pool;

        public TestTask(Integer[] array, int start, int end, String name, ForkJoinPool pool) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.name = name;
            this.pool = pool;
        }

        @Override
        protected Integer compute() {
            if (end - start > 3) {
                int middle = (start + end) / 2;
                TestTask tl = new TestTask(array, start, middle, Thread.currentThread().getName(), pool);
                TestTask tr = new TestTask(array, middle + 1, end, Thread.currentThread().getName(), pool);

                tl.fork();
                log.info("after tl count:{}", pool.getActiveThreadCount());
                tr.fork();
                log.info("after tr count:{}", pool.getActiveThreadCount());
                return tl.join() + tr.join();
            } else {
                boolean steal = Thread.currentThread().getName().equals(name);
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += array[i];
                    log.info("data:{}, thread:{}, is steal:{}, name:{}, nowCount:{}", array[i], Thread.currentThread().getName(), steal, name, pool.getActiveThreadCount());
                }
                return sum;
            }
        }
    }
}
