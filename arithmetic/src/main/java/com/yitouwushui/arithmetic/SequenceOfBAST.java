package com.yitouwushui.arithmetic;

import java.util.Arrays;

/**
 * 5
 * 4   6
 * 7
 * Created by ding on 2017/10/17.
 */

public class SequenceOfBAST {

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 9, 11, 10, 8};
//        int[] array={7,4,6,5};
//        int[] array={6,7,8,5};
        SequenceOfBAST p24 = new SequenceOfBAST();
//        System.out.println(p24.verifySequenceOfBST(array));
        System.out.println(p24.verfiySequenceOfBST(array));
    }

    private boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int cut = 0;
        // 找到大于根节点的位置(右子节点的最底层节点数）
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] > root) {
                cut = i + 1;
            }
            break;
        }
        if (cut == 0) {
            // 如果为0，没有左节点
            verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
        } else {
            // 排除后面的有小于根节点的数
            for (int j = cut; j < length - 1; j++) {
                if (sequence[j] < root)
                    return false;
            }
        }
        boolean left = true;
        if (cut > 0) {
            // 子树的左节点(不包含其根节点）
            left = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, cut));
        }
        boolean right = true;
        if (cut < length - 1) {
            right = verifySequenceOfBST(Arrays.copyOfRange(sequence, cut, length - 1));
        }
        return (right && left);
    }


    public boolean verfiySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        int length = sequence.length;
        int root = sequence[length - 1];
        int cut = 0;
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] > root) {
                cut = i + 1;
                break;
            }
        }
        if (cut == 0) {
            verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
        } else {
            for (int j = cut; j < length - 1; j++) {
                if (sequence[j] < root)
                    return false;
            }
        }
        boolean left = true;
        if (cut > 0)
            left = verfiySequenceOfBST(Arrays.copyOfRange(sequence, 0, cut));
        boolean right = true;
        if (cut < length - 1)
            right = verfiySequenceOfBST(Arrays.copyOfRange(sequence, cut, length - 1));
        return (right && left);
    }

}
