package leetcode.Algorithms._101_200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/1/23 .
 ref: https://leetcode.com/problems/symmetric-tree/

 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
   1
  / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    /**
     * 按照递归写的没啥问题，和之前的有点类似，后面看下另外一种ref1 todo
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return recursive(root.left, root.right);
    }

    private static boolean recursive(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return recursive(left.left, right.right)&recursive(left.right, right.left);
    }

    public boolean refIsSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(2);
        TreeNode node4= new TreeNode(3);
        TreeNode node5= new TreeNode(4);
        TreeNode node6= new TreeNode(4);
        TreeNode node7= new TreeNode(3);

        node1.left= node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(isSymmetric(node1));

        TreeNode node8= new TreeNode(1);
        TreeNode node9= new TreeNode(2);
        TreeNode node10= new TreeNode(2);
        TreeNode node11= new TreeNode(3);
        TreeNode node12= new TreeNode(3);
        node8.left = node9;
        node8.right = node10;
        node9.right = node11;
        node10.right = node12;
        System.out.println(isSymmetric(node8));

    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

}
