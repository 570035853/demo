package leetcode.Algorithms._601_700._641_DesignCircularDeque;

/**
 * Created by jialei.zou on 2019/2/18 .
 ref:
 https://leetcode.com/problems/design-circular-deque/
 Design your implementation of the circular double-ended queue (deque).

 Your implementation should support following operations:

 MyCircularDeque(k): Constructor, set the size of the deque to be k.
 insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 isEmpty(): Checks whether Deque is empty or not.
 isFull(): Checks whether Deque is full or not.


 Example:

 MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 circularDeque.insertLast(1);			// return true
 circularDeque.insertLast(2);			// return true
 circularDeque.insertFront(3);			// return true
 circularDeque.insertFront(4);			// return false, the queue is full
 circularDeque.getRear();  			// return 2
 circularDeque.isFull();				// return true
 circularDeque.deleteLast();			// return true
 circularDeque.insertFront(4);			// return true
 circularDeque.getFront();			// return 4


 Note:

 All values will be in the range of [0, 1000].
 The number of operations will be in the range of [1, 1000].
 Please do not use the built-in Deque library.

 如果可以用现有的类，可以用list实现，但题目应该不是这个意思
 可以用数组或链表实现，考虑的问题是
 1. 要不要考虑线程安全

 计划写一个线程不安全的，写一个线程安全的
 后面没写线程安全的，该问题的关注点不再这里
 看下RefDesignCircularDeque: 非常巧妙的设置，将数组的定义形成了环（可以理解为两个圆形成的环）

 */
public class DesignCircularDeque {

    private int curSize = 0;
    private int maxSize;
    private Node front;
    private Node last;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque(int k) {
        maxSize = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(front == null){
            curSize = 1;
            front = new Node(value);
            last = front;
            return true;
        }else {
            if(curSize == maxSize){
                return false;
            }else {
                Node node = new Node(value);
                front.next = node;
                node.pre = front;
                front = node;
                curSize++;
                return true;
            }
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(last == null){
            curSize = 1;
            last = new Node(value);
            front = last;
            return true;
        }else {
            if(curSize == maxSize){
                return false;
            }else {
                Node node = new Node(value);
                node.next = last;
                last.pre = node;
                last = node;
                curSize++;
                return true;
            }
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(curSize<1){
            return false;
        }else {
            if(curSize == 1){
                curSize = 0;
                front = null;
                last = null;
                return true;
            }else {
                curSize--;
                front=front.pre;
                front.next = null;
                return true;
            }
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(curSize<1){
            return false;
        }else {
            if(curSize == 1){
                curSize = 0;
                front = null;
                last = null;
                return true;
            }else {
                curSize--;
                last=last.next;
                last.pre = null;
                return true;
            }
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(curSize == 0){
            return -1;
        }else {
            return front.val;
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(curSize == 0){
            return -1;
        }else {
            return last.val;
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curSize == maxSize;
    }

    private class Node{
        private int val;
        Node(int val){
            this.val = val;
        }
        private Node next;
        private Node pre;
    }

    public static void main(String[] args) {

        DesignCircularDeque obj = new DesignCircularDeque(3);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(2);
        System.out.println(obj.isFull());
        System.out.println(obj.isEmpty());
        System.out.println(obj.getFront());
        System.out.println(obj.getRear());
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
        System.out.println(param_7);
        System.out.println(param_8);
    }
}
