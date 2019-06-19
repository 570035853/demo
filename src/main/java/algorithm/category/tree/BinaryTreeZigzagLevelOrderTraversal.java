package algorithm.category.tree;


import java.util.*;

/**
 * Created by jialei.zou on 2019/2/7 .
 ref: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

 Given a binary tree, return the zigzag level order traversal of its nodes' values.
 (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]

 */
public class BinaryTreeZigzagLevelOrderTraversal {


    /**
     * 刚做过102的分层打印，对于和102题目的区别，就是用栈的方式来实现
     * 补充：需要使用两个栈来实现
     * 实现使用的是两个list，不过加入结果数据分别从左侧和右侧加入
     * fromLeft, fromRight
     * 1. Runtime: 1 ms, faster than 91.24% of Java online submissions
     * for Binary Tree Zigzag Level Order Traversal.
       2. Memory Usage: 26.3 MB, less than 24.01% of Java online
       submissions for Binary Tree Zigzag Level Order Traversal.
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null){
            return wrapList;
        }
        List<TreeNode> fromLeft = new LinkedList<>();
        List<TreeNode> fromRight = new LinkedList<>();
        fromLeft.add(root);
        while (fromLeft.size()>0 || fromRight.size()>0 ){
            List<Integer> innerList = new LinkedList<>();
            if(fromLeft.size()>0){
                for (int i = 0; i<fromLeft.size(); i++){
                    TreeNode item = fromLeft.get(i);
                    innerList.add(item.val);
                    if(item.left != null){
                        fromRight.add(item.left);
                    }
                    if(item.right != null){
                        fromRight.add(item.right);
                    }

                }
                fromLeft.clear();
            }else {
                for (int i = 0; i<fromRight.size(); i++){
                    TreeNode item = fromRight.get(i);
                    innerList.add(fromRight.get(fromRight.size()-i-1).val);
                    if(item.left != null){
                        fromLeft.add(item.left);
                    }
                    if(item.right != null){
                        fromLeft.add(item.right);
                    }

                }
                fromRight.clear();
            }
            wrapList.add(innerList);
        }
        return wrapList;

    }


    /**
     * 需要确定stack的实现类有哪些
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrderStack(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null){
            return wrapList;
        }

        Stack<TreeNode> aStack = new Stack<>();
        Stack<TreeNode> bStack = new Stack<>();
        aStack.push(root);
        while (aStack.size()>0 || bStack.size()> 0){
            List<Integer> innerList = new LinkedList<>();
            if(aStack.size()>0){
                while (aStack.size()>0){
                    TreeNode item = aStack.pop();
                    innerList.add(item.val);
                    if(item.left != null){
                        bStack.push(item.left);
                    }
                    if(item.right != null){
                        bStack.push(item.right);
                    }
                }
            } else {
                while (bStack.size()>0){
                    TreeNode item = bStack.pop();
                    innerList.add(item.val);
                    if(item.right != null){
                        aStack.push(item.right);
                    }
                    if(item.left != null){
                        aStack.push(item.left);
                    }
                }
            }
            wrapList.add(innerList);
        }
        return wrapList;
    }


    /**
     * 和自己实现的区别主要在代码行temp.add(0,node.val);之处
     * @param root
     * @return
     */
    public static List<List<Integer>> refZigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(!reverse){
                    temp.add(node.val);
                }
                else{
                    temp.add(0,node.val);
                }
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!= null) {
                    q.add(node.right);
                }
            }
            result.add(temp);
            reverse=!reverse;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

//        List<List<Integer>> result = zigzagLevelOrder(node3);
//        List<List<Integer>> result = zigzagLevelOrderStack(node3);
        List<List<Integer>> result = zigzagLevelOrderStack(node3);


        System.out.println("end here");

    }


    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> refZigzagLevelOrderRecursion(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) {
            return;
        }

        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) {
            collection.add(curr.val);
        }
        else {
            collection.add(0, curr.val);
        }

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
