package com.magic.leetcode.q189;

import java.util.Arrays;

/**
 * 旋转数组
 * 
 * @Description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *              示例 1:
 *
 *              输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步: [6,7,1,2,3,4,5]
 *              向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 *              示例 2:
 *
 *              输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释: 向右旋转 1 步: [99,-1,-100,3] 向右旋转 2 步: [3,99,-1,-100]
 * 
 *              说明:
 *
 *              尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-array 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/16 周三
 * @Version v0.1
 */
public class Solution {
    /**
     * 自己写的 正向思维 按照题目要求直接写
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        for (int i = 0; i < k; i++) {
            int cur = nums[length - 1];
            // 从原来的0开始 拷贝到目标1开始 长度为length-1
            System.arraycopy(nums, 0, nums, 1, length - 1);
            nums[0] = cur;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 部分参照题解 开始时没考虑k大于length的情况 报错
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int n = k % length;

        int[] temp = new int[k];
        System.arraycopy(nums, length - n, temp, 0, n);
        System.arraycopy(nums, 0, nums, n, length - n);
        System.arraycopy(temp, 0, nums, 0, n);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 1 2 3 4 5 6 7 => 4 3 2 1 7 6 5 => 5 6 7 1 2 3 4
     * 
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int n = k % length;

        reverse(nums, 0, length - n);
        reverse(nums, length - n, length);
        reverse(nums, 0, length);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 执行对调逻辑
     * 
     * @param nums
     * @param begin
     * @param bound
     *            上界 不包含
     */
    private void reverse(int[] nums, int begin, int bound) {
        int len = (bound - begin) / 2;
        for (int i = 0; i < len; i++) {
            int temp = nums[begin + i];
            nums[begin + i] = nums[bound - 1 - i];
            nums[bound - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate2(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
