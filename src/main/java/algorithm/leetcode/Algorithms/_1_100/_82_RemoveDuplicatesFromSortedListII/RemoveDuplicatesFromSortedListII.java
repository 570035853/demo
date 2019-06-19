package algorithm.leetcode.Algorithms._1_100._82_RemoveDuplicatesFromSortedListII;

/**
 * Created by jialei.zou on 2019/3/27 .
 * <p>
 * ref:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        ListNode cur = head;
        preHead.next = head;
        boolean curNodeDup = false;
        while (cur != null){
            while (cur.next != null && (cur.val == cur.next.val)){
                curNodeDup = true;
                cur.next = cur.next.next;
            }
            if(curNodeDup){
                pre.next = cur.next;
                cur = pre.next;
                curNodeDup = false;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return preHead.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void printAll(ListNode head){
        while (head != null){
            System.out.printf(head.val+",");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        RemoveDuplicatesFromSortedListII list = new RemoveDuplicatesFromSortedListII();
        list.printAll(node1);
        System.out.println();
        ListNode node = list.deleteDuplicates(node1);
        list.printAll(node);

    }
}
