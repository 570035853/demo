package leetcode.Algorithms._101_200._148_SortList;

/**
 * Created by jialei.zou on 2019/5/27 .
 ref:
 https://leetcode.com/problems/sort-list/
 Sort a linked list in O(n log n) time using constant space complexity.

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5

 */
public class SortList {

    /**
     * 关键点
     * 1. 遇到2->1这种情况，如果希望是断开，while条件应该是fast.next != null && fast.next.next != null
     * 2. 引用指针的在思考
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next=null;
        return merge(sortList(head), sortList(fast));
    }


    private ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (a != null && b!= null){
            if(a.val<b.val){
                cur.next = a;
                a = a.next;
            }else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a==null?b:a;
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
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;

        SortList sortList = new SortList();
        ListNode result = sortList.sortList(node4);
        while (result!=null){
            System.out.printf(result.val+">");
            result = result.next;
        }
    }
}
