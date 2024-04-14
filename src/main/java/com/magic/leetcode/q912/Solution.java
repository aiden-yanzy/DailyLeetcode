package com.magic.leetcode.q912;

import java.util.Arrays;

/**
 * Desc:
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 *  输入：nums = [5,2,3,1]
 *  输出：[1,2,3,5]
 *
 *  示例 2：
 *  输入：nums = [5,1,1,2,0,0]
 *  输出：[0,0,1,1,2,5]
 *
 * 提示：
 *  1 <= nums.length <= 5 * 10^4
 *  -5 * 10^4 <= nums[i] <= 5 * 10^4
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/sort-algorithms/eunjmt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * User: Yan Zeyu
 * DateTime: 2024/4/14 21:59
 * Since: V1
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        //bubbleSort(nums);
        selectSort(nums);
        return nums;
    }

    /**
     * 冒泡
     * @param nums
     */
    private void bubbleSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /**
     * 选择排序
     * @param nums
     */
    private void selectSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    private void insertSort(int[] nums){
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new Solution().sortArray(new int[]{5,2,3,1});
        System.out.println(Arrays.toString(nums));

        nums = new Solution().sortArray(new int[]{5,1,1,2,0,0});
        System.out.println(Arrays.toString(nums));
    }
}
