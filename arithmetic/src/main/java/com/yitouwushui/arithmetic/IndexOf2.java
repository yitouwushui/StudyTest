package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/9.
 */
public class IndexOf2 {

    public static int myIndexOf(String str, String target, int fromIndex) {
        if (fromIndex > str.length() || target.length() > str.length()) {
            return -1;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (target.length() == 0) {
            return fromIndex;
        }
        char first = target.charAt(0);
        // 循环次数
        int max = (str.length() - target.length());
        for (int i = fromIndex; i <= max; i++) {
            // 匹配第一个字符
            if (str.charAt(i) != first) {
                while (++i <= max && str.charAt(i) != first) ;
            }
            if (i <= max) {
                // 匹配后续字符
                int j = i + 1;
                int end = j + target.length() - 1; // 最后一个字符的索引
                for (int k = 1; j < end && str.charAt(j) == target.charAt(k); j++, k++);
                if (j == end){
                    // 匹配结束，j和end应该相等
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        String str = "abcdbcdcd";

        System.out.println("start");
        System.out.println(myIndexOf(str,"cd",1) + ";");
        System.out.println("end");

    }
}
