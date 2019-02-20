package leetcode.Algorithms._101_200._108_ConvertSortedArrayToBinarySearchTree;

/**
 * Created by jialei.zou on 2019/2/11 .

 ref: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

     0
    /  \
  -3    9
  /   /
 -10  5

 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        return helper(0, nums.length -1, nums);
    }

    /**
     * 写的时候，主要想起来的是105题目，边界的考虑，
     * 找到中间的0当做root，切分成左右两颗树，start和end相等的时候，因为也是一个节点，还是要当做一个root的
     * 就是两个相等的时候，还是要有root返回，所以允许start=end
     * start>(nums.length-1) 这个是出于边界考虑，没有必要，见ref
     * @param start
     * @param end
     * @param nums
     * @return
     */
    public TreeNode helper(int start, int end, int[] nums){
        if(start>end || start>(nums.length-1)){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid-1, nums);
        root.right = helper(mid+1, end, nums);
        return root;
    }

    /**
     * ref收获，没有必要start>(nums.length-1)控制边界，因为，start>end，nums[mid]就不可能出边界
     * @param num
     * @return
     */
    public TreeNode refSortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
