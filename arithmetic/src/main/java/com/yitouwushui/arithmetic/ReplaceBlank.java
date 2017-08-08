package com.yitouwushui.arithmetic;

/**
 * Created by yitouwushui on 2017/8/8.
 * 替换空格
 */
public class ReplaceBlank {

    public static String replaceBlank(String input){
        if (input == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < input.length();i++){
            if(input.charAt(i) == ' '){
                sb.append("%20");
            } else {
                sb.append(String.valueOf(input.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static String replaceBlank2(String input){
        if (input == null){
            return null;
        }
        return input.replaceAll(" ","%20");
    }

    public static void main(String args[]){
        String str = "剑指  offer java 版本 ";
        System.out.print(replaceBlank2(str));
    }
}
