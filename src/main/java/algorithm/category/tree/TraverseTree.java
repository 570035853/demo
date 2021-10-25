package algorithm.category.tree;



import common.TreeNode;

import java.util.*;

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
                System.out.print(node.val);
                if(node.left != null){
                    j++;
                    queue.offer(node.left);
                }
                if(node.right != null){
                    j++;
                    queue.offer(node.right);
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
                    System.out.println(treeNode.val);
                }
                if(treeNode.left != null){
                    j++;
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    j++;
                    queue.offer(treeNode.right);
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




    /**
     * ref: https://blog.csdn.net/xiheandroid/article/details/19908871
     * 去除叶子节点
     * @param root
     * @return
     */
    public static TreeNode removeLeaves(TreeNode root){
        if(root == null || ((root.left == null) &&(root.right == null))){
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
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
            System.out.print(root.val+",");
        }
        printTreeRootFirst(root.left);
        printTreeRootFirst(root.right);
    }

    public static void printTreeRootFirstWithoutRecursion(TreeNode root){
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                System.out.printf(p.val+",");
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                //新的一轮循环
                p = p.right;
            }
        }
    }

    /**
     * 入栈的时候先入栈，当前节点入栈后，查看当前左侧节点是否可以入栈，
     * 出栈时候先打印元素，这样就实现了先遍历左侧节点，之后指针指向出栈元素的右侧节点，确定有没有必要开始新一轮的规则
     * @param root
     */
    public static void printTreeRootSecondWithoutRecursion(TreeNode root){
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                System.out.printf(p.val+",");
                //新的一轮循环
                p = p.right;
            }
        }
    }



    /**
     *
     * @param root
     */
    public static void printTreeRootSecond(TreeNode root){
        if(root == null){
            return;
        }
        printTreeRootSecond(root.left);
        System.out.print(root.val+",");
        printTreeRootSecond(root.right);
    }

    public static void printTreeRootLast(TreeNode root){
        if(root == null){
            return;
        }
        printTreeRootLast(root.left);
        printTreeRootLast(root.right);
        System.out.print(root.val+",");
    }


    /**
     * ref:https://juejin.im/post/59e3fde451882578c20858a5
     * @param root
     */
    public static void printTreeRootLastWithoutRecursion(TreeNode root){
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode last = null;
        while(cur != null || !stack.empty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == last) {
                results.add(cur.val);
                stack.pop();
                // 记录上一个访问的节点
                // 用于判断“访问根节点之前，右子树是否已访问过”
                last = cur;
                // 表示不需要转向，继续弹栈
                cur = null;
            } else {
                cur = cur.right;
            }
        }

    }


    /**
     ref:
     https://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html

     保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。如果P不存在左孩子和右孩子，则可以直接访问它；
     或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。若非上述两种情况，则将P的右孩子和左孩子依次入栈，
     这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。

     * @param root
     */
    public static void printTreeRootLastWithoutRecursion1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        //当前结点
        TreeNode cur;
        //前一次访问的结点
        TreeNode pre = null;
        stack.push(root);
        while(!stack.empty())
        {
            cur=stack.peek();
            if((cur.left==null && cur.right==null)||
                    //上一次打印的节点，正好是当前节点的孩子节点，表明孩子节点已经访问过了
                    (pre!=null && (pre==cur.left||pre==cur.right)))
            {
                //如果当前结点没有孩子结点   或者孩子节点都已被访问过
                System.out.printf(cur.val+",");;
                stack.pop();
                pre=cur;
            }
            else
            {
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }

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
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        //third layer
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.right = treeNode7;

//        printTreeByLayer(treeNode1);
        System.out.println("前序");
        printTreeRootFirst(treeNode1);
        System.out.println();
        printTreeRootFirstWithoutRecursion(treeNode1);
        System.out.println();


        //中序
        System.out.println("中序");
        printTreeRootSecondWithoutRecursion(treeNode1);
        System.out.println();
        printTreeRootSecond(treeNode1);
        System.out.println();



        //后序
        System.out.println("后序");
        printTreeRootLast(treeNode1);
        System.out.println();
//        printTreeRootLastWithoutRecursion(treeNode1);
        System.out.println();



//        printLeftSeeNode(treeNode1);
        System.out.println();
        System.out.println("below printLeftSeeNodeAnother");
//        printLeftSeeNodeAnother(treeNode1);


    }


}
