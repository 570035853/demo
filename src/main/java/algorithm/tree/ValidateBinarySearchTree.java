package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jialei.zou on 2019/1/14 .
 ref: https://leetcode.com/problems/validate-binary-search-tree/
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:

 Input:
  2
 / \
 1   3
 Output: true
 Example 2:

   5
  / \
 1   4
    / \
   3   6
 Output: false

   5
  / \
 1   6
    / \
   3   7

 Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 is 5 but its right child's value is 4.


 */
public class ValidateBinarySearchTree {


    /**
     * 总体思路是中序遍历，保存成list，list逐个比较，答案提示[1,1]不可以，
     * 更改result.get(i)>result.get(i+1)里面的>为>=
     * 效率有问题，要看下ref（后续总结）
https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverseTree(root, result);
        for (int i=0; i<result.size()-1;i++){
            if(result.get(i)>=result.get(i+1)){
                return false;
            }
        }
        return true;
    }


    private static void traverseTree(TreeNode root, List<Integer> result){
        if(root != null){
            traverseTree(root.left, result);
            result.add(root.val);
            traverseTree(root.right, result);
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
//        node2.left = node1;
//        node2.right = node3;
//        System.out.println(isValidBST(node1));
//        node5.left = node1;
//        node5.right = node4;
//        node4.left = node3;
//        node4.right = node6;
//        System.out.println(isValidBST(node5));
        node5.left = node1;
        node5.right = node6;
        node6.left = node3;
        node6.right = node7;
        System.out.println(isValidBST(node5));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //ref as follows

    /**
     * 此ref的意义在于：使用非递归的方式进行了树的遍历
     * 引发的思考问题是，用栈的方式写出前序、后续遍历 todo
     *
     * @param root
     * @return
     */

    //Question : Binary Tree Inorder Traversal
    public List<Integer> refInorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    //Now, we can use this structure to find the Kth smallest element in BST.
    //Question : Kth Smallest Element in a BST
    public int refKthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
    //We can also use this structure to solve BST validation question.
    //Question : Validate Binary Search Tree
    public boolean refIsValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}



