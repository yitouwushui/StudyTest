package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/17.
 * 题目：输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。比如输入 3，
 * 则打印出 1、2、3 一直到 999.
 */

public class Problem12 {

    public void printToMaxOfDigits(int n) {
        if (n <= 0) {
            return;
        }
        int[] array = new int[n];
        printArray(array, 0);
    }

    private void printArray(int[] array, int n) {
        for (int i = 0; i < 10; i++) {
            if (n != array.length) {
                array[n] = i;
                printArray(array, n + 1);
            } else {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    } else {
                        if (isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }

    private void printArray2(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = 0;
        }
        int index = n - 1;
        int number = 1;
        while (!isPrintComplete(array)) {
            array[index] = number;
            print(array);
            System.out.println();
            number++;
            if (number == 10 && !isPrintComplete(array)) {
                number = 0;
                array[index] = 10;
                while (array[index] == 10 && index >= 0) {
                    array[index] = 0;
                    array[index - 1] = array[index - 1] + 1;
                    index--;
                }
                index = n - 1;
            }
        }

    }

    private boolean isPrintComplete(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 9) {
                return false;
            }
        }
        return true;
    }

    private void print(int[] array) {
        boolean isFirstNo0 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                System.out.print(array[i]);
                if (!isFirstNo0) {
                    isFirstNo0 = true;
                }
            } else {
                if (isFirstNo0) {
                    System.out.print(array[i]);
                }
            }
        }
    }


    public static void main(String args[]) {
        Problem12 problem12 = new Problem12();
        problem12.printArray2(4);
    }

}
