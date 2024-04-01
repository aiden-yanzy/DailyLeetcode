package com.magic.leetcode.q84;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 084. 全排列 II
 * 中等
 * 56
 * 相关企业
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author : yanzeyu
 * @program: DailyLeetcode
 * @description:
 * @create: 2023/9/7 15:23
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] history = new int[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), history, ans);
        return ans;
    }

    public void helper(int[] nums, List<Integer> res, int[] history, List<List<Integer>> ans) {
        int len = nums.length;
        if (res.size() == len) {

            if (ans.contains(res)){
                return;
            }

            ans.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (history[i] == 0) {
                res.add(nums[i]);
                history[i] = 1;
                helper(nums, res, history, ans);
                res.remove(res.size() - 1);
                history[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);

        int[] nums2 = {1, 2, 3};
        List<List<Integer>> lists2 = solution.permuteUnique(nums2);
        System.out.println(lists2);
    }
}
