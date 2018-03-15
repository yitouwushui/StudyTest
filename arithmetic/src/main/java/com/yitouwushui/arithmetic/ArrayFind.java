package com.yitouwushui.arithmetic;

/**
 * Created by yitouwushui on 2017/8/8.
 * 二维横向纵向递增数组中的查找
 */

public class ArrayFind {

    static int count = 0;

    public static boolean find(int[][] array, int number) {
        if (array == null) {
            return false;
        }
        int column = array[0].length - 1;
        int row = 0;
        while (row < array.length && column >= 0) {
            count++;
            if (array[row][column] == number) {
                return true;
            }
            if (array[row][column] > number) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static boolean findFor(int[][] array, int number) {
        if (array == null) {
            return false;
        }

        int columnLength = array[0].length;
        for (int row = array.length - 1, column = 0; row >= 0 && column < columnLength; ) {
            count++;
            if (array[row][column] == number) {
                return true;
            }
            if (array[row][column] < number) {
                column++;
            } else {
                row--;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] testarray = new int[4][4];
        testarray[0][0] = 1;
        testarray[0][1] = 2;
        testarray[0][2] = 8;
        testarray[0][3] = 9;
        testarray[1][0] = 2;
        testarray[1][1] = 4;
        testarray[1][2] = 9;
        testarray[1][3] = 12;
        testarray[2][0] = 4;
        testarray[2][1] = 7;
        testarray[2][2] = 10;
        testarray[2][3] = 13;
        testarray[3][0] = 6;
        testarray[3][1] = 8;
        testarray[3][2] = 11;
        testarray[3][3] = 15;
        System.out.println(findFor(testarray, 11));
        System.out.println(count);
    }
}
