package leetcode.Algorithms._101_200._107_BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/2/11 .
 ref: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     *
     * 想到的是先正向得到结果，后对list进行反向
     * 问题在于，题目应该不需要进行reverse即可，ref题目用到的是result.add(0,list);方式解决的该问题
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<List<Integer>> reverseResult = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> innerList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i<size; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                innerList.add(queue.poll().val);
            }
            reverseResult.add(innerList);
        }
        //reverse
        for (int i = reverseResult.size(); i>0; i--){
            result.add(reverseResult.get(i-1));
        }
        return result;
    }

    /**
     * 关键是
     * result.add(0,list);
     * @param root
     * @return
     */
    public List<List<Integer>> refLevelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            //这个是关键的一步
            result.add(0,list);
        }
        return result;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
