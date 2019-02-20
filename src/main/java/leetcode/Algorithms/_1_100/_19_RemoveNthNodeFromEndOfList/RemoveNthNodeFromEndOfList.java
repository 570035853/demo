package leetcode.Algorithms._1_100._19_RemoveNthNodeFromEndOfList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/12/14 .
 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.

 Follow up:

 Could you do this in one pass?

 ref: https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/

 */
public class RemoveNthNodeFromEndOfList {


    public static Node myRemoveNthNodeFromEndOfList(Node head, int n){
        List<Node> copyList = new ArrayList<>();
        Node current = head;
        while (current!=null){
            copyList.add(current);
            current = current.next;
        }
        int position = copyList.size() -n;
        if(position ==0){
            head = head.next;
        }else {
            copyList.get(position-1).next = copyList.get(position).next;
        }
        return head;
    }

    private static void printList(Node node){
        while (node != null){
            System.out.println(node.value+",");
            node = node.next;
        }
    }

    /**
     * 编写的时候遇到如下问题：
     * 1. Node fast = dummy; 这种的时候，在内存中，怀疑fast和dummy是否为同一地址
     * 答疑：
     * Node fast = dummy是两步动作：A new一个新的空间，其内保存的是dummy指向的地址，所以dummy的值改变，不影响fast改变
     * 本题心得：
     * 1. 滑动窗口的思想很好；
     * 2. 如果n=2，两者需要间隔开，确保fast-slow = 2；主要是要保存删除节点的前一个节点，否则无法删除，例如fast = 3， second =1
     *  由于边界为可能为2，所以，需要有一个dummy出来，才能保证有3
     *
     * @param head
     * @param n
     * @return
     */
    private static Node ref1RemoveNthNodeFromEndOfList(Node head, int n){
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        for (int i = 0; i<n; i++){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        Node removedList = myRemoveNthNodeFromEndOfList(node1, 2);
        Node removedList = ref1RemoveNthNodeFromEndOfList(node1, 5);
        printList(removedList);
    }


    /**
     * recursive method
     * 1.拆分过程:
     * 认识到head.next == null实际是可以，确定该位置为倒数第1个的
     * 假设已经知道倒数第n个，那么当下这个就是倒数n+1个。
     * 2. dummy的想法和上面是一样的
     */

    public Node removeNthFromEnd(Node head, int n) {
        Node newHead = new Node(0);
        newHead.next = head;
        remove(newHead, n);
        return newHead.next;
    }

    private int remove(Node head, int n) {
        if (head.next == null) {
            return 1;
        }
        int next = remove(head.next, n);
        if (next == n) {
            head.next = head.next.next;
        }
        return ++next;
    }
}
