package com.yitouwushui.arithmetic;

import java.util.LinkedList;

/**
 * 0,1，...,n-1 这 n 个数排成一个圆圈，从数字 0 开始每次从这个圆圈里
 * 删除第 m 个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * @author ding
 * @date 2017/11/8
 */

public class LastNumberInCircle {

    public static void main(String[] args) {
        LastNumberInCircle p = new LastNumberInCircle();
        System.out.println(p.LastNumberInCircle(8, 3));
        System.out.println(p.LastNumberInCircle2(8, 3));
    }

    private int LastNumberInCircle(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 1; i < n; i++) {
            last = (last + m) % (i + 1);
        }
        return last;
    }

    private String LastNumberInCircle2(int n, int m) {
        if (n < 1 || m < 1) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            linkedList.add("a"+i);
        }
        for (int i = 0,index = m - 1; i < n - 1; i++) {
            while (index >= linkedList.size()){
                index = index - linkedList.size();
            }
            linkedList.remove(index);
            index--;
            index=index + m;
        }
        return linkedList.getFirst();
    }

}
