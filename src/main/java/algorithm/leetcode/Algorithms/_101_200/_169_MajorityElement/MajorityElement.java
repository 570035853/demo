package algorithm.leetcode.Algorithms._101_200._169_MajorityElement;

import java.util.Arrays;

/**
 * Created by jialei.zou on 2019/2/13 .
 ref:
 Given an array of size n, find the majority element.
 The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:
 Input: [3,2,3]
 Output: 3

 Example 2:
 Input: [2,2,1,1,1,2,2]
 Output: 2
 */
public class MajorityElement {

    /**
     * 如下方式，时间复杂度是o(n2)，空间是0
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    public static int majorityElement2(int[] nums) {
        int count = 1;
        int cur = nums[0];
        for (int i = 1; i<nums.length; i++){
            if(cur == nums[i]){
                count++;
            }else {
                if(count>0){
                    count--;
                }else {
                    cur = nums[i];
                    count = 1;
                }
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        int count=1;
        count++;
        System.out.println("count:"+count);
        System.out.println("result2:"+majorityElement2(new int[]{2,2,1,1,1,2,2}));
        System.out.println("result1:"+majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

}
