package com.magic.leetcode.q121;

/**
 * 买卖股票的最佳时机
 * 
 * @Description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 *              如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 *              注意：你不能在买入股票前卖出股票。
 *
 *               
 *
 *              示例 1:
 *
 *              输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。 注意利润不能是 7-1 =
 *              6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。 示例 2:
 *
 *              输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 *              著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/18 周五
 * @Version v0.1
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int highest = Integer.MIN_VALUE;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                highest = Math.max(highest, prices[j] - prices[i]);
            }
        }
        if (highest < 0) {
            highest = 0;
        }

        return highest;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int len = prices.length;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - lowest);
            }
        }
        if (maxProfit < 0) {
            return 0;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit1(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit1(new int[] {7, 6, 4, 3, 1}));
    }
}
