package leetcode.Algorithms._1_100._24_SwapNodesInPairs;

/**
 * Created by jialei.zou on 2019/4/20 .
 * ref:
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 You may not modify the values in the list's nodes, only nodes itself may be changed.



 Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = head;
        ListNode next;
        ListNode pre = preHead;
        while (cur != null && cur.next != null){
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;

            pre = cur;
            cur = cur.next;
        }
        return preHead.next;
    }


    public ListNode refSwapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

        ListNode result = swapNodesInPairs.swapPairs(node1);
        while (result != null){
            System.out.printf(result.val+">");
            result = result.next;
        }

    }
}
