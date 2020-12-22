package com.magic.leetcode.q141;

/**
 * @Description
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/20 周日
 * @Version v0.1
 */
public class Solution {
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

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
