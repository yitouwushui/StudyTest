package com.yitouwushui.arithmetic;

import java.util.LinkedHashMap;

/**
 *
 * @author ding
 * @date 2017/10/31
 */

public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        FirstNotRepeatingChar p=new FirstNotRepeatingChar();
        System.out.println(p.firstNotRepeatChar("agbaccdeff"));
    }

    private Character firstNotRepeatChar(String str) {
        if (str == null){
            return null;
        }
        char[] strChar = str.toCharArray();
        LinkedHashMap<Character,Integer> hash = new LinkedHashMap<>();
        for (char c : strChar) {
            if (hash.containsKey(c)){
                hash.put(c,hash.get(c) + 2);
            } else {
                hash.put(c,1);
            }
        }
        for (Character character : hash.keySet()) {
            if (hash.get(character) == 1){
                return character;
            }
        }
        return null;
    }
}
