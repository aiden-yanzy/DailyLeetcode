package com.magic.leetcode.common;

/**
 * Desc:
 * <p>
 * User: Yan Zeyu
 * DateTime: 2024/4/14 22:53
 * Since: V1
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) {
        this.val = x;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
