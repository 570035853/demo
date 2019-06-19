package algorithm.leetcode.Algorithms._501_600._560_SubarraySumEqualsK;

import java.util.HashMap;

/**
 * Created by jialei.zou on 2019/6/13 .
 ref:
 https://leetcode.com/problems/subarray-sum-equals-k/

 Given an array of integers and an integer k, you need to find
 the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {

    /**
     * o(n2)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result =0;
        if(nums == null|| nums.length<1){
            return 0;
        }
        int len = nums.length;
        int sums[] = new int[len];
        sums[0] = nums[0];
        for (int i=1; i<len; i++){
            sums[i] = nums[i]+sums[i-1];
        }
        for (int i =0; i<nums.length; i++){
            if(sums[i]==k){
                result++;
            }
            for (int j=0; j<i; j++){
                if(sums[i]-sums[j]==k){
                    result++;
                }
            }
        }

        return result;
    }


    /**
     * 从前面向后加
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumRef2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 该方法实际是subarraySum的升级版本，通过hashmap这种o(1)方式直接确定之前的一系列之和是否有合适的
     * 当前元素，前面的一系列加和，可能有相同的，那就对map的数量进行加1就可以了
     * o(n)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumRef1(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        //为何需要put一个0进去？？？
        //可以想想为之前还有很多的数组，到这个数组的时候，之前的所有的加和是0
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    /**
     * 如下方式思路错误，解决不了{-1,-1,1}, 0的情况
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumWrong(int[] nums, int k) {
        if(nums == null|| nums.length<1){
            return 0;
        }
        int from =0, to = 0, sum=nums[0], result = 0;
        while (from<nums.length && to<nums.length && from<=to){

            while (Math.abs(sum)<Math.abs(k) && (to+1)<nums.length){
                to++;
                sum= sum+nums[to];
            }
            while (Math.abs(sum)>Math.abs(k)&& from<=to){
                sum= sum-nums[from];
                from++;
            }
            if(sum==k && from<=to){
                result++;
                sum=sum-nums[from];
                from++;
            }
            if(from>=(nums.length-1) && to>=(nums.length-1)){
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        SubarraySumEqualsK equalsK = new SubarraySumEqualsK();
        System.out.println(equalsK.subarraySum(new int[]{1,1,1}, 2));
        System.out.println(equalsK.subarraySum(new int[]{1,2,1,2,1}, 3));
        System.out.println(equalsK.subarraySum(new int[]{1}, 0));
        System.out.println(equalsK.subarraySum(new int[]{-1,-1,1}, 0));

        System.out.println(equalsK.subarraySum(new int[]{0,0,0}, 0));
        System.out.println(equalsK.subarraySumRef1(new int[]{0,0,0}, 0));





    }


}
