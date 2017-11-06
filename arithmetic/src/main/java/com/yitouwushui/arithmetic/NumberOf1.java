package com.yitouwushui.arithmetic;

/**
 * 输入一个整数 n，求从 1 到 n 这 n 个整数的十进制表示中 1 出现的次
 * 数。例如输入 12，这些整数中包含 1 的数字有 1,10,11,12，1 一共出现了 5 次
 * Created by ding on 2017/10/26.
 */

public class NumberOf1 {

    public static void main(String[] args) {
        NumberOf1 p = new NumberOf1();
        System.out.println(p.countOne(123));
    }

    private long countOne(int n) {
        long count = 0;
        long i = 1;
        long current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10; // 当前位数字
            before = n / (i * 10); // 高位数字
            after = n - (n / i) * i;// 低位数字
            if (current > 1) {
                count = count + (before + 1) * i;
            } else if (current == 0) {
                count = count + before * i;
            } else if (current == 1) {
                count = count + before * i + after + 1;
            }
            i = i * 10;
        }
        return count;
    }


}
