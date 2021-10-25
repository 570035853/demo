package algorithm.others;

import common.ListNode;
import common.ListNodeUtils;

/**
 * Created by jialei.zou on 2019/6/21 .
 */
public class SplitList {

    ListNode a; //偶数
    ListNode b; //基数

    public void split(ListNode head){
        ListNode preHeadA = new ListNode(-1);
        ListNode preCurA = preHeadA;
        ListNode preHeadB = new ListNode(-1);
        ListNode preCurB = preHeadB;

        ListNode cur = head;
        int i=0;
        while (cur != null){
            ListNode next = cur.next;
            if(i%2 == 0){
               preCurA.next = cur;
               preCurA = cur;
            }else {
                preCurB.next = cur;
                preCurB = cur;
            }
            cur.next = null;
            cur = next;
            i++;
        }

        a= preHeadA.next;
        b= preHeadB.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getList(new int[]{1, 2, 3, 4, 5, 6,7});
        SplitList splitList = new SplitList();
        splitList.split(listNode);

        ListNodeUtils.printNode(splitList.a);
        ListNodeUtils.printNode(splitList.b);

    }
}
