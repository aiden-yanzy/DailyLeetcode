package com.magic.leetcode.q215;

/**
 * Desc:
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 *  输入: [3,2,1,5,6,4], k = 2
 *  输出: 5
 *
 * 示例 2:
 *  输入: [3,2,3,1,2,4,5,5,6], k = 4
 *  输出: 4
 *
 *  提示：
 *  1 <= k <= nums.length <= 105
 *  -104 <= nums[i] <= 104
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/sort-algorithms/osxtdc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * User: Yan Zeyu
 * DateTime: 2024/4/14 21:17
 * Since: V1
 */
public class Solution {
//  选择排序的方式 时间复杂度 n^2 不满足条件
//    public int findKthLargest(int[] nums, int k) {
//        int length = nums.length;
//
//        for (int i = length - 1; i >= length - k; i--) {
//            int maxIdx = i;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] > nums[maxIdx]) {
//                    maxIdx = j;
//                }
//            }
//            swap(nums, i, maxIdx);
//        }
//
//        return nums[length - k];
//    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

    }
}
