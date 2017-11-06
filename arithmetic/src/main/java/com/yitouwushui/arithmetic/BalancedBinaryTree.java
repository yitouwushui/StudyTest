package com.yitouwushui.arithmetic;

import com.yitouwushui.arithmetic.base.BinaryTreeNode;

/**
 * Created by ding on 2017/11/3.
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树
 * 中任意结点的左右子树的深度相差不超过1，那么他就是一棵平衡二叉树。
 */

public class BalancedBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        root.leftNode = node1;
        root.rightNode = node2;
        node1.leftNode = node3;
        node1.rightNode = node4;
        node2.rightNode = node5;
        node4.leftNode = node6;
        root.value = 1;
        node1.value = 2;
        node2.value = 3;
        node3.value = 4;
        node4.value = 5;
        node5.value = 6;
        node6.value = 7;
        BalancedBinaryTree p = new BalancedBinaryTree();
        System.out.println(p.isBalanced(root));
    }

    private boolean isBalanced(BinaryTreeNode root) {
        int depth = 0;
        return isBalanced(root, depth);
    }

    private boolean isBalanced(BinaryTreeNode root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        if (isBalanced(root.leftNode, left) && isBalanced(root.rightNode, right)) {
            int diff = left - right;
            if (diff <= 1 && diff >= -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

}
