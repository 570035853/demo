package leetcode.Algorithms._1_100._81_SearchInRotatedSortedArrayII;

/**
 * Created by jialei.zou on 2019/3/27 .
 ref:
 https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

 You are given a target value to search. If found in the array return true, otherwise return false.

 Example 1:

 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true
 Example 2:

 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false
 Follow up:

 This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if(nums == null){
            return false;
        }
        int index = findRotateIndex(nums);
        if(index == -1){
            return binSearch(nums, 0, nums.length-1, target);
        }else {
            return binSearch(nums, 0, index, target) ||
                   binSearch(nums, index+1, nums.length-1, target);
        }
    }

    private boolean binSearch(int[] nums, int start, int end, int target){
        while (start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid]>target){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return false;
    }

    /**
     * 注意，此种方式下，不能在end = mid-1这种了，{2,5,6,0,0,1,2}下，第一0，-1直接就变换到6了，不同于二分查找，一定不会错过
     * @param nums
     * @return
     */
    private int findRotateIndex(int[] nums){
        if(nums == null || nums.length<2){
            return -1;
        }
        int start = 0; int end = nums.length-1;
        while (start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid+1]){
                return mid;
            }
            if(nums[mid]<nums[end]){
                end = mid;
            }else if(nums[mid]>nums[end]){
                start = mid;
            }else {//nums[mid]==nums[end]
                if(nums[start] == nums[mid]){
                    return linearSearch(nums, start, end);
                }else {//nums[start] > nums[mid]
                    end = mid;
                }
            }
        }

        return -1;
    }

    private int linearSearch(int[] nums, int start, int end){
        while (start<end){
            if(nums[start]>nums[start+1]){
                return start;
            }
            start++;
        }
        return -1;
    }


    /**
     * ref:
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28216/Java-1ms-binary-search-solution-with-comments
     * todo  继续看
     * @param nums
     * @param target
     * @return
     */
    public boolean refSearch(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start]) start = mid + 1;
                else end = mid;
            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII search = new SearchInRotatedSortedArrayII();
        System.out.println(search.findRotateIndex(new int[]{2,5,6,0,0,1,2}));
        System.out.println(search.findRotateIndex(new int[]{0,0,1,2}));
        System.out.println(search.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(search.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(search.search(new int[]{2,5,6}, 3));
        System.out.println(search.search(new int[]{2,5,6}, 5));
        System.out.println(search.search(new int[]{2}, 5));
        System.out.println(search.search(new int[]{2}, 2));
        System.out.println(search.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 2));


    }
}
