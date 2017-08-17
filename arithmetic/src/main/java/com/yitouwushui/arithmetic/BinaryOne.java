package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/17.
 *  筛选一个整数的二进制中的0和1
 */

public class BinaryOne {

    public int numberOf1(int n){
        int count = 0;
        while (n!=0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public int numberOf0(int n){
        int digit = 0;
        int digitN = n;
        while (digitN != 0){
            digit++;
            digitN >>= 1;
        }
        int count = 0;
        while (n!=0){
            count++;
            n = (n - 1) & n;
        }
        return digit - count;
    }

    public static void main(String args[]){
        BinaryOne binaryOne = new BinaryOne();
        int n = 5;
        System.out.println(binaryOne.numberOf1(n));
        System.out.println(binaryOne.numberOf0(n));
    }
}
