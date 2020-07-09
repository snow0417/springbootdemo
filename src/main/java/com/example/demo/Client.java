package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xueyu
 * @date 2020/5/21 14:43
 */
public class Client {
    private static Object o = new Object();

    public static void main(String[] args) throws Exception {
        int[] s = new int[1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);

        Integer p = q.peek();
        Integer poll = q.poll();
        Integer r = q.remove();

        q.offer(23);
        q.offer(233);
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return new int[0];
        }

        Set<Integer> set = new TreeSet();
        for(int i = 0; i <= k; k--){
            set.add(shorter * (k-i) + i * longer);
        }
        int[] res = new int[set.size()];
        int i = 0;
        for(Integer val : set){
            res[i++] = val;
        }

        return res;
    }

}
