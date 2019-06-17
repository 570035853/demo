package leetcode.Algorithms._401_500._429_NAryTreeLevelOrderTraversal;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/6/14 .
 ref:
 https://leetcode.com/problems/n-ary-tree-level-order-traversal/

 Given an n-ary tree, return the level order traversal of its nodes' values.
 (ie, from left to right, level by level).

 For example, given a 3-ary tree:

         1

     3    2   4

    5 6



 We should return its level order traversal:

 [
 [1],
 [3,2,4],
 [5,6]
 ]


 Note:

 The depth of the tree is at most 1000.
 The total number of nodes is at most 5000.
 */
public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> innerList = new LinkedList<>();
            for (int i=0;i<size; i++){
                Node node = queue.poll();
                innerList.add(node.val);
                if(node.children != null && node.children.size()>0){
                    List<Node> child = node.children;
                    for (int j=0; j<child.size(); j++){
                        queue.offer(child.get(j));
                    }
                }
            }
            result.add(innerList);
        }
        return result;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
