package algorithm.leetcode.Algorithms._101_200._153_FindMinimumInRotatedSortedArray;

/**
 * Created by jialei.zou on 2019/5/29 .
 ref:
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Example 1:

 Input: [3,4,5,1,2]
 Output: 1
 Example 2:

 Input: [4,5,6,7,0,1,2]
 Output: 0
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        //未进行反转的暂时不考虑，题目的测试类里面需要考虑
        int low = 0; int high = nums.length-1;
        if(nums[low]<=nums[high]){
            return nums[low];
        }
        while (low<high-1){
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[low]){
                low = mid;
            }else {
                high = mid;
            }
        }
        return nums[high];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sortedArray = new FindMinimumInRotatedSortedArray();
        System.out.println(sortedArray.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
