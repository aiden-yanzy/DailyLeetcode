package com.magic.leetcode.q19;

/**
 * 删除链表的倒数第N个节点
 * 
 * @Description
 * 
 *              给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 *              示例：
 *
 *              给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 *              当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
 *
 *              给定的 n 保证是有效的。
 *
 *              进阶：
 *
 *              你能尝试使用一趟扫描实现吗？
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *              著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/18 周五
 * @Version v0.1
 */
public class Solution {
    /**
     * 快慢指针+哨兵节点
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode slow = root;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return root.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode pre = root;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = slow;
        }
        pre.next = slow.next;
        return root.next;
    }

    /**
     * Definition for singly-linked list.
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
