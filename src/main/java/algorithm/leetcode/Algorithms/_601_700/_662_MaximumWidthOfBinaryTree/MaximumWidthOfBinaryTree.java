package algorithm.leetcode.Algorithms._601_700._662_MaximumWidthOfBinaryTree;

import java.util.*;

/**
 * Created by jialei.zou on 2019/3/22 .
 ref:
 https://leetcode.com/problems/maximum-width-of-binary-tree/

 Given a binary tree, write a function to get the maximum width of the given tree.
 The width of a tree is the maximum width among all levels. The binary tree has the
 same structure as a full binary tree, but some nodes are null.

 The width of one level is defined as the length between the end-nodes (the leftmost
 and right most non-null nodes in the level, where the null nodes between the end-nodes
 are also counted into the length calculation.

 Example 1:

 Input:

      1
    /   \
   3     2
  / \     \
 5   3     9

 Output: 4
 Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 Example 2:

 Input:

       1
      /
    3
   / \
  5   3

 Output: 2
 Explanation: The maximum width existing in the third level with the length 2 (5,3).
 Example 3:

 Input:

     1
    / \
   3   2
  /
 5

 Output: 2
 Explanation: The maximum width existing in the second level with the length 2 (3,2).
 Example 4:

 Input:

         1
        / \
       3   2
      /     \
     5       9
    /         \
   6           7
 Output: 8
 Explanation:The maximum width existing in the fourth level with the
 length 8 (6,null,null,null,null,null,null,7).


 Note: Answer will in the range of 32-bit signed integer.
 */
public class MaximumWidthOfBinaryTree {

    /**
     * 结果：104 / 108 _17_skiplist cases passed.
     * 输入一个层数高的tree，报错超时：
     * https://leetcode.com/submissions/detail/216708633/
     * 自己的思路整理及收获：
     * 1. 思路：逐层遍历，每层用list保存，包括null节点，用nextLevelHasChild boolean值控制终止条件，
     * list找左侧和右侧第一个不为null的元素，并做减法
     * 2. Queue不支持如下形式的遍历：类似list for的同时有remove，会使得fail-fast生效而报错
     * Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(null);
        queue1.offer(null);
        queue1.offer(null);
        for(int i = 0 ;i <queue1.size(); i++){
            System.out.println(queue1.poll());
        }
       3. 写的时候如何控制进入，直接看代码
       4. 相对于ref1， 超时的原因主要在于每次都是生成全量的二叉树，而类似最后一个示例，实际不需要形成完全二叉树
        关于超时看ref，肯定是有更好的思路
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            boolean nextLevelHasChild = true;
            queue.offer(root);
            while (nextLevelHasChild){
                nextLevelHasChild = false;
                List<TreeNode> cur = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i< size; i++){
                    TreeNode node = queue.poll();
                    cur.add(node);
                    if(node == null){
                        queue.offer(null);
                        queue.offer(null);
                    }else {
                        if(node.left != null || node.right != null){
                            nextLevelHasChild = true;
                        }
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
                max = Math.max(width(cur), max);
            }
        }
        return max;
    }

    private int width(List<TreeNode> cur){
        int start = 0;
        int end = cur.size()-1;
        while (cur.get(start) == null){
            start+=1;
        }
        while (cur.get(end) == null){
            end-=1;
        }
        return end-start+1;
    }

    /**
     * ref思路是，可以确定节点所在位置：pos的左子树为：pos*2 pos的右子树为pos*2+1
     * @param root
     * @return
     */
    public int refWidthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }

    class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    /******************ref2************/
    //todo 待看未看
    int ans;
    Map<Integer, Integer> left;
    public int ref2WidthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {return;}
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        /*
        List<TreeNode> list = new LinkedList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        for (TreeNode item: list){
            System.out.println(item);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(1));
        queue.offer(new TreeNode(1));
        queue.offer(new TreeNode(1));


        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(null);
        queue1.offer(null);
        queue1.offer(null);
        for(int i = 0 ;i <queue1.size(); i++){
            System.out.println(queue1.poll());
        }
        */

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node3;
        node1.right = node2;
        node3.left = node5;
        node5.left = node6;

        node2.right = node9;
        node9.right = node7;
        MaximumWidthOfBinaryTree widthTree = new MaximumWidthOfBinaryTree();

        System.out.println(widthTree.widthOfBinaryTree(node1));

    }
}
