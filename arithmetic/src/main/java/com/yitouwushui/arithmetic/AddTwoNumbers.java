package com.yitouwushui.arithmetic;

/**
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则
 * 运算符号。
 *
 * @author ding
 * @date 2017/11/8
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers p = new AddTwoNumbers();
        System.out.println(p.add(8, 16));
    }
    public int add(int num1,int num2){
        int sum , diff;
        do {
            // 获取不同位数
            sum = num1 ^ num2;
            // 获取相同位数，并进位
            diff = (num1 & num2) << 1;
        } while (diff != 0);
        return sum;
    }

}
