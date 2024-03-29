package com.magic.leetcode.q402;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: DailyLeetcode
 * @description:
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *  
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 *
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 *
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: yanzeyu
 * @create: 2022/9/19 19:35
 */
public class Solution {
  public String removeKdigits(String num, int k) {
    int n = num.length();
    if (n <= k) {
        return "0";
    }
    Deque<Character> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
        char cur = num.charAt(i);

        //选择相对小的值放到集合里
       while (!queue.isEmpty() && k > 0 && queue.peekLast() > cur) {
         queue.pollLast();
         k--;
       }

      queue.offerLast(cur);
    }

    while (k > 0){
      queue.pollLast();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    boolean flag = true;

    while (!queue.isEmpty()) {
        char cur = queue.pollFirst();
        if (flag && cur == '0'){
          continue;
        }
        flag = false;
        sb.append(cur);
    }
    return sb.length() < 1 ? "0" : sb.toString();
  }


  public static void main(String[] args) {
    System.out.println(new Solution().removeKdigits("1432219", 3));
    System.out.println(new Solution().removeKdigits("10200", 1));
    System.out.println(new Solution().removeKdigits("10", 2));
    System.out.println(new Solution().removeKdigits("112", 1));
    System.out.println(new Solution().removeKdigits("1234567890", 9));
  }
}
