package com.magic.leetcode.q147;

import com.magic.leetcode.common.ListNode;

/**
 * Desc:
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 *
 * 插入排序 算法的步骤:
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 对链表进行插入排序。
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/sort-algorithms/euvypr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * User: Yan Zeyu
 * DateTime: 2024/4/14 22:51
 * Since: V1
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(-9999);
        while(head != null){
            int val = head.val;
            ListNode next = head.next;
            ListNode current = root;

            //下一个节点的值小于当前，继续遍历。已经到了节点末尾结束循环；
            while(current.next != null && current.next.val < val){
                current = current.next;
            }

            head.next = current.next;
            current.next = head;

            head = next;
        }

        return root.next;
    }
}
