package algorithm.leetcode.Algorithms._201_300._239_SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by jialei.zou on 2019/2/18 .
 ref: https://leetcode.com/problems/sliding-window-maximum/
 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

 Example:

 Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 Output: [3,3,5,5,6,7]
 Explanation:

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
  1 [3  -1  -3] 5  3  6  7       3
  1  3 [-1  -3  5] 3  6  7       5
  1  3  -1 [-3  5  3] 6  7       5
  1  3  -1  -3 [5  3  6] 7       6
  1  3  -1  -3  5 [3  6  7]      7
 Note:
 You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 */
public class SlidingWindowMaximum {

    /**
     * 只想到了nk的复杂度，后续看下ref
     * 问题是，如果是n的复杂度，如何保证每次都能找到最大值
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i<result.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j<k; j++){
                if(nums[i+j]>max){
                    max = nums[i+j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] maxSlidingWindowRefLearn(int[] nums, int k){
        if(nums==null || k<1){
            return new int[0];
        }
        int length = nums.length;
        int[] result = new int[length - k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i<length; i++){
            if(i>=k){
                if(deque.peek()<=i-k){
                    deque.poll();
                }
            }
            while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                result[i+1-k] = nums[deque.peek()];
            }
        }
        return result;
    }

    /**
     * 知识点
     * 1. Deque的使用
     * 2. 队列中 后面进入的元素，如果比之前进去的元素数值大，则删掉原有元素（否则留着后面也没用），
     * 如果小才保留（前面元素后面就不再滑动窗口里面了），
     * 3. deque里面的存储的index，示例为 5 4 3 2 1 0， 0是头部
     * @param a
     * @param k
     * @return
     */
    public int[] refMaxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        int[] result = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
//        for (int i: result){
//            System.out.printf(i+",");
//        }
//        System.out.println();
//        int[] resultLearn = maxSlidingWindowRefLearn(new int[]{1,3,-1,-3,5,3,6,7}, 3);
//        for (int i: resultLearn){
//            System.out.printf(i+",");
//        }

        System.out.println();
        int[] resultLearn1 = maxSlidingWindowRefLearn(new int[]{7,2,4}, 2);
        for (int i: resultLearn1){
            System.out.printf(i+",");
        }
    }


}
