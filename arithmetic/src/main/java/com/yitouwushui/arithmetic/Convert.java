package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/10/20.
 */

import com.yitouwushui.arithmetic.base.BinaryTreeNode;

/**
 * 二叉搜索树与双向链表
 * //        int[] pre={10,6,4,8,14,12,16};
 * //        int[] inOrder = {4,6,8,10,12,14,16};
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何结点，只能调整树中结点指针的指向。
 */
public class Convert {
    public static void main(String[] args) {

        BinaryTreeNode root1 = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        root1.leftNode = node1;
        root1.rightNode = node2;
        node1.leftNode = node3;
        node1.rightNode = node4;
        node2.leftNode = node5;
        node2.rightNode = node6;
        root1.value = 10;
        node1.value = 6;
        node2.value = 14;
        node3.value = 4;
        node4.value = 8;
        node5.value = 12;
        node6.value = 16;

        BinaryTreeNode head = convert(root1);
        BinaryTreeNode tail = null;
        System.out.println(head == null);
        while (head != null) {
            System.out.print(head.value + " ");
            tail = head;
            head = head.rightNode;
        }
        System.out.println();
        while (tail != null) {
            System.out.print(tail.value + " ");
            tail = tail.leftNode;
        }
    }

    public static BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNodeInList = null;
        lastNodeInList = convertNode(root, lastNodeInList);

        BinaryTreeNode headOfList = lastNodeInList;
        while (headOfList != null && headOfList.leftNode != null) {
            headOfList = headOfList.leftNode;
        }
        return headOfList;
    }

    public static BinaryTreeNode convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode current = node;
        if (current.leftNode != null) {
            lastNodeInList = convertNode(current.leftNode, lastNodeInList);
        }
        current.leftNode = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.rightNode = current;
        }
        lastNodeInList = current;
        if (current.rightNode != null) {
            lastNodeInList = convertNode(current.rightNode, lastNodeInList);
        }
        return lastNodeInList;
    }
}