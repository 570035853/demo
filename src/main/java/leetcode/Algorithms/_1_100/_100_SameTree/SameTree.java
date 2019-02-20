package leetcode.Algorithms._1_100._100_SameTree;

/**
 * Created by jialei.zou on 2018/12/23 .
 *
 * ref: https://leetcode.com/problems/same-tree/
 *
 Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

 Example 1:

 Input:
 1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 Output: true
 Example 2:

 Input:
 1         1
 /           \
 2             2

 [1,2],     [1,null,2]

 Output: false
 Example 3:

 Input:
 1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 Output: false
 */
public class SameTree {


    /**
     * 共计犯了如下错误：
     * 1. 刚开始的时候，以为前序、中序、后序任何一种遍历都都可以，解决不了，子树和父亲值相同情况；
     * 2. preOrderTraverse里面还是判断了if(node.left!=null)（该部分代码仍旧保留着呢）; 实际该判断没有必要
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder traverseP = new StringBuilder();
        StringBuilder traverseQ = new StringBuilder();
        updatePreOrderTraverse(p, traverseP);
        updatePreOrderTraverse(q, traverseQ);
//        inOrderTraverse(p, traverseP);
//        inOrderTraverse(q, traverseQ);
//        postOrderTraverse(p, traverseP);
//        postOrderTraverse(q, traverseQ);
        System.out.println("traverseP:"+traverseP.toString());
        System.out.println("traverseQ:"+traverseQ.toString());
        return traverseP.toString().equals(traverseQ.toString());
    }


    /**
     * 考虑直接比较挨个比较树，未写出来终止条件
     * 看到ref后，想到实际还是比较单个阶段后，比较孩子，所有的return就都明确了
     * @param p
     * @param q
     * @return
     */
    public static boolean anotherIsSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if(p!=q){
                return false;
            }else {
                return true;
            }
        }else {
            if(p.val == q.val){
                return anotherIsSameTree(p.left, q.left) && anotherIsSameTree(p.right, q.right);
            }else {
                return false;
            }
        }
    }

    public boolean ref1IsSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    private static boolean equals(TreeNode p, TreeNode q){

        return p.val == q.val;
    }


    private static void preOrderTraverse(TreeNode node, StringBuilder builder){
        if(node == null){
            return;
        }
        builder.append(node.val);
        if(node.left!=null){
            preOrderTraverse(node.left, builder);
        }
        if(node.right!=null){
            preOrderTraverse(node.right, builder);
        }
    }

    /**
     * 提交的时候是用该方法提交的
     * @param node
     * @param builder
     */
    private static void updatePreOrderTraverse(TreeNode node, StringBuilder builder){
        if(node == null){
            builder.append("null");
            return;
        }
        builder.append(node.val);
        updatePreOrderTraverse(node.left, builder);
        updatePreOrderTraverse(node.right, builder);

    }

    private static void inOrderTraverse(TreeNode node, StringBuilder builder){
        if(node == null){
            return;
        }

        if(node.left!=null){
            inOrderTraverse(node.left, builder);
        }
        builder.append(node.val);
        if(node.right!=null){
            inOrderTraverse(node.right, builder);
        }
    }

    private static void postOrderTraverse(TreeNode node, StringBuilder builder){
        if(node == null){
            return;
        }

        if(node.left!=null){
            postOrderTraverse(node.left, builder);
        }
        if(node.right!=null){
            postOrderTraverse(node.right, builder);
        }
        builder.append(node.val);
    }



    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);
        node4.left = node5;
        node4.right = node5;

        System.out.println(isSameTree(node1, node4));

    }

}
