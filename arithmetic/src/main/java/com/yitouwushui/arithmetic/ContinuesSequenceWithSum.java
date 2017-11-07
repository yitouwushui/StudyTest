package com.yitouwushui.arithmetic;

/**
 * 输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含两个数）。
 * 例如输入 15，由于 1+2+3+4+5=4+5+6=7+8=15，所以结果打印出 3 个连续序列 1-5、
 * 4-6、和 7-8.
 *
 * @author ding
 * @date 2017/11/7
 */

public class ContinuesSequenceWithSum {

    public static void main(String[] args) {
        ContinuesSequenceWithSum p = new ContinuesSequenceWithSum();
        int sum = 30;
        p.findContinuesSequence(sum);
        System.out.println();
    }

    public void findContinuesSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                printContinueNub(small, big);
            }
            if (curSum < sum){
                big++;
                curSum+=big;
            } else {
                curSum -= small;
                small++;
            }

        }
    }

    private void printContinueNub(int small, int big) {
        System.out.println();
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
