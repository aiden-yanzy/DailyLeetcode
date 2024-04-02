package com.magic.leetcode.q654;

import com.magic.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最大二叉树
 *
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *   创建一个根节点，其值为 nums 中的最大值。
 *   递归地在最大值 左边 的 子数组前缀上 构建左子树。
 *   递归地在最大值 右边 的 子数组后缀上 构建右子树。
 *   返回 nums 构建的 最大二叉树 。
 *
 * @author : yanzeyu
 * @program: DailyLeetcode
 * @description:
 * @create: 2024/4/1 10:28
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r){
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
