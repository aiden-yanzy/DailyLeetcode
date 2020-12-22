package com.magic.leetcode.q21;

/**
 * 合并两个有序链表
 * 
 * @Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *               
 *
 *              示例：
 *
 *              输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 *
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *              著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/20 周日
 * @Version v0.1
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode pre = root;
        while (l1 != null && null != l2) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;
        return root.next;
    }

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */

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
