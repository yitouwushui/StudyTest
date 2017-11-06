package com.yitouwushui.arithmetic;

/**
 * 题目一：输一个递增排序的数组和一个数字 s,在数组中查找两个数使得它们的
 * 和正好是 s。如果有多对数字的和等于 s，输出任意一对即可。例如：输入数组
 * {1,2,4,7,11,15}和数字为 15.输出 4 和 11.
 *
 * @author ding
 * @date 2017/11/6
 */

public class TwoNumberWithSum {

    public static void main(String[] args) {
        TwoNumberWithSum p = new TwoNumberWithSum();
        int[] data = {1, 2, 4, 7, 11, 15};
        int sum = 30;
        System.out.println(p.findNumberWithSum(data, sum));
    }

    private boolean findNumberWithSum(int[] data, int sum) {
        boolean result = false;
        if (data == null) {
            return false;
        }
        int start = 0;
        int end = data.length - 1;
        int num1 = 0;
        int num2 = 0;
        while (start < end) {
            int current = data[start] + data[end];
            if (current == sum) {
                num1 = data[start];
                num2 = data[end];
                result = true;
                break;
            }
            if (current > sum) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(num1);
        System.out.println(num2);
        return result;
    }

}
