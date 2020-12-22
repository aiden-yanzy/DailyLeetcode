package com.magic.leetcode.q70;

/**
 * 爬楼梯
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶
 * 
 * 示例 2：
 *
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
 *
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/climbing-stairs 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @Description
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/21 周一
 * @Version v0.1
 */
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int p;
        int q = 1;
        int r = 2;
        for (int i = 2; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs1(5));
        System.out.println(solution.climbStairs1(4));
    }
}
