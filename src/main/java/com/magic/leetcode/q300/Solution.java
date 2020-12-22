package com.magic.leetcode.q300;

/**
 * 最长递增子序列
 *
 * @Description 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *              <p>
 *              子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *              <p>
 *              示例 1：
 *              <p>
 *              输入：nums = [10,9,2,5,3,7,101,18] 输出：4 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 
 *              示例 2：
 *              <p>
 *              输入：nums = [0,1,0,3,2,3] 输出：4
 *              <p>
 * 
 *              示例 3：
 *              <p>
 *              输入：nums = [7,7,7,7,7,7,7] 输出：1  
 *              <p>
 *              提示：
 *              <p>
 *              1 <= nums.length <= 2500 -104 <= nums[i] <= 104  
 *              <p>
 *              进阶：
 *              <p>
 *              你可以设计时间复杂度为 O(n2) 的解决方案吗？ 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *              <p>
 *              <p>
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *              著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/21 周一
 * @Version v0.1
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int max = 1;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
        System.out.println(solution.lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }
}
