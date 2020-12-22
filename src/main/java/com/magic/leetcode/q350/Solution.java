package com.magic.leetcode.q350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集 II
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2] 输出：[2,2] 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出：[4,9]  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 我们可以不考虑输出结果的顺序。 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？ 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Description
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/16 周三
 * @Version v0.1
 */
public class Solution {
    /**
     * 使用map来统计
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Map<Integer, Integer> numMap = new HashMap<>(len1);
        for (int key : nums1) {
            Integer cnt = numMap.putIfAbsent(key, 1);
            // 已经有的累加
            if (null != cnt) {
                numMap.put(key, cnt + 1);
            }
        }
        // System.out.println(numMap);
        int[] intersectArr = new int[Math.min(len1, len2)];
        int idx = 0;
        for (int key : nums2) {
            Integer cnt = numMap.get(key);
            if (cnt == null || cnt <= 0) {
                continue;
            }
            intersectArr[idx++] = key;
            numMap.put(key, --cnt);
        }
        return Arrays.copyOfRange(intersectArr, 0, idx);
    }

    /**
     * 排序之后双指针查找
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0, i = 0, j = 0;
        int[] intersectArr = new int[Math.min(len1, len2)];
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersectArr[index++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(intersectArr, 0, index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect2(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
        System.out.println(Arrays.toString(solution.intersect2(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
    }
}
