package interview.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zoujialei on 2018/7/1.
 */
public class TraverseTree {

    /**
     * ref: https://blog.csdn.net/qq_38663729/article/details/75195984
     * offer、add区别：add增加失败，抛异常，offer返回false
     * pool、remove区别：pool抛出失败的时候，返回是null，remove collections为空则抛出异常
     * @param root
     */
    public static void printTreeByLayer(TreeNode root){
        if(root != null){
            int i = 0;//
            int j = 0;// 下一层的节点数
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            i++;
            queue.offer(root);
            while (!queue.isEmpty()){
                i -- ;
                TreeNode node = queue.poll();
                System.out.print(node.data);
                if(node.leftNode != null){
                    j++;
                    queue.offer(node.leftNode);
                }
                if(node.rightNode != null){
                    j++;
                    queue.offer(node.rightNode);
                }
                if(i == 0){
                    i = j;
                    j = 0;
                    System.out.println();
                }
            }
        }else {
            return;
        }
    }

    /**
     * 打印从最左侧能看到的叶子节点(没有遮挡的都可以)
     * @param root
     */
    public static void printLeftSeeNode(TreeNode root){
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 0, j = 0, k = 0;
            i++ ;
            while (!queue.isEmpty()){
                i--;
                TreeNode treeNode = queue.poll();
                if(k == 0 || i == k-1){
                    System.out.println(treeNode.data);
                }
                if(treeNode.leftNode != null){
                    j++;
                    queue.offer(treeNode.leftNode);
                }
                if(treeNode.rightNode != null){
                    j++;
                    queue.offer(treeNode.rightNode);
                }
                if(i == 0){
                    i = j;
                    k = j;
                    j = 0;
                }
            }
        }else {
            return;
        }
    }

    public static void printLeftSeeNodeAnother(TreeNode treeNode){
        if(treeNode != null){
            System.out.println(treeNode.data);
            printLeftSeeNodeAnother(treeNode.leftNode);
        }else {
            return;
        }
    }


    /**
     * ref: https://blog.csdn.net/xiheandroid/article/details/19908871
     * 去除叶子节点
     * @param root
     * @return
     */
    public static TreeNode removeLeaves(TreeNode root){
        if(root == null || ((root.leftNode == null) &&(root.rightNode == null))){
            return null;
        }
        root.leftNode = removeLeaves(root.leftNode);
        root.rightNode = removeLeaves(root.rightNode);
        return root;
    }

    /**
     *
     * @param root
     */
    public static void printTreeRootFirst(TreeNode root){
        if(root == null){
            return;
        }else {
            System.out.print(root.data);
        }
        printTreeRootFirst(root.leftNode);
        printTreeRootFirst(root.rightNode);
    }

    /**
     *
     * @param root
     */
    public static void printTreeRootSecond(TreeNode root){
        if(root == null){
            return;
        }
        printTreeRootSecond(root.leftNode);
        System.out.print(root.data);
        printTreeRootSecond(root.rightNode);
    }

    public static void printTreeRootLast(TreeNode root){
        if(root == null){
            return;
        }
        printTreeRootLast(root.leftNode);
        printTreeRootLast(root.rightNode);
        System.out.print(root.data);
    }


    /**
     * ref: https://blog.csdn.net/xiaoxiaoxuanao/article/details/61918125
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode(TreeNode root, int key){
        return null;
    }

    public static void main(String[] args) {
        /**
         *          1
         *      2      3
         *   4    5       6
         *    7
         *
         *
         */

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        //second layer
        treeNode1.leftNode = treeNode2;
        treeNode1.rightNode = treeNode3;
        //third layer
        treeNode2.leftNode = treeNode4;
        treeNode2.rightNode = treeNode5;
        treeNode3.rightNode = treeNode6;
        treeNode4.rightNode = treeNode7;

//        printTreeByLayer(treeNode1);

        printTreeRootFirst(treeNode1);
//        System.out.println();
//        printTreeRootSecond(treeNode1);
//        System.out.println();
//        printTreeRootLast(treeNode1);
//        System.out.println();

//        printLeftSeeNode(treeNode1);
        System.out.println();
        System.out.println("below printLeftSeeNodeAnother");
//        printLeftSeeNodeAnother(treeNode1);


    }


}
