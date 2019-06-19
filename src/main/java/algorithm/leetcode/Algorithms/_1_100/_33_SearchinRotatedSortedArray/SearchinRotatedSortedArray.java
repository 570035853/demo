package algorithm.leetcode.Algorithms._1_100._33_SearchinRotatedSortedArray;

/**
 * Created by jialei.zou on 2019/2/22 .
 https://leetcode.com/problems/search-in-rotated-sorted-array/

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:
 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4

 Example 2:
 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null||nums.length<1){
            return -1;
        }
        if(nums.length == 1){
            return nums[0]==target?0:-1;
        }
        int low = 0, high = nums.length-1;
        while (high-low>1){
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[low]){
                low=mid;
            }else {
                high=mid;
            }
        }
        int result = binSearch(nums, 0, low, target);
        if(result != -1){
            return result;
        }else {
            return binSearch(nums, high, nums.length-1, target);
        }

    }

    private int binSearch(int[] nums,int start,int end, int target){
        int low =start;
        int high = end;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }


    int search(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) {
                lo=mid+1;
            } else {
                hi=mid;
            }
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target){
                return realmid;
            }
            if(A[realmid]<target){
                lo=mid+1;
            } else {
                hi=mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchinRotatedSortedArray sortedArray = new SearchinRotatedSortedArray();
        System.out.println(sortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(sortedArray.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
