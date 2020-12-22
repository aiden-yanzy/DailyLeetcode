package com.magic.leetcode.q14;

/**
 * 最长公共前缀
 * 
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 *              如果不存在公共前缀，返回空字符串 ""。
 *
 *              示例 1:
 *
 *              输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 *
 *              输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 *
 *              所有输入只包含小写字母 a-z 。
 *
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *              著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/16 周三
 * @Version v0.1
 */
public class Solution {
    private static final String EMPTY = "";

    /**
     * 自己写的 从上到下一路比过去
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(EMPTY);
        int min = Integer.MAX_VALUE;
        int length = strs.length;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }
        for (int i = 0; i < min; i++) {
            char prefix = strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                if (strs[j].charAt(i) != prefix) {
                    return sb.toString();
                }
            }
            sb.append(prefix);
        }
        return sb.toString();
    }

    /**
     * 官方纵向遍历
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];
        int length = first.length();
        int size = strs.length;
        for (int i = 0; i < length; i++) {
            char c = first.charAt(i);
            for (int j = 1; j < size; j++) {
                String str = strs[j];
                // 当前的字符串已经在上次遍历完了且跟first的同位置相同 或者当当前位置不相同
                if (str.length() == i || str.charAt(i) != c) {
                    // 包前不包后
                    return first.substring(0, i);
                }
            }
        }
        // 第一个是最短的 所有位置相同
        return first;
    }

    /**
     * 官方横向遍历
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int length = strs.length;
        for (int i = 1; i < length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return EMPTY;
            }
        }
        return prefix;
    }

    private String commonPrefix(String prefix, String str) {
        int min = Math.min(prefix.length(), str.length());
        int index = 0;
        while (index < min && prefix.charAt(index) == str.charAt(index)) {
            index++;
        }
        return prefix.substring(0, index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"c", "acc", "ccc"}));
    }
}
