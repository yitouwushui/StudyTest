package com.yitouwushui.arithmetic;

/**
 *
 * @author ding
 * @date 2017/10/25
 */

public class GreatestSumOfSubareas {
    public static void main(String[] args) {
        GreatestSumOfSubareas p = new GreatestSumOfSubareas();
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(p.findGreatestSubArray(array));
    }

    private int findGreatestSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int currentSum = 0;
        int greatestSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentSum <= 0) {
                currentSum = array[i];
                startIndex = i;
            } else {
                currentSum += array[i];
            }
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
                endIndex = i;
            }
        }
        for (int i = startIndex;i <= endIndex;i++){
            System.out.print(" i:" + array[i]);
        }
        System.out.println();
        return greatestSum;
    }
}
