package com.magic.leetcode.q2;

/**
 * @Description
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/21 周一
 * @Version v0.1
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode pre = root;
        int addition = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + addition;
            l1.val = temp % 10;
            addition = temp / 10;
            pre.next = l1;
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        while (l1 != null) {
            int temp = l1.val + addition;
            l1.val = temp % 10;
            addition = temp / 10;
            pre.next = l1;
            l1 = l1.next;
            pre = pre.next;
        }

        while (l2 != null) {
            int temp = l2.val + addition;
            l2.val = temp % 10;
            addition = temp / 10;
            pre.next = l2;
            l2 = l2.next;
            pre = pre.next;
        }

        if (addition > 0) {
            pre.next = new ListNode(1);
        }
        return root.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode pre = root;
        int addition = 0;
        while (l1 != null || l2 != null || addition > 0) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            temp += addition;
            pre.next = new ListNode(temp % 10);
            addition = temp / 10;
            pre = pre.next;
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
