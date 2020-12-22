package com.magic.leetcode.q64;

/**
 * 最小路径和
 * 
 * @Description
 * 
 *              给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 *              说明：每次只能向下或者向右移动一步。
 *
 *               
 *
 *              示例 1：
 *
 *
 *              输入：grid = [[1,3,1],[1,5,1],[4,2,1]] 输出：7 解释：因为路径 1→3→1→1→1 的总和最小。
 * 
 *              示例 2：
 *
 *              输入：grid = [[1,2,3],[4,5,6]] 输出：12  
 *
 *              提示：
 *
 *              m == grid.length n == grid[i].length 1 <= m, n <= 200 0 <= grid[i][j] <= 100
 *
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-path-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/22 周二
 * @Version v0.1
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(solution.minPathSum(new int[][] {{1, 2, 3}, {4, 5, 6}}));
    }
}
