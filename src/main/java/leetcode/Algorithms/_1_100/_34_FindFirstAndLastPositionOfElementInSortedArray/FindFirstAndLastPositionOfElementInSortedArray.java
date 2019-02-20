package leetcode.Algorithms._1_100._34_FindFirstAndLastPositionOfElementInSortedArray;

/**
 * Created by jialei.zou on 2018/12/15 .
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]


 */
public class FindFirstAndLastPositionOfElementInSortedArray {


    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = nums.length-1;

        int left=-1, right = -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }else {
                if(nums[mid] == target){
                    if(mid == 0 || nums[mid-1]<target){
                        left = mid;
                        break;
                    }else {
                        high = mid-1;
                    }
                }else {
                    high = mid-1;
                }
            }
        }

        low = 0;
        high = nums.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>target){
                high = mid-1;
            }else {
                if(nums[mid] == target){
                    if(mid==nums.length-1||nums[mid+1]>target){
                        right = mid;
                        break;
                    }else {
                        low = mid+1;
                    }
                }else {
                    low = mid+1;
                }
            }
        }
        return new int[]{left, right};

    }

    public static int[] searchRangeV1(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = nums.length-1;

        int left=-1, right = -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }else {
                if(nums[mid] == target){
                    if(mid == 0 || nums[mid-1]<target){
                        left = mid;
                        right = findRight(nums, left, nums.length-1, target);
                        break;
                    }else {
                        high = mid-1;
                    }
                }else {
                    high = mid-1;
                }
            }
        }

        return new int[]{left, right};

    }


    private static int findRight(int[] nums, int low, int high, int target){
        int mid = low+(high-low)/2;
        while (low<=high){
            mid = low+(high-low)/2;
            if(nums[mid]>target){
                high = mid-1;
            }else {
                if(nums[mid] == target){
                    if(mid==nums.length-1||nums[mid+1]>target){
                        return mid;
                    }else {
                        low = mid+1;
                    }
                }else {
                    low = mid+1;
                }
            }
        }
        return mid;
    }

    private static void printArray(int[] array){
        for (int item: array){
            System.out.printf(item+",");
        }
        System.out.printf("");
    }

    public static void main(String[] args) {
//        int resultExist[] = searchRange(new int[]{5}, 5);
//        System.out.printf("resultExist:");
//        printArray(resultExist);
//
//        int resultExistV1[] = searchRange(new int[]{5}, 5);
//        System.out.printf("resultExistV1:");
//        printArray(resultExistV1);

//        int resultExist[] = searchRange(new int[]{5,7,7,8,8,10}, 8);
//        int resultNotExist[] = searchRange(new int[]{5,7,7,8,8,10}, 6);
//
//        System.out.printf("resultExist:");
//        printArray(resultExist);
//        System.out.printf("resultNotExist:");
//        printArray(resultNotExist);

        int resultExistV1[] = searchRangeV1(new int[]{5,7,7,8,8,10}, 8);
        System.out.printf("resultExistV1:");
        printArray(resultExistV1);

    }



}
