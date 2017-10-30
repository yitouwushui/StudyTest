package com.yitouwushui.arithmetic;

/**
 * @author ding
 * @date 2017/10/30
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
 * 接出的所有数字的最小的一个。例如输入{3,32,321}，则打印最小的数字是
 * 321323.
 */

public class SortArrayForMinNumber {

    public static void main(String[] args) {
        SortArrayForMinNumber test = new SortArrayForMinNumber();
        int[] array = {3, 32, 321};
        test.printMin(array);

    }

    public void printMin(int[] array) {
        int[] clone = array.clone();
        printMinNumber(clone, 0, clone.length - 1);
        for (int i : clone) {
            System.out.print(i);
        }
        System.out.println();
    }

    private void printMinNumber(int[] array, int start, int end) {
        if (start < end) {
            int mainNumber = array[end];
            int small = start;
            for (int j = start; j < end; j++) {
                if (isSmall(String.valueOf(array[j]), String.valueOf(mainNumber))) {
                    int temp = array[j];
                    array[j] = array[small];
                    array[small] = temp;
                    small++;
                }
            }
            array[end] = array[small];
            array[small] = mainNumber;
            printMinNumber(array, 0, small - 1);
            printMinNumber(array, small + 1, end);
        }

    }

    private boolean isSmall(String m, String n) {
        String left = m + n;
        String right = n + m;
        for (int i = 0; i < left.length(); i++) {
            int leftNum = left.charAt(i);
            int rightNum = right.charAt(i);
            if (leftNum < rightNum) {
                return true;
            } else {
                if (leftNum > rightNum) {
                    return false;
                }
            }
        }
        return false;
    }

}
