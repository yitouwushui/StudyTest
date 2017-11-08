package com.yitouwushui.arithmetic;

import java.util.HashMap;

/**
 * 题目：从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
 * 2-10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，而大小王可以看成任意的
 * 数字。
 *
 * @author ding
 * @date 2017/11/8
 */

public class ContinuousCards {

    public static void main(String[] args) {
        int[] array = {0, 4, 6, 8, 4};
        ContinuousCards test = new ContinuousCards();
        System.out.println(test.isContinuous(array));
    }

    private boolean isContinuous(int[] array) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = 0;
        int zeroNum = 0;
        for (int i : array) {
            if (i == 0) {
                zeroNum++;
                continue;
            } else if (i > min) {
                min = i;
            }
            if (hm.get(i) == null) {
                hm.put(i, 1);
            } else {
                // 有对子
                return false;
            }
        }
        for (int i = min, length = min + 5; i < length; i++) {
            if (hm.get(min) != 1){
                if (zeroNum == 0){
                    return false;
                }else {
                    zeroNum--;
                }
            }
        }
        return true;
    }

}
