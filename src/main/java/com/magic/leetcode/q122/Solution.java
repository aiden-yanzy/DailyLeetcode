package com.magic.leetcode.q122;

/**
 * 买卖股票的最佳时机 II
 * 
 * @Description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 *              设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 *              注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *               
 *
 *              示例 1:
 *
 *              输入: [7,1,5,3,6,4] 输出: 7 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   随后，在第4
 *              天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 
 *              示例 2:
 *
 *              输入: [1,2,3,4,5] 输出: 4 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 * 
 *              注意你不能在第1 天和第 2 天接连购买股票，之后再将它们卖出。  
 * 
 *              因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 
 *              示例 3:
 *
 *              输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。  
 *
 *              提示：
 *
 *              1 <= prices.length <= 3 * 10 ^ 4 0 <= prices[i] <= 10 ^ 4
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *              著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/16 周三
 * @Version v0.1
 */
public class Solution {

    /**
     * 参照题解解决
     * 
     * 每天交易之后 只有两种状态持有股票 或者不持有股票 最终的结果其实是手中的现金数
     * 
     * dp[i][0]表示第i天交易之后不持有股票时的现金数,可能前一天就没有持有,也可能前一天持有今天卖出了; 因此dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + price[i]);
     * 
     * dp[i][1]表示第i天交易之后持有股票时的现金数,可能前一天就持有,也可能前一天没有持有今天买入了;因此dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - price[i]);
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        // 交易后不持有股票时的现金
        int dp1 = 0;
        // 交易后持有股票的时候的现金
        int dp2 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            dp1 = Math.max(dp1, dp2 + prices[i]);
            dp2 = Math.max(dp2, dp1 - prices[i]);
        }
        return dp1;
    }

    /**
     * 参照题解 贪心算法
     * 
     * 对于升序数组prices[5] rs = price[4]-price[0] = (price[1]-price[0]) + (price[2] - price[1]) + (price[3] - price[2]) +
     * (price[4] - price[3]);
     * 
     * 在上升区间的加和即使最大收益, 忽略非上升区间
     * 
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }
        int length = prices.length;
        int sum = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit1(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit1(new int[] {1, 2, 3, 4, 5}));
        System.out.println(solution.maxProfit1(new int[] {7, 6, 4, 3, 1}));
    }
}
