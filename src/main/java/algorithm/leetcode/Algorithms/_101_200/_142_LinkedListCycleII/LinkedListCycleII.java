package algorithm.leetcode.Algorithms._101_200._142_LinkedListCycleII;

/**
 * Created by jialei.zou on 2019/2/21 .
 https://leetcode.com/problems/linked-list-cycle-ii/
 需要看图，原链接有图

 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 To represent a cycle in the given linked list, we use an integer pos which represents
 the position (0-indexed) in the linked list where tail connects to. If pos is -1,
 then there is no cycle in the linked list.

 Note: Do not modify the linked list.



 Example 1:

 Input: head = [3,2,0,-4], pos = 1
 Output: tail connects to node index 1
 Explanation: There is a cycle in the linked list, where tail connects to the second node.


 Example 2:

 Input: head = [1,2], pos = 0
 Output: tail connects to node index 0
 Explanation: There is a cycle in the linked list, where tail connects to the first node.


 Example 3:

 Input: head = [1], pos = -1
 Output: no cycle
 Explanation: There is no cycle in the linked list.




 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycleII {


    /**
     * 如下是19年5月29日后，手写的，几十天之前看过别人的思路，写的时候遇到如下问题
     * 1. 回头看，和投票最高的一个实现基本一模一样
     * 2. 在写的时候，考虑到初始化问题，因为fast和slow都初始化为了head，所以担心while里面的判断，没法判断是初始化的head还是发现了环
     * ，实际先进行slow = slow.next;在做判断就没有这个问题了
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == head){
            return head;
        }
        boolean found = false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                found = true;
                break;
            }
        }
        if(!found){
            return null;
        }
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    /**
     * 如下是另外一个ref，比较简洁的代码
     * @param head
     * @return
     */
    public ListNode detectCycleRef2(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node0;

        LinkedListCycleII cycleII = new LinkedListCycleII();
        System.out.println(cycleII.detectCycle(node3).val);

    }
}
