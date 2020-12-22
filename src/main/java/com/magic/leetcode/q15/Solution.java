package com.magic.leetcode.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 *
 * @Description 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *              <p>
 *              注意：答案中不可以包含重复的三元组。
 *              <p>
 *              示例：
 *              <p>
 *              给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *              <p>
 *              满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *              <p>
 *              <p>
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/17 周四
 * @Version v0.1
 */
public class Solution {
    /**
     * 自己写的三层循环 超时了
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> rsList = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int a = -nums[i];
            for (int j = i + 1; j < length - 1; j++) {
                int b = a - nums[j];
                for (int k = j + 1; k < length; k++) {
                    if (nums[k] == b) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        // 判重
                        if (!rsList.contains(temp)) {
                            rsList.add(temp);
                        }
                    }
                }
            }
        }
        return rsList;
    }

    /**
     * 参照解题
     * <p>
     * 以排序 加前后判重消除循环和去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if (null == nums || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> rsList = new ArrayList<>();
        int length = nums.length;
        // a大于0之后 后边的结果不可能小于0
        for (int i = 0; i < length && nums[i] <= 0; i++) {
            // 保证a不重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            // 第3个值从右往左找
            int k = length - 1;
            for (int j = i + 1; j < length; j++) {
                // 保证b不重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 左移指针 让和减小
                while (j < k && (nums[k] + nums[j]) > target) {
                    k--;
                }
                // 指针相碰说明 没有满足的和
                if (j == k) {
                    break;
                }

                if (nums[k] + nums[j] == target) {
                    rsList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return rsList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum1(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
