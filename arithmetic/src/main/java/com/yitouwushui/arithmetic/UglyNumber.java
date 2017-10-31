package com.yitouwushui.arithmetic;

/**
 * @author ding
 * @date 2017/10/31
 */

public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber p = new UglyNumber();
        System.out.println(p.getUglyNumber(1500));
    }

    public int getUglyNumber(int n) {
        if (n < 0) {
            return 0;
        }
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        for (int i = 1; i < uglyArray.length; i++) {
            int min = min(uglyArray[multiply2] * 2, uglyArray[multiply3] * 3, uglyArray[multiply5] * 5);
            uglyArray[i] = min;
            while (uglyArray[multiply2] * 2 <= min) {
                multiply2++;
            }
            while (uglyArray[multiply3] * 3 <= min) {
                multiply3++;
            }
            while (uglyArray[multiply5] * 5 <= min) {
                multiply5++;
            }
        }
        return uglyArray[n - 1];
    }

    private int min(int i, int j, int k) {
        int min = (i < j) ? i : j;
        return (min < k) ? min : k;
    }
}
