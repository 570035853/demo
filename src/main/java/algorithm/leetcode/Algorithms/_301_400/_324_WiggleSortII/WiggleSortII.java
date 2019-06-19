package algorithm.leetcode.Algorithms._301_400._324_WiggleSortII;

import common.ArraysUtils;

import java.util.Arrays;

/**
 * Created by jialei.zou on 2019/6/18 .
 ref:
 https://leetcode.com/problems/wiggle-sort-ii/

 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example 1:

 Input: nums = [1, 5, 1, 1, 6, 4]
 Output: One possible answer is [1, 4, 1, 5, 1, 6].
 Example 2:

 Input: nums = [1, 3, 2, 2, 3, 1]
 Output: One possible answer is [2, 3, 1, 3, 1, 2].
 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?

 */
public class WiggleSortII {

    /**

     对于如下方式，自己的思路无法解决
     int cannot[] = new int[]{4,5,5,6};

     * @param nums
     */
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<2){
            return;
        }
        Arrays.sort(nums);
        int result[] = new int[nums.length];
        int low = 0, i = 0;
        int mid = (nums.length-1-low)/2;
        int high = mid+1;
        boolean fromLow = true;
        while (low<=mid || high<nums.length){
            if(fromLow){
                result[i++] = nums[low++];
            }else {
                result[i++] = nums[high++];
            }

            fromLow = !fromLow;
        }
        for (int j=0; j<nums.length; j++){
            nums[j] = result[j];
        }
        return;
    }

    public static void main(String[] args) {
        WiggleSortII sortII = new WiggleSortII();
        int nums[] = new int[]{1, 5, 1, 1, 6, 4};
        sortII.wiggleSort(nums);
        ArraysUtils.printIntArray(nums);


    }


}
