package com.yitouwushui.arithmetic;

/**
 * 题目：把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。输入 n，打印
 * 出 s 的所有可能的值出现的概率。
 *
 * @author ding
 * @date 2017/11/7
 */

public class DicesProbability {

    public static void main(String[] args) {
        DicesProbability p = new DicesProbability();
        p.printProbability(2);
    }

    private void printProbability(int n) {
        if (n < 1) {
            return;
        }
        int maxValue = 6;
        int[][] probabilities = new int[2][];
        probabilities[0] = new int[maxValue * n + 1];
        probabilities[1] = new int[maxValue * n + 1];
        int flag = 0;
        for (int i = 1; i < maxValue; i++) {
            probabilities[flag][i] = 1;
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= maxValue * k; i++) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(maxValue, n);
        for (int i = n; i < maxValue * n; i++) {
            double ratio = (double) probabilities[flag][i] / total;
            System.out.print(i + " ");
            System.out.println(ratio);

        }
    }
}
