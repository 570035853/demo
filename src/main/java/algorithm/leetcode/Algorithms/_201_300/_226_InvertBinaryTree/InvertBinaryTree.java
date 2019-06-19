package algorithm.leetcode.Algorithms._201_300._226_InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/3/21 .
 ref:
 https://leetcode.com/problems/invert-binary-tree/
 Invert a binary tree.

 Example:

 Input:

      4
    /   \
   2     7
  / \   / \
 1   3 6   9
 Output:

      4
    /   \
   7     2
  / \   / \
 9   6 3   1
 Trivia:
 This problem was inspired by this original tweet by Max Howell:

 Google: 90% of our engineers use the software you wrote (Homebrew),
 but you can’t invert a binary tree on a whiteboard so f*** off.

 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * https://leetcode.com/problems/invert-binary-tree/solution/
     * 补充：TreeNode right TreeNode left 还是新建了2个引用，之后交换
     * @param root
     * @return
     */
    public TreeNode ref1InvertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * https://leetcode.com/problems/invert-binary-tree/solution/
     * @param root
     * @return
     */
    public TreeNode ref2InvertTree(TreeNode root) {
        if (root == null) {return null;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {queue.add(current.left);}
            if (current.right != null) {queue.add(current.right);}
        }
        return root;
    }
}
