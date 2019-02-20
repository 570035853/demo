package leetcode.Algorithms._1_100._86_PartitionList;

/**
 * Created by jialei.zou on 2018/12/26 .
 * ref: https://leetcode.com/problems/partition-list/
 Given a linked list and a value x, partition it such that all nodes less than
 x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 Example:

 Input: head = 1->4->3->2->5->2, x = 3
 Output: 1->2->2->4->3->5

 */
public class PartitionList {

    /**
     * if(firstRight.val >x)的判断，应该是>=，而不是>
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode preFirstRight = preHead;
        ListNode pre = preHead;
        ListNode firstRight = head;
        ListNode cur = head;
        ListNode next;
        while (firstRight != null){
            if(firstRight.val >x){
                break;
            }
            preFirstRight = preFirstRight.next;
            firstRight = firstRight.next;
            pre = pre.next;
            cur = cur.next;
        }
        while (cur != null){
            next = cur.next;
            if(cur.val<x){
                pre.next = next;
                preFirstRight.next = cur;
                cur.next = firstRight;
                preFirstRight = cur;
                cur = next;
            }else {
                pre = cur;
                cur = next;
            }
        }
        return preHead.next;

    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    private static void print(ListNode head){
        while (head != null){
            System.out.printf(head.val+",");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        print(node1);
        System.out.println("");
        ListNode newHead = partition(node1, 3);
        print(newHead);
    }
}
