package com.magic.leetcode.q53;

import java.util.Arrays;

/**
 * 最大子序和
 * 
 * @Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *              示例:
 *
 *              输入: [-2,1,-3,4,-1,2,1,-5,4] 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 *              进阶:
 *
 *              如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-subarray 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/21 周一
 * @Version v0.1
 */
public class Solution {
    /**
     * 超出内存限制;
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[][] matrix = new int[length][length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            matrix[i][i] = nums[i];
            max = Math.max(nums[i], max);
            for (int j = i + 1; j < length; j++) {
                matrix[i][j] = nums[j] + matrix[i][j - 1];
                max = Math.max(max, matrix[i][j]);
            }
        }
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

        return max;
    }

    public int maxSubArray1(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int last = nums[i];
            max = Math.max(last, max);
            for (int j = i + 1; j < length; j++) {
                last = nums[j] + last;
                max = Math.max(max, last);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        // dp[i]表示以i为结尾的最大和 要么是节点i要么是dp[i-1]
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            if (max < pre) {
                max = pre;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray3(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
