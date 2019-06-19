package algorithm.leetcode.Algorithms._1_100._92_ReverseLinkedListII;

/**
 * Created by jialei.zou on 2018/12/23 .
 Reverse a linked list from position m to n. Do it in one-pass.

 Note: 1 ≤ m ≤ n ≤ length of list.

 Example:

 Input: 1->2->3->4->5->NULL, m = 2, n = 4
 Output: 1->4->3->2->5->NULL

 */
public class _92_ReverseLinkedListII {

    /**
     * 写出来了 还不错，反转还没有做到不用思考就能写出来的地步
     * 但是注意下反转，改变pre、cur、next的时候，是先改变pre，之后是cur这种顺序下去
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode preHead = new ListNode(-1);
        ListNode watcher = preHead;
        ListNode pre = preHead;
        ListNode cur = preHead;
        ListNode next;
        preHead.next = head;
        for (int i = 1; i<m; i++){
            watcher = watcher.next;
            cur = cur.next;
            pre = pre.next;
        }
        cur = cur.next;
        next = cur.next;
        for (int i = m; i<n; i++){
            pre = cur;
            cur = next;
            next = next.next;
            cur.next = pre;
        }

        watcher.next.next = next;
        watcher.next = cur;

        return preHead.next;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    private static void printAll(ListNode head){
        while (head != null){
            System.out.printf(head.val+",");
            head = head.next;
        }
        System.out.println();
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
        node4.next = node5;

        printAll(node1);
        printAll(reverseBetween(node1, 2, 4));
    }

}
