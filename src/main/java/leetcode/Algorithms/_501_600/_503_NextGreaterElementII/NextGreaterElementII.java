package leetcode.Algorithms._501_600._503_NextGreaterElementII;

import java.util.Stack;

/**
 * Created by jialei.zou on 2019/5/29
 ref:
 https://leetcode.com/problems/next-greater-element-ii/
 Given a circular array (the next element of the last element is the first element of the array),
 print the Next Greater Number for every element. The Next Greater Number of a number x is
 the first greater number to its traversing-order next in the array,
 which means you could search circularly to find its next greater number.
 If it doesn't exist, output -1 for this number.

 Example 1:
 Input: [1,2,1]
 Output: [2,-1,2]
 Explanation: The first 1's next greater number is 2;
 The number 2 can't find next greater number;
 The second 1's next greater number needs to search circularly, which is also 2.
 Note: The length of given array won't exceed 10000.

 */
public class NextGreaterElementII {

    /**
     利用的是每个元素分别循环找的方式，但是效率比较低
     Runtime: 140 ms, faster than 6.10% of Java online submissions for Next Greater Element II.
     Memory Usage: 50.4 MB, less than 12.46% of Java online submissions for Next Greater Element II.
     看下官方答案
     总结：
     一、单调栈的问题
     1. 对于寻找右侧第一个大于或小于某个元素的，需要从后向前遍历，反之，从前向后遍历

     二、循环2遍，因为要形成环


     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null){
            return nums;
        }
        int length = nums.length;
        int[] result = new int[length];
        for (int i=0; i<length; i++){
            int nextBigIndex = i+1;
            while (nextBigIndex % length != i){
                int index = nextBigIndex%length;
                if(nums[index]>nums[i]){
                    result[i] = nums[index];
                    break;
                }
                nextBigIndex ++;
            }
            if(nextBigIndex % length == i){
                result[i] = -1;
            }
        }

        return result;
    }

    /**
     * ref: https://leetcode.com/articles/next-greater-element-ii/
     * [3, 8, 4, 1, 2]
     * 类似的问题：962
     * @param nums
     * @return
     */
    public int[] nextGreaterElementsRef(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public int[] nextGreaterElementsRefPractise(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length*2-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek()<=nums[i%nums.length]){
                stack.pop();
            }
            result[i%nums.length] = stack.isEmpty()?-1: nums[stack.peek()];
            stack.push(nums[i%nums.length]);
        }
        return result;
    }


    public static void main(String[] args) {
        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        int[] result = nextGreaterElementII.nextGreaterElements(new int[]{1,2,1});
        for (int item: result){
            System.out.printf(item+",");
        }
    }
}
