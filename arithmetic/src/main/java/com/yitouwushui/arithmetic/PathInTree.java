package com.yitouwushui.arithmetic;

import com.yitouwushui.arithmetic.base.BinaryTreeNode;

import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根节点开始往下一直到叶结点所经过的结点形成一条路径
 *
 * @author ding
 * @date 2017/10/18
 */
public class PathInTree {

    public static void main(String args[]) {

        BinaryTreeNode root1 = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        root1.leftNode = node1;
        root1.rightNode = node2;
        node1.leftNode = node3;
        node1.rightNode = node4;
        root1.value = 10;
        node1.value = 5;
        node2.value = 12;
        node3.value = 4;
        node4.value = 7;
        PathInTree testFindPath = new PathInTree();
        testFindPath.findPath(root1, 22);
    }

    private void findPath(BinaryTreeNode root, int sum) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        findPath(root, sum, stack, currentSum);
    }

    private void findPath(BinaryTreeNode root, int sum, Stack<Integer> stack, int currentSum) {
        currentSum += root.value;
        stack.push(root.value);
        if (root.leftNode == null && root.rightNode == null) {
            // 如果没有子节点
            if (currentSum == sum) {
                System.out.print("找到一个子节点");
                for (Integer path : stack) {
                    System.out.print(path + " ");
                }
                System.out.println("");
            }
        }
        if (root.leftNode != null){
            findPath(root.leftNode,sum,stack,currentSum);
        }
        if (root.rightNode != null){
            findPath(root.rightNode,sum,stack,currentSum);
        }
        stack.pop();
    }
}
