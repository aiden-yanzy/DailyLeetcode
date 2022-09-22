package com.magic.leetcode.q1094;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: DailyLeetcode
 * @description:
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/car-pooling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yanzeyu
 * @create: 2022/9/16 20:13
 */
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int[]trip : trips){
            int c1 = countMap.getOrDefault(trip[1], 0) + trip[0];
            countMap.put(trip[1], c1);

            int c2 = countMap.getOrDefault(trip[2], 0) - trip[0];
            countMap.put(trip[2], c2);
        }

        List<Integer> sortedStopList = countMap.keySet().stream().distinct().sorted().collect(Collectors.toList());

        int count = 0;
        for (int i: sortedStopList) {
            count += countMap.get(i);

            if (count > capacity){
                return false;
            }
        }

        return true;
    }

    /**
     * [[9,3,4],[9,1,7],[4,2,4],[7,4,5]]
     * 23
     * @param args
     */
    public static void main(String[] args) {
       // new Solution().carPooling(new int[][]{new int[]{9,3,4}, new int[]{9,1,7}})
        System.out.println(10 / 3);
    }

}
