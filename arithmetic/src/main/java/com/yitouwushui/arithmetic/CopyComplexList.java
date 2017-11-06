package com.yitouwushui.arithmetic;

import com.yitouwushui.arithmetic.base.ComplexListNode;

/**
 * @author ding
 * @date 2017/10/18
 * 题目：实现函数复制一个复杂链表。在复杂链表中，每个结点除了有一个 next
 * 指针指向下一个结点外，还有一个指向链表中任意结点或 null。
 */
public class CopyComplexList {

    public static void main(String[] args) {
        CopyComplexList testClone = new CopyComplexList();
        ComplexListNode root = new ComplexListNode();
        ComplexListNode node1 = new ComplexListNode();
        ComplexListNode node2 = new ComplexListNode();
        ComplexListNode node3 = new ComplexListNode();
        ComplexListNode node4 = new ComplexListNode();
        root.data = 1;
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        root.data = 1;
        node1.data = 2;
        node2.data = 3;
        node3.data = 4;
        node4.data = 5;
        root.sibling = node2;
        node1.sibling = node4;
        node3.sibling = node1;
        ComplexListNode result = testClone.clone(root);
        System.out.println(result);
    }

    private ComplexListNode clone(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        //克隆节点
        cloneNodes(head);
        //克隆指向链表
        connectSiblingNodes(head);
        // 拆分
        return reconnectNodes(head);
    }

    /**
     * 克隆节点
     *
     * @param head
     */
    private void cloneNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloneNode = new ComplexListNode();
            cloneNode.data = node.data;
            cloneNode.next = node.next;
            cloneNode.sibling = null;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    /**
     * 克隆邻节点
     *
     * @param head
     */
    private void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloneNode = node.next;
            if (node.sibling != null) {
                cloneNode.sibling = node.sibling;
            }
            node = cloneNode.next;
        }
    }

    /**
     * 拆分复制链表
     *
     * @param head
     * @return
     */
    private ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode clonedHead = null;
        ComplexListNode clonedNode = null;
        if (node != null) {
            clonedNode = node.next;
            clonedHead = clonedNode;
            node.next = clonedNode.next;
            node = node.next;
        }
        // clonedHead 原链表第二个节点(n')   node  原链表第一个节点 (n)  node.next(原链表第三个节点n2,变为n1)
        while (node != null) {
            // node为n  clonedNode为clonedHead(首次)   node.next为n'
            clonedNode.next = node.next;
            // clonedNode 为n'
            clonedNode = clonedNode.next;

            // 拿到新一个n节点
            node.next = clonedNode.next;
            //移动为下一个
            node = node.next;
        }
        return clonedHead;
    }
}
