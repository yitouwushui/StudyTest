package com.yitouwushui.arithmetic;

import com.yitouwushui.arithmetic.base.BinaryTreeNode;

/**
 * @author ding
 * @date 2017/10/20
 */

public class ConvertBinarySearchTree {

    public static void main(String args[]) {
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
        ConvertBinarySearchTree test = new ConvertBinarySearchTree();
        BinaryTreeNode head = test.convert(root1);
        BinaryTreeNode tail = null;
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

    public BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNodeList = convertNode(root, null);
        while (lastNodeList != null && lastNodeList.leftNode != null) {
            lastNodeList = lastNodeList.leftNode;
        }
        return lastNodeList;
    }

    private BinaryTreeNode convertNode(BinaryTreeNode current, BinaryTreeNode lastNodeList) {
        if (current == null) {
            return null;
        }
        if (current.leftNode != null) {
            lastNodeList = convertNode(current.leftNode, lastNodeList);
        }
        current.leftNode = lastNodeList;
        if (lastNodeList != null) {
            lastNodeList.rightNode = current;
        }
        lastNodeList = current;
        if (current.rightNode != null) {
            lastNodeList = convertNode(current.rightNode, lastNodeList);
        }
        return lastNodeList;
    }
}
