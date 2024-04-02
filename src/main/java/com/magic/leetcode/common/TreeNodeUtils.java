package com.magic.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : yanzeyu
 * @program: DailyLeetcode
 * @description:
 * @create: 2024/4/2 11:24
 */
public class TreeNodeUtils {

    public static void travers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null == node){
                    System.out.print("null ");
                }else {
                    System.out.print(node.val + " ");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int l, int r){
        if (l > r){
            return null;
        }

        int mi = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[mi]){
                mi = i;
            }
        }

        TreeNode root = new TreeNode(nums[mi]);
        root.left = helper(nums, l, mi - 1);
        root.right = helper(nums, mi + 1, r);
        return root;
    }
}
