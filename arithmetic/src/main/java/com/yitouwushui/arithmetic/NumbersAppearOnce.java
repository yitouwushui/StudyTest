package com.yitouwushui.arithmetic;

/**
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * 找出这两个只出现一次的数字。要求时间复杂度是 O（n），空间复杂度为 O（1）；
 *
 * @author ding
 * @date 2017/11/6
 */

public class NumbersAppearOnce {

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        NumbersAppearOnce p = new NumbersAppearOnce();
        p.findNumsAppearOnce(array);
    }

    private void findNumsAppearOnce(int[] array) {
        if (array == null) {
            return;
        }
        int number = 0;
        // 得到两个单数不同的异或值
        for (int i = 0; i < array.length; i++) {
            number ^= array[i];
        }
        // 得到number第一个为1的位数
        int index = findFirstBitIs1(number);
        int number1 = 0;
        int number2 = 0;
        for (int i : array) {
            if (indexIsBit1(i, index)) {
                number1 = number1 ^ i;
            } else {
                number2 = number2 ^ i;
            }
        }
        System.out.println(number1);
        System.out.println(number2);

    }

    private boolean indexIsBit1(int number, int index) {
        number = number >> index;
        return (number & 1) == 1;
    }

    private int findFirstBitIs1(int number) {
        if (number == 0) {
            return 0;
        }
        int indexBit = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            indexBit++;
        }
        return indexBit;
    }
}
