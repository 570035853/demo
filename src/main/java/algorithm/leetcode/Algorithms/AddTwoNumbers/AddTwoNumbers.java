package algorithm.leetcode.Algorithms.AddTwoNumbers;

/**
 * Created by jialei.zou on 2018/11/15 .
 */
public class AddTwoNumbers {

    /**
     * 与标准答案思路一致
     * 改进点，见myEditAddTwoNumbers
     * 注意点：
     * 1.头指针的记录
     * 2.current控制向后移动
     * 3.注意进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2==null){
            return null;
        }
        ListNode preHead = new ListNode(-1);
        ListNode current = new ListNode(-1);
        int highDigitValue = 0;
        boolean flag = true;
        while (l1!=null || l2!=null){
            int sum =0;
            if(l1!=null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + highDigitValue;
            highDigitValue = 0;
            if(sum>=10){
                highDigitValue = 1;
                sum = sum-10;
            }
            ListNode newNode = new ListNode(sum);
            if(flag){
                preHead.next = newNode;
                flag = false;
            }
            current.next = newNode;
            current = current.next;
        }
        if(highDigitValue>0){
            ListNode lastNode = new ListNode(highDigitValue);
            current.next = lastNode;
        }
        return preHead.next;
    }


    public ListNode myEditAddTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2==null){
            return null;
        }
        ListNode preHead = new ListNode(-1);
//        ListNode current = new ListNode(-1);
        ListNode current = preHead;
        int highDigitValue = 0;
//        boolean flag = true;
        while (l1!=null || l2!=null){
            int sum =0;
            if(l1!=null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + highDigitValue;
            highDigitValue = 0;
            if(sum>=10){
                highDigitValue = 1;
                sum = sum-10;
            }
            ListNode newNode = new ListNode(sum);
//            if(flag){
//                preHead.next = newNode;
//                flag = false;
//            }
            current.next = newNode;
            current = current.next;
        }
        if(highDigitValue>0){
            ListNode lastNode = new ListNode(highDigitValue);
            current.next = lastNode;
        }
        return preHead.next;
    }

    public void print(ListNode node){
        while (node !=null){
            System.out.print(node.val+">");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode getNodeList(int[] arryList){
        if(arryList.length<1){
            return null;
        }
        ListNode preHead = new ListNode(-1);
        ListNode current = new ListNode(-1);
        boolean flag = true;
        for (int i = 0; i<arryList.length; i++){
            ListNode newNode = new ListNode(arryList[i]);
            if(flag){
                flag = false;
                preHead.next = newNode;
            }
            current.next = newNode;
            current = current.next;
        }
        return preHead.next;
    }
}
