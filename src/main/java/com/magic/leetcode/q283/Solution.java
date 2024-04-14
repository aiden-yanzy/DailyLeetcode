package com.magic.leetcode.q283;

import java.util.Arrays;

/**
 * Desc:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *  输入: nums = [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 *
 * 提示:
 *  1 <= nums.length <= 104
 *  -231 <= nums[i] <= 231 - 1
 *
 * User: Yan Zeyu
 * DateTime: 2024/4/13 19:15
 * Since: V1
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        //记录0的个数
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            //如果前边存在cnt个0，则将i移动到i-cnt的位置
            if (nums[i] != 0) {
                nums[i - cnt] = nums[i];
            //当前为0 cnt++
            }else {
                cnt++;
            }
        }
        // [len-cnt, len)的值应该赋值为0
        for (int i = len - cnt; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(nums));
        solution.moveZeroes(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
