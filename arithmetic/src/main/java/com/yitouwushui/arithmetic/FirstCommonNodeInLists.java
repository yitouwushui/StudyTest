package com.yitouwushui.arithmetic;

import com.yitouwushui.arithmetic.base.ListNode;

import java.util.List;

/**
 * @author ding
 * @date 2017/11/2
 * 题目：输入两个链表，找出它们的第一个公共结点。
 */

public class FirstCommonNodeInLists {

    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        ListNode second1 = new ListNode();
        ListNode third1 = new ListNode();
        ListNode forth1 = new ListNode();
        ListNode fifth1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode second2 = new ListNode();
        ListNode third2 = new ListNode();
        ListNode forth2 = new ListNode();
        head1.nextNode = second1;
        second1.nextNode = third1;
        third1.nextNode = forth1;
        forth1.nextNode = fifth1;
        head2.nextNode = second2;
        second2.nextNode = forth1;
        third2.nextNode = fifth1;
        head1.data = 1;
        second1.data = 2;
        third1.data = 3;
        forth1.data = 6;
        fifth1.data = 7;
        head2.data = 4;
        second2.data = 5;
        third2.data = 6;
        forth2.data = 7;
        FirstCommonNodeInLists test = new FirstCommonNodeInLists();
        // 测试，null节点， 两个数组长度相同，不同的情况下
        ListNode result = test.findFirstCommonNode(head1, head2);
        System.out.println(result == null ? null : result.data);
    }

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getNodeLength(head1);
        int length2 = getNodeLength(head2);
        int dif = 0;
        ListNode longListNode = null;
        ListNode shortListNode = null;
        if (length1 > length2) {
            dif = length1 - length2;
            longListNode = head1;
            shortListNode = head2;
        } else {
            dif = length2 - length1;
            longListNode = head2;
            shortListNode = head1;
        }
        for (int i = 0; i < dif; i++) {
            longListNode = longListNode.nextNode;
        }
        while (longListNode != null && shortListNode != null && longListNode != shortListNode) {
            longListNode = longListNode.nextNode;
            shortListNode = shortListNode.nextNode;
        }
        return longListNode;
    }

    private int getNodeLength(ListNode head1) {
        int result = 0;
        if (head1 == null) {
            return result;
        }
        ListNode node = head1;
        while (node != null) {
            node = node.nextNode;
            result++;
        }
        return result;
    }
}
