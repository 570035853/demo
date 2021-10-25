package algorithm.category.tree;


public class TreeDepth {

    public static void main(String[] args) {

    }


    private int getTreeDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = getTreeDepth(node.leftNode);
        int right = getTreeDepth(node.rightNode);
        return left>right?(left+1):(right+1);
    }

    class TreeNode {
        public int data;
        public TreeNode leftNode;
        public TreeNode rightNode;

        public TreeNode(int data){
            this.data = data;
            leftNode = null;
            rightNode = null;
        }
    }
}
