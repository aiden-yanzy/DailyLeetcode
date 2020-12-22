package com.magic.leetcode.q120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三角形最小路径和
 *
 * @Description 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *              <p>
 *              相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *              <p>
 *              例如，给定三角形：
 *              <p>
 *              [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *              <p>
 *              说明：
 *              <p>
 *              如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *              <p>
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/triangle 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/22 周二
 * @Version v0.1
 */
public class Solution {
    /**
     * 没做出来 参照题解
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() < 2) {
            return triangle.get(0).get(0);
        }
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = triangle.get(1).get(0) + dp[0][0];
        dp[1][1] = triangle.get(1).get(1) + dp[0][0];
        for (int i = 2; i < size; i++) {
            List<Integer> curList = triangle.get(i);
            int length = curList.size();
            dp[i][0] = dp[i - 1][0] + curList.get(0);
            for (int j = 1; j < length - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            dp[i][length - 1] = dp[i - 1][length - 1 - 1] + curList.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp[size - 1]) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    /**
     * 空间优化
     * 
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() < 2) {
            return triangle.get(0).get(0);
        }

        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0) + triangle.get(1).get(0);
        dp[1] = triangle.get(0).get(0) + triangle.get(1).get(1);
        for (int i = 2; i < size; i++) {
            List<Integer> curList = triangle.get(i);
            int length = curList.size();
            dp[length - 1] = dp[length - 1 - 1] + curList.get(length - 1);
            for (int j = length - 2; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + curList.get(j);
            }
            dp[0] = dp[0] + curList.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    /**
     * 逆向
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {

        int size = triangle.size();
        int[] dp = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal2(Arrays.asList(Collections.singletonList(2), Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
    }
}
