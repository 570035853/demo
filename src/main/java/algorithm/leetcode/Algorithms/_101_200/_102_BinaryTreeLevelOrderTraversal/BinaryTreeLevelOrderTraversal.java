package algorithm.leetcode.Algorithms._101_200._102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/2/7 .
 https://leetcode.com/problems/binary-tree-level-order-traversal/

 Given a binary tree, return the level order traversal of its nodes' values.
 (ie, from left to right, level by level).


 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 因为之前做过类似的题目，总体思路比较清晰，按层次，使用队列的方式进行入队列和出丢列
     * 最终按照ABlist转换的方式写的实现
     * ref里面，queue
     *
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<TreeNode> aList = new ArrayList<>();
        List<TreeNode> bList = new ArrayList<>();
        aList.add(root);

        while (aList.size()>0 || bList.size()>0){
            List<Integer> innerList = new ArrayList<>();
            if(aList.size()>0){
                for (TreeNode item: aList){
                    innerList.add(item.val);
                    if(item.left != null){
                        bList.add(item.left);
                    }
                    if(item.right != null){
                        bList.add(item.right);
                    }
                }
                aList.clear();
            }else { //b.size()>0
                for (TreeNode item: bList){
                    innerList.add(item.val);
                    if(item.left != null){
                        aList.add(item.left);
                    }
                    if(item.right != null){
                        aList.add(item.right);
                    }
                }
                bList.clear();
            }
            result.add(innerList);
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

        List<List<Integer>> result = levelOrder(node3);
        System.out.println("end here");

    }


    /**
     * 1. 队列的实现分层主要是通过标记每一层的元素个数实现的（每一次进来都取值num=queue.size()）实现的
     * 几个队列的操作是：
     * 2. offer-添加元素；peek-取队列头部元素，但不删除；poll-取队列头部元素并删除
     * 3. Queue接口的实现类，LinkedList();
     * @param root
     * @return
     */
    public List<List<Integer>> refLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) {
            return wrapList;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }



    public List<List<Integer>> refLevelOrderReWrite(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null){
            return wrapList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> innerList = new LinkedList<>();
            int num = queue.size();
            for (int i=0;i<num;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                innerList.add(queue.poll().val);
            }
            wrapList.add(innerList);
        }
        return wrapList;
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
