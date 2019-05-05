package algorithm.tree;

/**
 * Created by jialei.zou on 2019/3/20 .
 *
 * 同226InvertBinaryTree为同一题目，见InvertBinaryTree说明
 */
public class MirrorTree {


    public TreeNode mirror(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);
        return root;
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

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node2.left = node4;
        node3.left = node5;

        MirrorTree mirrorTree = new MirrorTree();
        TreeNode node1Mirror = mirrorTree.mirror(node1);
        System.out.println();
    }


}
