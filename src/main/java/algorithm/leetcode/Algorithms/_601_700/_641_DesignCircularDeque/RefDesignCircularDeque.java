package algorithm.leetcode.Algorithms._601_700._641_DesignCircularDeque;

/**
 * Created by jialei.zou on 2019/2/18 .
 */
public class RefDesignCircularDeque {

    private int[] arr;
    private int front, rear, k;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public RefDesignCircularDeque(int k) {
        arr = new int[k];
        front = 0;
        rear = 0;
        this.k = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        arr[((--front % k) + k) % k] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[((rear++ % k) + k) % k] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front++;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[((front % k) + k) % k];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[((((rear - 1) % k) + k) % k)];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rear - front == k;
    }
}
