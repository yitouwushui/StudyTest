package com.yitouwushui.arithmetic;

/**
 *
 * @author ding
 * @date 2017/11/2
 * 题目：在数组中的两个数字如果前一个数字大于后一个数字，则这两个数字组成
 * 一个逆序对。输入一个数组，求出这个数组的逆序对的总数。例如在数组{7,5,6,4}
 * 中，一共存在 5 个逆序对，分别是（7,6）、（7、5），（7、4），（6、4），
 * （5、4）。
 */

public class InversePairs {

    public static void main(String[] args) {
        InversePairs p = new InversePairs();
        int[] array = {7, 5, 6, 4};
        System.out.println(p.inversePairs(array));
    }

    public int inversePairs(int[] array) {
        if (array == null) {
            return 0;
        }
        int[] copy = array.clone();
        return mergeSort(array, copy, 0, array.length - 1);
    }

    private int mergeSort(int[] array, int[] result, int start, int
            end) {
        if (start == end) {
            result[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = mergeSort(result, array, start, start + length);
        int right = mergeSort(result, array, start + length + 1, end);
        int leftIndex = start + length;
        int rightIndex = end;
        int count = 0;
        int point = rightIndex;
        while (leftIndex >= start && rightIndex >= start + length + 1) {
            if (array[leftIndex] > array[rightIndex]) {
                result[point--] = array[leftIndex--];
                count += rightIndex - start - length;
            } else {
                result[point--] = array[rightIndex--];
            }
        }
        for (int i = leftIndex; i >= start; i--) {
            result[point--] = array[i];
        }
        for (int j = rightIndex; j >= start + length + 1; j--) {
            result[point--] = array[j];
        }
        return left + right + count;
    }
}

