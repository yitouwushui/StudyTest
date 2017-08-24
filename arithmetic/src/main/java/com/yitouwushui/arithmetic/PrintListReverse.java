package com.yitouwushui.arithmetic;

import java.util.Stack;

/**
 * Created by yitouwushui on 2017/8/8.
 */

public class PrintListReverse {


    public static void printListReverse(ListNode headNode) {
        Stack<ListNode> stack = new Stack<>();
        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.nextNode;
        }
        while (!stack.empty()) {
            System.out.print(stack.pop().data);
        }
    }

    public static void printListReverse2(ListNode headNode) {
        if (headNode != null) {
            if (headNode.nextNode != null) {
                printListReverse2(headNode.nextNode);
            }
            System.out.print(headNode.data);
        }
    }

    public static void main(String args[]) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
//        printListReverse(node1);
        printListReverse2(node1);
    }
}
