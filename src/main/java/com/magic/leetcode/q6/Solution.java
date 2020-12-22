package com.magic.leetcode.q6;

import java.util.Arrays;

/**
 * Z 字形变换
 *
 * @Description 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *              <p>
 *              比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *              <p>
 *              L C I R E T O E S I I G E D H N 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *              <p>
 *              请你实现这个将字符串进行指定行数变换的函数：
 *              <p>
 *              string convert(string s, int numRows);
 *              <p>
 *              示例 1:
 *              <p>
 *              输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN"
 *              <p>
 *              示例 2:
 *              <p>
 *              输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG"
 *              <p>
 *              <p>
 *              来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zigzag-conversion 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yanzeyu
 * @Mail magic.yanzy@foxmail.com
 * @Date 2020/12/17 周四
 * @Version v0.1
 */
public class Solution {

    /**
     * 参照题解给出答案 思路能清楚 实现起来还是有些难度
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[s.length()];
        Arrays.fill(arr, "");
        int round = 2 * numRows - 2;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            int mod = i % round;
            if (mod < numRows) {
                arr[mod] += c;
            } else {
                arr[round - mod] += c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 参照题解
     * 
     * 在结果数组的两端的时候会发生步长的反转 step = -step;
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        int step = -1;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            rows[curRow] += c;
            if (curRow == 0 || curRow == numRows - 1) {
                step = -step;
            }
            curRow += step;
        }
        return String.join("", rows);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert1("LEETCODEISHIRING", 3));
    }
}
