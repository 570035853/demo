package algorithm.leetcode.Algorithms._1_100._25_ReverseNodesInKGroup;

import common.ListNode;
import common.ListNodeUtils;

/**
 * Created by jialei.zou on 2019/5/29 .
 ref:
 https://leetcode.com/problems/reverse-nodes-in-k-group/

 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list.
 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:

 Only constant extra memory is allowed.
 You may not alter the values in the list's nodes, only nodes itself may be changed.

 */
public class ReverseNodesInKGroup {

    /**
     1. 哈哈哈，效率不错
     Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
     Memory Usage: 35.3 MB, less than 100.00% of Java online submissions for Reverse Nodes in k-Group.
     2. 思路是如图片所示，将list分为不同的段，各端分别处理
     3. 注意使用preHead，pre这种让逻辑处理变的简单
     4. 需要有pre、cur、next这类，同时，由于有有每个单元的内部逻辑处理，需要有innerCur，innerPre这种内部移动，用于控制移动K个

     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        boolean goOn = true;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;
        ListNode next;
        while (goOn){
            ListNode innerCur = cur;
            ListNode innerPre = pre;
            int innerK = k;
            while (innerCur!=null&&innerK>0){
                innerCur =innerCur.next;
                innerPre = innerPre.next;
                innerK--;
            }
            if(innerK==0){
                next = innerCur;
                innerPre.next = null;
                cur = reverse(cur);
                pre.next = cur;
                while (cur.next != null){
                    cur= cur.next;
                }
                cur.next = next;
                pre = cur;
                cur = next;
            }else {
                goOn = false;
            }
        }
        return preHead.next;

    }

    /**
     * 关键点：只有next不为空的时候，才有进行下一步的必要
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode nextNext = next ;
        while (next != null){
            nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
        head.next = null;
        return cur;
    }



    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getList(new int[]{1,2,3,4,5});
        ListNodeUtils.printNode(listNode);
        ReverseNodesInKGroup kGroup = new ReverseNodesInKGroup();
        ListNode revert = kGroup.reverse(listNode);
        ListNodeUtils.printNode(revert);

        ListNode node1 = ListNodeUtils.getList(new int[]{1,2,3,4,5});
        ListNode node1Result = kGroup.reverseKGroup(node1, 2);
        ListNodeUtils.printNode(node1Result);
        ListNode node2 = ListNodeUtils.getList(new int[]{1,2,3,4,5});
        ListNode node2Result = kGroup.reverseKGroup(node2, 3);
        ListNodeUtils.printNode(node2Result);
    }
}
