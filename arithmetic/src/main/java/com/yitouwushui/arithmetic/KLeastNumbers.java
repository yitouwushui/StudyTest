package com.yitouwushui.arithmetic;

import java.util.TreeMap;

/**
 * Created by ding on 2017/10/24.
 * 面试题 30：最小的 k 个数。
 * 题目：输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1，6,2,7,3,8 这
 * 8 个数字，则最少的 4 个数字是 1,2,3,4
 */

public class KLeastNumbers {

    public static void main(String[] args) {
        KLeastNumbers test = new KLeastNumbers();
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        test.getLeastNumbers(array, 2);
    }

    private void getLeastNumbers(int[] array, int i) {

    }
}
