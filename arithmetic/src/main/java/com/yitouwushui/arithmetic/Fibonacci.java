package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/16.
 * 写一个函数，输入 n，求斐波那契数列的第 n 项。
 */

public class Fibonacci {
    public long fibonacci(int n){
        long result = 0;
        long preOne = 0;
        long preTwo = 1;
        if(n <= 0){
            return result;
        }
        if (n == 1){
            return preTwo;
        }
        for (int i=2;i<=n;i++){
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }

    public static void main(String args[]){
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(4));
    }
}
