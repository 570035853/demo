package algorithm.leetcode.Algorithms._1_100._53_MaximumSubarray;

/**
 * Created by jialei.zou on 2019/1/9 .
 * ref: https://leetcode.com/problems/maximum-subarray/

 Given an integer array nums, find the contiguous subarray (containing at least one number)
 which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and
 conquer approach, which is more subtle.


 */
public class MaximumSubarray {

    /**
     * 思考该问题，最重要的是思考sum>0以及<=0的时候，sum的赋值操作
     * 看下其他人的答案
     * 1. ref里面给了一个更标准的答案，其实思路和我的差不多
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int sum = nums[0];
        int max = nums[0];

        for (int i= 1; i<nums.length; i++){
            if(sum<=0){
                sum = nums[i];
            }else {
                sum = sum+nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }


    /**
     * 想法就是，之前相加的最大值，加上cur，和cur比较，谁大保留谁
     * @param A
     * @return
     */
    public static int refMaxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}
