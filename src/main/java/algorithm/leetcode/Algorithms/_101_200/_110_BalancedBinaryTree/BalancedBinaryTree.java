package algorithm.leetcode.Algorithms._101_200._110_BalancedBinaryTree;

/**
 * Created by jialei.zou on 2019/2/12 .
 ref:
 https://leetcode.com/problems/balanced-binary-tree/

 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example 1:

 Given the following tree [3,9,20,null,null,15,7]:

   3
  / \
  9  20
    /  \
   15   7
 Return true.

 Example 2:

 Given the following tree [1,2,2,3,3,null,null,4,4]:

        1
       / \
      2   2
     / \
    3   3
   / \
  4  4
 Return false.
 */
public class BalancedBinaryTree {

    /**
     * 自己想到的方法，时间复杂度是o（n2），看下ref
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(height(root.left)-height(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right))+1;
    }

    /*****************以下是ref**********************/

    //ref的时间复杂度是o(n)

    private boolean result = true;

    public boolean refisBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1){
            result = false;
        }
        return 1 + Math.max(l, r);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


}
