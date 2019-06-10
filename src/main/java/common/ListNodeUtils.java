package common;

/**
 * Created by jialei.zou on 2019/5/29 .
 */
public class ListNodeUtils {


    public static ListNode getList(int nums[]){
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        for (int i = 0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        return preHead.next;
    }

    public static void printNode(ListNode head){
        while (head!=null){
            System.out.printf(head.val+">");
            head = head.next;
        }
        System.out.println();
    }

}
