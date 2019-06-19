package algorithm.leetcode.Algorithms._601_700._671_SecondMinimumNodeInABinaryTree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jialei.zou on 2019/4/28 .
 ref:
 https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。

 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

 示例 1:

 输入:
     2
    / \
   2   5
  / \
 5   7

 输出: 5
 说明: 最小的值是 2 ，第二小的值是 5 。
 示例 2:

 输入:
    2
   / \
  2   2

 输出: -1
 说明: 最小的值是 2, 但是不存在第二小的值。

 */
public class SecondMinimumNodeInABinaryTree {

    /**
     * 自己老想着对比左结点值和右结点值，没想清楚如何返回，
     * 1. ref里面通过min1及ans，不涉及返回了，所以就有了退出
     * 2. 至少全部遍历，o(n)可以解决这个问题
     * @param root
     * @return
     */
    public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniques = new HashSet<>();
        dfs(root, uniques);

        int min1 = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans) {ans = v;}
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }

    /*******
     * 方式2的更为高效
     */

    int min1;
    long ans = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValueRef2(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }

    /*******
     * ref3:
     * https://github.com/algorithm001/algorithm/pull/347/commits/cac2b1195c6c00aac6c3b8deb467cf7d5086e887
     * 极客时间里面别人的解答，比较符合自己最初的思路
     */

    public int findSecondMinimumValueRef3(TreeNode root) {
        return traversal(root,root.val);
    }

    private int traversal(TreeNode root,int value){
        if(root == null){
            return -1;
        }
        if(root.val > value){
            return root.val;
        }
        int l = traversal(root.left,value);
        int r = traversal(root.right,value);

        if(l>=0 && r>=0){
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
