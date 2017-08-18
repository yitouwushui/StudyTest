package com.yitouwushui.arithmetic;

import java.util.ArrayList;

/**
 * Created by ding on 2017/8/18.
 */

public class XiaoHei {
    Long[] array = new Long[]{
            1L, 2L, 5L,
            10L, 20L, 50L,
            100L, 200L, 500L,
            1000L, 2000L, 5000L,
            10000L, 50000L,
            100000L, 500000L,
            1000000L, 2000000L, 5000000L,
            10000000L, 50000000L,
            100000000L, 500000000L,
            1000000000L, 2000000000L,
            10000000000L, 20000000000L, 50000000000L};

    public ArrayList<Long> getBreakArray(long num) throws Exception {
        ArrayList<Long> list;
        if (num < 8L) {
            throw new Exception("数值不符合拆分要求");
        }
        list = breakNumber(num);
        int count = 8 - list.size();
        while (count > 0) {
            // 如果个数不满足8个
            Long numIndex = getFirstNumberLessTarget(list.get(0) / count);
            Long remainder = list.get(0) - numIndex * count;
            list.remove(0);
            while (count > 0) {
                list.add(numIndex);
                count--;
            }
            list.addAll(breakNumber(remainder));
            count = 8 - list.size();
        }
        return list;
    }

    /**
     * 对数值进行取余
     *
     * @param temp
     * @return
     */
    private ArrayList<Long> breakNumber(Long temp) {
        ArrayList<Long> list = new ArrayList<>();
        int digits = temp.toString().length() - 1;
        while (temp != 0) {
            long quotient = temp / tenDigits(digits) * tenDigits(digits);
            if (!checkContains(quotient)) {
                // 余数不满足
                Long num5 = 5 * tenDigits(digits);
                Long num2 = 2 * tenDigits(digits);
                Long num1 = tenDigits(digits);
                if (checkContains(num5) && quotient > num5) {
                    quotient = quotient - num5;
                    list.add(num5);
                }
                while (checkContains(num2) && quotient >= num2) {
                    quotient = quotient - num2;
                    list.add(num2);
                }
                while (checkContains(num1) && quotient >= num1) {
                    quotient = quotient - num1;
                    list.add(num1);
                }
            } else {
                // 余数满足
                if (quotient != 0) {
                    list.add(quotient);
                }
            }
            temp = temp - temp / tenDigits(digits) * tenDigits(digits);
            digits--;
        }
        return list;
    }

    private long tenDigits(int digits) {
        if (digits == 0) {
            return 1;
        }
        Long temp = 10L;
        for (int i = digits - 1; i > 0; i--) {
            temp = 10 * temp;
        }
        return temp;
    }

    private boolean checkContains(long n) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }

    private Long getFirstNumberLessTarget(long target) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < target) {
                return array[i];
            }
        }
        return 1L;
    }

    private static void logArrayList(Long number, ArrayList<Long> list) {
        System.out.print("数值" + number + "拆分成");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("," + list.get(i));
        }
        System.out.println();

    }

    public static void main(String args[]) throws Exception {
        XiaoHei heiGui = new XiaoHei();
        Long num = 1600000L;
        ArrayList<Long> list = heiGui.getBreakArray(num);

        // 下面是打印校验
        logArrayList(num, list);
        Long num2 = 0L;
        for (int i = 0; i < list.size(); i++) {
            num2 += list.get(i);
        }
        System.out.println("检验数值num2:" + num2 + "    num1等于num2:" + (num.equals(num2)));
    }
}
