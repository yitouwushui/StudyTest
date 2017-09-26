package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/24.
 * 调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得
 * 所有奇数位于数组的前半部分，所有的数组位于数组的后半部分。
 */
public class OddAndEven {

    public static void main(String args[]) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        OddAndEven oddAndEven = new OddAndEven();
        oddAndEven.order(array);
        oddAndEven.print(array);
    }

    public void order(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && isSingular(array[start])) {
                start++;
            }
            while (start < end && !isSingular(array[end])) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    /**
     * 交换条件
     *
     * @param number
     * @return
     */
    private boolean isSingular(int number) {
        return (number & 1) == 1;
    }

    private void print(int[] array){
        System.out.println();
        for (int item : array) {
            System.out.print(item);
        }
        System.out.println();
    }

}
