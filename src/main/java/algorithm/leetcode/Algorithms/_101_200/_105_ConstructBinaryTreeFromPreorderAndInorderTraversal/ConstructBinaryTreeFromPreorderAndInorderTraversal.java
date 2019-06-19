package algorithm.leetcode.Algorithms._101_200._105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * Created by jialei.zou on 2019/2/11 .
 ref: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 preorder = [3,9,20,15,7]
 inorder = [9,3,15,20,7]
 Return the following binary tree:

  3
 / \
 9  20
   /  \
  15   7


 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 题目给的示例不算很好，补充如下
       3
      /   \
     9    20
    / \   /  \
   8  10 15   7

   对于该树，
     前序遍历是：3 9 8  10 20 15 7
     中序遍历是：8 9 10 3  15 20 7
     思路是找到3 之后中序遍历前面的 8 9 10 是左子树，前序遍历也去相同的数字，对 8 9 10 应用相同的规则
     写程序存在的问题是：如何循环递归的去实现上述逻辑
     * ref: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode refBuildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * 实现上要标记出来如下几个节点的位置
     * 在in中要找root的位置：开始位置（inStart），结束位置（inEnd），3的位置（index），前两个位置是为了查找index位置
     * pre中root位置：preStart
     * 关于边界：
     * 在思考思考，主要考虑是
     * 1. 对于前序子序列：左子树不存在或者右子树不存在：preStart > preorder.length - 1；
     * 2. 对于中序子序列：左子树不存在或者右子树不存在：inStart > inEnd
     * todo  后续手写一下
     * @param preStart
     * @param inStart
     * @param inEnd
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
