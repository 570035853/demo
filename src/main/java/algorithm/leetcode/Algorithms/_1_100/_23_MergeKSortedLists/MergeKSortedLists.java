package algorithm.leetcode.Algorithms._1_100._23_MergeKSortedLists;

/**
 * Created by jialei.zou on 2019/2/14 .
 ref:
 https://leetcode.com/problems/merge-k-sorted-lists/

 Merge k sorted linked lists and return it as one sorted list.
 Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    /**
     * 写代码的时候，总体思路没有问题，逐个遍历链表中的第一个元素，需要注意的点是
     * 1. 如果找到第一个不是null的有值，并且最小的值，目前用的方式是每走一遍，
     *    将最小值置为Integer.MAX_VALUE，找到更小的值<=即便替换，参照下ref如何解决的这个问题
     * 2. 设置头结点前置节点dummy，移动节点curNode
     * 3. 终止条件是所有的序列都是null，allInnerListNull=true
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        int curPos = -1;
        int max = Integer.MAX_VALUE;
        boolean allInnerListNull = false;
        while (!allInnerListNull){
            allInnerListNull = true;
            for (int i = 0; i<lists.length; i++){
                ListNode firstNode = lists[i];
                if(firstNode != null && firstNode.val<=max){
                    max = firstNode.val;
                    curPos = i;
                    allInnerListNull = false;
                }
            }
            if(!allInnerListNull){
                curNode.next = lists[curPos];
                curNode = curNode.next;
                lists[curPos] = lists[curPos].next;
                max = Integer.MAX_VALUE;
            }
        }
        return dummy.next;

    }

    /**
     * ref:
     * https://leetcode.com/problems/merge-k-sorted-lists/discuss/10640/Simple-Java-Merge-Sort
     * 补充：
     * 其实ref里面没有必要判断start<end，已经保证了
     *
     * 看了ref之后自己重新手写
     * @param lists
     * @return
     */
    public static ListNode mergeKListsRefAdjust(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        return helper(lists, 0, lists.length-1);
    }

    public static ListNode helper(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = (end - start)/2 +start;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid+1, end);
        return merge(left, right);
    }

    /**
     * 自己又写了一遍，写之前想清楚需要哪些变量
     * 保留头部指针dummyNode， 需要移动指针cur
     * 比较大小并移动ab
     * 最终判断剩下的都加进来
     * @param a
     * @param b
     * @return
     */
    public static ListNode merge(ListNode a, ListNode b){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while (a != null && b!= null){
            if(a.val>b.val){
                cur.next = b;
                b = b.next;
            }else {
                cur.next = a;
                a = a.next;
            }
            cur = cur.next;
        }
        if(a != null){
            cur.next = a;
        }else {
            cur.next = b;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);

        b1.next = b3;
        b3.next = b4;

        ListNode c2 = new ListNode(2);
        ListNode c6 = new ListNode(6);
        c2.next = c6;

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = a1;
        listNodes[1] = b1;
        listNodes[2] = c2;

        ListNode aAndB = merge(a1, b1);
        ListNode head = mergeKLists(listNodes);

        System.out.println();

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
