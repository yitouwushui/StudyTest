package com.yitouwushui.arithmetic;

/**
 * 顺时针打印矩阵
 * {1,2,3,4}
 * {5,6,7,8}
 * {9,10,11,12}
 * {13,14,15,16}
 *  {1,2,3,4}
 * Created by ding on 2017/9/29.
 */
public class PrintMatix {

    public static void main(String[] args) {
        int[][] array = {
//                {1, 2, 3, 4, 1}, {5, 6, 7, 8, 2}, {9, 10, 11, 12, 3}, {13, 14, 15, 16, 4}};
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},{1, 2, 3, 4}};
        PrintMatix testCircle = new PrintMatix();
        testCircle.printMatixClockwisely(array);
    }

    /**
     * 判断是否继续打印
     *
     * @param array
     */
    private void printMatixClockwisely(int[][] array) {
        if (array == null) {
            return;
        }
        int start = 0;
        while (array[0].length > start * 2 && array.length > start * 2) {
            printOneCircle(array, start);
            start++;
        }
    }

    /**
     * 打印一圈
     *
     * @param array
     * @param start
     */
    private void printOneCircle(int[][] array, int start) {
        System.out.println();
        // 打印上边 。列变化
        for (int i = start; i < array[start].length - start; i++) {
            System.out.print(array[start][i] + " ");
        }
        System.out.println();
        // 打印右边 竖排长度 - 1 - 起始位置 > 起始位置
        // 行变化
        if (array.length - 1 - start > start) {
            for (int i = start + 1; i < array.length - 1 - start; i++) {
                System.out.print(array[i][array[i].length - 1 - start] + " ");
            }
            System.out.println();
        }
        //打下下边 列变化 横排长度-1-起始位置>起始位置 && 竖排长度 - 1 - 起始位置 > 起始位置
        if (array[start].length - 1 - start > start
                && array.length - 1 - start > start) {
            for (int i = array[start].length - start - 1; i > start - 1; i--) {
                System.out.print(array[array.length - 1 - start][i] + " ");
            }
            System.out.println();
        }
        //打印左边 行变化
        if (array.length - 1 - start > start) {
            for (int i = array.length - start - 2; i > start; i--) {
                System.out.print(array[i][start] + " ");
            }
            System.out.println();
        }

    }
}
