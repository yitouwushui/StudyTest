package com.yitouwushui.arithmetic;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ding on 2017/10/16.
 */

public class PrintTreeFromTopToBottom {
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
        node4.leftNode = node5;
        node4.rightNode = node6;
        root1.value = 8;
        node1.value = 8;
        node2.value = 7;
        node3.value = 9;
        node4.value = 2;
        node5.value = 4;
        node6.value = 7;
        PrintTreeFromTopToBottom test = new PrintTreeFromTopToBottom();
        test.printFromTopToBottom(root1);
    }

    private void printFromTopToBottom(BinaryTreeNode root1) {
        if (root1 == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root1);
        while (!queue.isEmpty()){
            BinaryTreeNode binaryTreeNode = queue.poll();
            System.out.print(binaryTreeNode.value);
            if (binaryTreeNode.leftNode != null){
                queue.add(binaryTreeNode.leftNode);
            }
            if (binaryTreeNode.rightNode != null){
                queue.add(binaryTreeNode.rightNode);
            }
        }
    }
}
