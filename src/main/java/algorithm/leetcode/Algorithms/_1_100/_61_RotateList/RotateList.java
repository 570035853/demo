package algorithm.leetcode.Algorithms._1_100._61_RotateList;

/**
 * Created by jialei.zou on 2019/3/26 .
 ref:
 https://leetcode.com/problems/rotate-list/
 Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:
 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL

 Example 2:
 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL

 */
public class RotateList {

    /**
     * 自己的思路是先走一遍，判断k是否比数组的长度还大，如果大求余需要遍历到什么位置
     * 第二遍才从头开始遍历到核实位置
     * 可以改进的地方是：如果数组的长度大于等于k，则只遍历一次即可
     * 改进见: adjustRotateRight 总结也见：adjustRotateRight
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0){
            return head;
        }
        //确定k是否比数组长度大
        int kCountdown = k;
        int num = 0;
        ListNode cur = head;
        while (kCountdown>0){
            if(cur == null){
                break;
            }
            num ++;
            kCountdown--;
            cur = cur.next;
        }
        if(kCountdown>0){
            k = k % num;
        }else if(kCountdown==0 && cur == null){
            return head;
        }

        //窗口前移
        ListNode fast = head;
        ListNode slow = head;
        while (k>0){
            fast = fast.next;
            k--;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    /**
     * 对于边界的考虑见：if(kCountdown == 1) 因为其调整规则不再和通用一致
     *
     Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
     Memory Usage: 40.7 MB, less than 5.18% of Java online submissions for Rotate List.
     Next challenges:
     * @param head
     * @param k
     * @return
     */
    public ListNode adjustRotateRight(ListNode head, int k) {
        if(head == null || k==0){
            return head;
        }
        //进行第一次遍历
        int kCountdown = k;
        int num = 0;
        ListNode cur = head;
        while (kCountdown>0){
            if(cur.next == null){
                break;
            }
            num ++;
            kCountdown--;
            cur = cur.next;
        }
        if(kCountdown == 1){
            return head;
        }else {
            //窗口前移
            ListNode fast = head;
            ListNode slow = head;
            if(kCountdown == 0){
                fast = cur;
            }else {//kCountdown>0
                k = k % (num+1);
                while (k>0){
                    fast = fast.next;
                    k--;
                }
            }
            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            fast.next = head;
            head = slow.next;
            slow.next = null;

            return head;

        }
    }


    /**
     * https://leetcode.com/problems/rotate-list/discuss/262400/Simple-java-solution-(0ms-beats-100)
     * 也可见：
     * https://leetcode.com/problems/rotate-list/discuss/22726/Anyone-solve-the-problem-without-counting-the-length-of-List
     * ref总结：
     * 1. 无论如何都要对链表进行遍历，所以先遍历求链表长度
     * 2. 先让链表形成环，之后在断开环
     * @param head
     * @param k
     * @return
     */
    public ListNode ref1RotateRight(ListNode head, int k) {
        if (head == null) {return null;}

        ListNode end, next = head;
        int count = 1;

        while (next.next != null) {
            next = next.next;
            count++;
        }

        end = next;
        end.next = head;
        int iterations = k > count ? count - (k % count) : count - k;

        while (iterations > 0) {
            head = head.next;
            end = end.next;
            iterations--;
        }

        end.next = null;
        return head;
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
        RotateList rotateList = new RotateList();
        rotateList.printAll(node1);
        ListNode newHead = rotateList.adjustRotateRight(node1, 6);
        rotateList.printAll(newHead);

    }
}
