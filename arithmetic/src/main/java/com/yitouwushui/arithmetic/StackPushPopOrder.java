package com.yitouwushui.arithmetic;

import java.util.Stack;

/**
 *
 * @author ding
 * @date 2017/10/13
 */
public class StackPushPopOrder {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 3, 5, 2, 1};
        StackPushPopOrder test = new StackPushPopOrder();
        System.out.println(test.isPopOrder(array1, array2));
    }

    private boolean isPopOrder(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }
        int point = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array2.length; i++) {
            if (!stack.isEmpty() && stack.peek() == array2[i]) {
                // 是栈顶
                stack.pop();
            } else {
                // 不是
                if (point == array1.length) {
                    // 数字已经全部使用完了
                    return false;
                } else {
                    // 数字没有使用完
                    stack.push(array1[point]);
                    point++;
                    while (stack.peek() != array2[i] && point != array1.length) {
                        stack.push(array1[point]);
                        point++;
                    }
                    if (stack.peek() == array2[i]) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}

