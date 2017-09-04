package com.yitouwushui.arithmetic;

import java.math.BigDecimal;

/**
 * Created by ding on 2017/9/4.
 * 1、循环小数分纯循环小数和混循环小数.
 * 2、纯循环小数的化法,如,0.ab（ab循环）=（ab/99）,最后化简.举例如下：
 * 0.3（3循环）=3/9=1/3；
 * 0.7（7循环）=7/9；
 * 0.81（81循环）=81/99=9/11；
 * 1.206（206循环）=1又206/999.
 * 3、混循环小数的化法,如,0.abc（bc循环）=（abc－a）/990.最后化简.举例如下：
 * 0.51（1循环）=（51－5）/90=46/90=23/45；
 * 0.2954（54循环）=（2954－29）/9900=13/44；
 * 1.4189（189循环）=1又（4189－4）/9990=1又4185/9990=1又31/74.
 */

public class Problem16 {

    /**
     * n / m
     *
     * @param n 分子
     * @param m 分母
     * @return
     */
    public static boolean isNonterminating(int n, int m) {
        try {
            BigDecimal bigA = new BigDecimal(n);
            BigDecimal bigB = new BigDecimal(m);
            System.out.println("a/b=" + bigA.divide(bigB));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static void main(String args[]) {
        System.out.println(isNonterminating(3, 7));
        System.out.println(isRepeating(3, 7));
    }

    //判断numerator/denominatoe是否是循环小数
    public static Boolean isRepeating(int numerator, int denominator) {
        int simpleDen = 0;
        if (numerator < denominator) {
            for (int i = numerator; i > 0; i--) {
                if (numerator % i == 0 && denominator % i == 0) {
                    simpleDen = denominator / i;
                    break;
                }
            }
        } else {
            for (int i = denominator; i > 0; i--) {
                if (numerator % i == 0 && denominator % i == 0) {
                    simpleDen = denominator / i;
                    break;
                }
            }
        }
        //如果分数化简后分母除了2,5之外还有素因数，就是无限循环小数
        for (int i = 2; i <= simpleDen; i++) {
            if (simpleDen % i == 0) {
                if (isPrime(i)) {
                    if (i != 2 && i != 5)
                        return true;
                }
            }
        }
        return false;
    }

    //判断是否是素数
    public static boolean isPrime(int n) {
        if (n == 1 || n == 2 || n == 3) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
