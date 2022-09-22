package com.magic.leetcode.q1640;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: DailyLeetcode
 * @description: 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 3：
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-array-formation-through-concatenation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yanzeyu
 * @create: 2022/9/22 19:27
 */
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> piecesMap = new HashMap<>(pieces.length);

        for (int[] piece : pieces) {
            piecesMap.put(piece[0], piece);
        }

        int n = arr.length;
        int i = 0;
        while (i < n) {
            int[] piece = piecesMap.get(arr[i]);
            if (null == piece) {
                return false;
            }

            int m = piece.length;
            int j = 0;
            while (j < m) {
                if (arr[i] == piece[j]) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //[78],[4,64],[91]
    public static void main(String[] args) {
        System.out.println(new Solution().canFormArray(new int[] {91, 4, 64, 78},
                new int[][] {new int[] {78}, new int[] {4, 64}, new int[] {91}}));
    }
}
