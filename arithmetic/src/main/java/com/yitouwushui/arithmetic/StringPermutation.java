package com.yitouwushui.arithmetic;

/**
 * @author ding
 * @date 2017/10/23
 */

public class StringPermutation {

    public static void main(String args[]) {
        StringPermutation permutation = new StringPermutation();
//        permutation.permutation2("abcd");
        permutation.permutation("abcd");
    }

    public void permutation(String str) {
        if (str == null) {
            return;
        }
        permutation(str.toCharArray(), 0);
    }

    private void permutation(char[] str, int begin) {
        if (begin >= str.length) {
            return;
        }
        if (begin == str.length - 1) {
            System.out.println(str);
        } else {
            for (int i = begin; i < str.length; i++) {
                char temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
                permutation(str, begin + 1);
                temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
            }
        }
    }


    public void permutation2(String str) {
        int count = 0;
        if (str == null) {
            return;
        }
        char[] chs = str.toCharArray();
        int point = 0;
        System.out.print(chs);
        System.out.print(" ");
        count++;
        char temp1 = chs[point];
        chs[point] = chs[++point];
        chs[point] = temp1;
        while (!String.valueOf(chs).equals(str)) {
            System.out.print(chs);
            System.out.print(" ");
            count++;
            if (point == chs.length - 1) {
                char temp = chs[point];
                chs[point] = chs[0];
                chs[0] = temp;
                point = 0;
            } else {
                char temp = chs[point];
                chs[point] = chs[++point];
                chs[point] = temp;
            }
        }
        System.out.println(count);
    }

}
