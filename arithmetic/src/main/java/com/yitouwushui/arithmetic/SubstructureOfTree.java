package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/9/26.
 */

public class SubstructureOfTree {

    public static void main(String args[]) {
        //   root1
        //               8
        //             /   \
        //           8      7
        //         /   \
        //        9     2
        //             /  \
        //            4    7
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
        //   root2
        //           8
        //         /   \
        //        9     2
        BinaryTreeNode root2 = new BinaryTreeNode();
        BinaryTreeNode a = new BinaryTreeNode();
        BinaryTreeNode b = new BinaryTreeNode();
        root2.leftNode = a;
        root2.rightNode = b;
        root2.value = 8;
        a.value = 9;
        b.value = 2;
        SubstructureOfTree substructureOfTree = new SubstructureOfTree();
        System.out.println(substructureOfTree.hasSubTree(root1,root2));
    }

    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.value == root2.value) {
                // 检测根节点相等后，遍历子节点
                result = doesTree1HavaTree2(root1, root2);
                if (!result) {
                    // 递归左子树
                    result = hasSubTree(root1.leftNode, root2);
                }
                if (!result) {
                    // 递归右子树
                    result = hasSubTree(root1.rightNode, root2);
                }
            }
        }
        return result;
    }

    /**
     * 检测roo2是否为roo1子树
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean doesTree1HavaTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return doesTree1HavaTree2(root1.leftNode, root2.leftNode)
                && doesTree1HavaTree2(root1.rightNode, root2.rightNode);
    }
}
