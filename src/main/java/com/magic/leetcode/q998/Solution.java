package com.magic.leetcode.q998;

import com.magic.leetcode.common.TreeNode;
import com.magic.leetcode.common.TreeNodeUtils;

/**
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 *
 * 给你最大树的根节点 root 和一个整数 val 。
 *
 * 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
 *
 * 如果 a 为空，返回 null 。
 * 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
 * root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回 root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
 *
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 *
 * 返回 Construct(b) 。
 * 示例 1：
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 *
 * 作者：FennelDumplings
 * 链接：https://leetcode.cn/leetbook/read/pu-tong-shu/nsbzd7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 作者：FennelDumplings
 * 链接：https://leetcode.cn/leetbook/read/pu-tong-shu/nsbzd7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author : yanzeyu
 * @program: DailyLeetcode
 * @description:
 * @create: 2024/4/2 11:11
 */
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (null == root){
            return null;
        }

        //跟节点的值小于val root作为val节点的左儿子
        if(root.val < val){
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }

        if (null == root.right){
            root.right = new TreeNode(val);
            return root;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNodeUtils.constructMaximumBinaryTree(new int[] {1, 4, 2, 3});
        TreeNodeUtils.travers(tree);

        Solution solution = new Solution();
        TreeNode b = solution.insertIntoMaxTree(tree, 5);

        TreeNodeUtils.travers(b);
    }
}
