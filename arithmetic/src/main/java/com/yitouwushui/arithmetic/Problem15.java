package com.yitouwushui.arithmetic;

/**
 * Created by ding on 2017/8/24.
 * 题目：输入一个链表，输出该链表中倒数第 k 个结点。为了符合大多数人的习惯，
 * 本题从 1 开始计数，即链表的尾结点是倒数第一个结点。例如一个有 6 个结点的
 * 链表，从头结点依次是 1,2,3,4，5,6,7。倒数第三个结点就是值为 4 的结点
 */

public class Problem15 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        ListNode node7 = new ListNode();
        ListNode node8 = new ListNode();
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;
        node5.nextNode = node6;
        node6.nextNode = node7;
        node7.nextNode = node8;
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node5.data = 5;
        node6.data = 6;
        node7.data = 7;
        node8.data = 8;
        Problem15 test = new Problem15();
        //***********1**********
//        ListNode resultListNode = test.findKToTail(node1, 5);
//        System.out.println("结果:" + (resultListNode == null ? null : resultListNode.data));

        // **************2***********
//        boolean b = test.isRing(node1);
//        System.out.println("结果:" + b);

        //*************3***********
        ListNode resultListNode = test.reverseList(node1);
        System.out.println("结果:" + (resultListNode == null ? null : resultListNode.data));

        System.out.println(((Long)1000L) == 1000);
        System.out.println(((Long)1000L) == Long.valueOf(1000));
        System.out.println(new Long(1).equals(1L));


    }

    private ListNode findKToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode resultNode = null;
        ListNode firstNode = head;
        for (int i = 0; i < k; i++) {
            // 先让头结点走k-1步
            if (firstNode != null) {
                firstNode = firstNode.nextNode;
            } else {
                return null;
            }
        }
        resultNode = head;
        while (firstNode != null) {
            resultNode = resultNode.nextNode;
            firstNode = firstNode.nextNode;
        }
        return resultNode;
    }
     /// 

    /**
     * 判断是否有环
     *
     * @param head
     * @return
     */
    private boolean isRing(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode first = head;
        ListNode two = null;
        if (head.nextNode != null) {
            two = head.nextNode;
        } else {
            return false;
        }
        int count = 0;
        while (first != two) {
            count++;
            if (two.nextNode != null) {
                two = two.nextNode;
            } else {
                return false;
            }
            if (two.nextNode != null) {
                two = two.nextNode;
            } else {
                return false;
            }
            if (first.nextNode != null) {
                first = first.nextNode;
            }
        }
        System.out.println(count);
        return true;
    }

    /**
     * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.nextNode == null) {
            return head;
        }
        ListNode preListNode = null;
        ListNode currentListNode = head;
        while (currentListNode.nextNode != null) {
            ListNode nextListNode = currentListNode.nextNode;
            // 记录上一个
            currentListNode.nextNode = preListNode;
            // 本次变为上一个
            preListNode = currentListNode;
            // 下一个为下一次循环
            currentListNode = nextListNode;
        }
        return currentListNode;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if (head1.data < head2.data) {
            mergeHead = head1;
            mergeHead.nextNode = mergeList(head1.nextNode, head2);
        } else {
            mergeHead = head2;
            mergeHead.nextNode = mergeList(head1, head2.nextNode);
        }
        return mergeHead;
    }

}
