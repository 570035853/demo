package algorithm.leetcode.Algorithms._101_200._109_ConvertSortedListToBinarySearchTree;

/**
 * Created by jialei.zou on 2019/2/11 .
 ref:
 https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

 Given a singly linked list where elements are sorted in ascending order,
 convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree
 in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted linked list: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

     0
    /  \
  -3   9
  /   /
 -10  5

 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 同108有些类似，主要是要找中间节点，想到了快慢指针，需要找到
     * mid位置当做root，mid左侧的节点需要保存下来，先记做preMid,
     * 终止条件目前想到的是
     * left: preMid为null
     * right: mid.next为null
     *
     *
     * 看了ref之后，while (fast.next != null && fast.next.next != null)
     * 应该改为(更好，更通用) fast != null && fast.next != null
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode preMid = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){  //更优的调整的地方
            preMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightRoot = slow.next;
        TreeNode root = new TreeNode(slow.val);
        if(preMid !=null){
            preMid.next = null;
            root.left = sortedListToBST(head);
        }
        if(rightRoot != null){
            root.right = sortedListToBST(rightRoot);
        }
        return root;
    }


    /**
     * https://leetcode.com/articles/convert-sorted-list-to-binary-search-tree/
     * 提供的另外一个思路，就是讲链表转为数组，然后和108就一致了
     * @param head
     * @return
     */
    public TreeNode refSortedListToBST(ListNode head) {

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        // Find the middle element for the list.
        ListNode mid = this.findMiddleElement(head);

        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = this.refSortedListToBST(head);
        node.right = this.refSortedListToBST(mid.next);
        return node;
    }

    private ListNode findMiddleElement(ListNode head) {

        // The pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;
    }

    public static void main(String[] args) {
        ListNode nodeM10 = new ListNode(-10);
        ListNode nodeM3 = new ListNode(-3);
        ListNode nodeM0 = new ListNode(0);
        ListNode node5 = new ListNode(5);
        ListNode node9 = new ListNode(9);
        nodeM10.next = nodeM3;
        nodeM3.next = nodeM0;
        nodeM0.next = node5;
        node5.next = node9;
        TreeNode root = sortedListToBST(nodeM10);

        System.out.println("end here");

    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
