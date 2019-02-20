package leetcode.Algorithms._101_200._141_LinkedListCycle;

/**
 * Created by jialei.zou on 2019/2/14 .
 ref:
 https://leetcode.com/problems/linked-list-cycle/

 图片需要到网页中查看

 Given a linked list, determine if it has a cycle in it.

 To represent a cycle in the given linked list, we use an integer pos which represents
 the position (0-indexed) in the linked list where tail connects to. If pos is -1,
 then there is no cycle in the linked list.



 Example 1:

 Input: head = [3,2,0,-4], pos = 1
 Output: true
 Explanation: There is a cycle in the linked list, where tail connects to the second node.


 Example 2:

 Input: head = [1,2], pos = 0
 Output: true
 Explanation: There is a cycle in the linked list, where tail connects to the first node.


 Example 3:

 Input: head = [1], pos = -1
 Output: false
 Explanation: There is no cycle in the linked list.



 Follow up:

 Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {

    /**
     * 想到了一个问题，一个节点能否指向自己，理解是可以的，main中验证
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(2);
        node.next = node;

        for (int i = 0; i<3; i++){
            System.out.println(node.next.val);
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

}
