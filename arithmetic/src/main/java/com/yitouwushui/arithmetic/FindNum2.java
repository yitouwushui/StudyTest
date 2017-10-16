package com.yitouwushui.arithmetic;

import java.util.Random;

/**
 * Created by yitouwushui on 2017/10/14.
 */

public class FindNum2 {


    static int[] array = {
            21,21,21,21,21,21,21,21,21,21,
            20,20,20,20,20,20,20,20,20,20,20};

    public static void main(String args[]) {

        int temp = array[0];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (temp == array[i]) {
                // 如果相等计+1
                count++;
            } else {
                // 不相等
                if (count > 1) {
                    count--;
                } else {
                    temp = array[i];
                    count = 1;
                }
            }
        }
        System.out.println(temp);


        System.out.print(5^6^7^8);


//        Random random = new Random();
//        for (int i = 0; i < 21; i++) {
//            if (i < 10){
//                System.out.print(random.nextInt(100));
//                System.out.print(",");
//            } else {
//                System.out.print(20);
//                System.out.print(",");
//            }
//        }
    }


}
