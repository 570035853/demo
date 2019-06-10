package leetcode.Algorithms._201_300._236_LowestCommonAncestorOfABinaryTree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/5/31 .
 ref:
 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 between two nodes p and q as the lowest node in T that has both p and q as descendants
 (where we allow a node to be a descendant of itself).”

 Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

 图片


 Example 1:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 Output: 3
 Explanation: The LCA of nodes 5 and 1 is 3.
 Example 2:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 Output: 5
 Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of
 itself according to the LCA definition.


 Note:

 All of the nodes' values will be unique.
 p and q are different and both values will exist in the binary tree.

 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 我的思路是先找到根路径到目的节点的路径，但是结果显示效率很低
     Runtime: 385 ms, faster than 5.02% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     Memory Usage: 35.6 MB, less than 5.01% of Java online submissions for Lowest Common Ancestor of a Binary Tree.

     看下ref：


     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new LinkedList<>();
        List<TreeNode> qPath = new LinkedList<>();
        pPath.add(root);
        qPath.add(root);
        recordPath(root, p, pPath);
        recordPath(root, q, qPath);
        TreeNode result = root;
        for (int i=0; i<pPath.size(); i++){
            if(i<qPath.size()){
                if(pPath.get(i)!=qPath.get(i)){
                    break;
                }else {
                    result = pPath.get(i);
                }
            }else{
                break;
            }
        }
        return result;
    }

    private boolean recordPath(TreeNode current, TreeNode target, List<TreeNode> path){
        if(current == null){
            return false;
        }
        if(current.val == target.val){
            return true;
        }
        if(current.left != null){
            path.add(current.left);
            if(recordPath(current.left, target, path)){
                return true;
            }
            path.remove(current.left);
        }
        if(current.right != null){
            path.add(current.right);
            if(recordPath(current.right, target, path)){
                return true;
            }
            path.remove(current.right);
        }
        return false;

    }

    /**
     * 很经典的思路，思维有点逆着目前自己的  todo 后面继续看
     * 取到的值也可以向上传递
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorRef(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  {return root;}
        TreeNode left = lowestCommonAncestorRef(root.left, p, q);
        TreeNode right = lowestCommonAncestorRef(root.right, p, q);
        if(left != null && right != null)   {return root;}
        return left != null ? left : right;
    }


    /*************************如下是ref2**********************/

    private TreeNode ans;

    public LowestCommonAncestorOfABinaryTree() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestorRef1(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }

    public static void main(String[] args) {

    }
}
