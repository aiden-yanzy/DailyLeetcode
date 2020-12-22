package com.magic.leetcode.q27;

import java.util.Arrays;

/**
 * 移除元素
 * 
 * @Description 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 *              不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 *              元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *               
 *
 *              示例 1:
 *
 *              给定 nums = [3,2,2,3], val = 3,
 *
 *              函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 *              你不需要考虑数组中超出新长度后面的元素。
 * 
 *              示例 2:
 *
 *              给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 *              函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 *              注意这五个元素可为任意顺序。
 *
 *              你不需要考虑数组中超出新长度后面的元素。  
 *
 *              说明:
 *
 *              为什么返回数值是整数，但输出的答案是数组呢?
 *
 *              请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 *              你可以想象内部操作如下:
 *
 *              // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝 int len = removeElement(nums, val);
 *
 *              // 在函数里修改输入数组对于调用者是可见的。 // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。 for (int i = 0; i < len; i++) {    
 *              print(nums[i]); }
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-element 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/16 周三
 * @Version v0.1
 */
public class Solution {
    /**
     * 自己写的 每次有目标值就把后边的数组都向前移动一位 并且长度数组长度减一 否则指针向前移动
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length < 1) {
            return 0;
        }
        int count = nums.length;
        int i = 0;
        while (i < count) {
            if (nums[i] == val) {
                // for (int j = i + 1; j < count; j++) {
                // nums[i] = nums[j];
                // }
                System.arraycopy(nums, i + 1, nums, i, count - i - 1);
                count--;
            } else {
                i++;
            }
            System.out.println(Arrays.toString(nums));
        }
        return count;
    }

    /**
     * 参照题解方案 双指针 慢直接放非目标的值 快指针遍历数组
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        if (null == nums || nums.length < 1) {
            return 0;
        }
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            // System.out.println(Arrays.toString(nums));
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement1(new int[] {3, 2, 2, 3}, 3));
    }
}
