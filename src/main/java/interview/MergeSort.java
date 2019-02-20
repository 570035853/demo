package interview;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zoujialei on 2018/7/5.
 * 归并排序相关说明：https://blog.csdn.net/bug_moving/article/details/56830714
 */
public class MergeSort {


    private static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        System.out.println(listNode.data);

    }

    public ListNode merge(ListNode a, ListNode b){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (a != null && b != null){
            if(a.data <= b.data){
               cur.next = a;
               a = a.next;
            }
            if(a.data > b.data){
               cur.next = b;
               b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a == null)? b:a;
        return head.next;
    }


    public ListNode getMiddle(ListNode head){
        if(head == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast !=  null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    public ListNode merge_sort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;

        return merge(merge_sort(head), merge_sort(midNext));
    }



}

