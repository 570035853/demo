package algorithm.SwordOffer;

import common.TreeNode;

/**
 * Created by jialei.zou on 2019/7/1 .
 * ref:
 * https://blog.csdn.net/snow_7/article/details/51822366
 */
public class Num_7 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //如果先序或者中序数组有一个为空的话，就无法建树，返回为空
        if(pre == null || in == null || pre.length != in.length ){
            return null;
        } else {
            return reBulidTree(pre,0,pre.length-1,in,0,in.length-1);
        }
    }
    private TreeNode reBulidTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn) {
        //先对传的参数进行检查判断
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        //数组的开始位置的元素是跟元素
        int root = pre[startPre];
        //得到根节点在中序数组中的位置 左子树的中序和右子树的中序以根节点位置为界
        int locateRoot = locate(root,in,startIn,endIn);
        //在中序数组中没有找到跟节点，则返回空
        if(locateRoot == -1) {
            return null;
        }
        //创建树根节点
        TreeNode treeRoot = new TreeNode(root);
        treeRoot.left = reBulidTree(pre,startPre + 1,startPre + locateRoot - startIn,in,startIn,locateRoot-1);
        treeRoot.right = reBulidTree(pre,startPre+locateRoot-startIn+1,endPre,in,locateRoot+1,endIn);
        return treeRoot;
    }

    //找到根节点在中序数组中的位置，根节点之前的是左子树的中序数组，根节点之后的是右子树的中序数组
    private int locate(int root,int[] in,int startIn,int endIn) {
        for (int i = startIn; i < endIn; i++) {
            if(root == in[i]){
                return i;
            }
        }
        return -1;
    }

}
