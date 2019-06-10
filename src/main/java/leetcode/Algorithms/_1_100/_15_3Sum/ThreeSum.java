package leetcode.Algorithms._1_100._15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/11/25 .
 * ref:
 https://leetcode.com/problems/3sum/

 Given an array nums of n integers, are there elements a, b, c
 in nums such that a + b + c = 0? Find all unique triplets
 in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 * 存在的问题：如何对结果进行去重
 */
public class ThreeSum {

    /**
     * 自己后面写一遍实现
     * 1. 对数组进行sort，之后就变的有序了
     * 2. 对结果进行去重的方式比较巧妙
     * @param A
     * @return
     */
    public static List<List<Integer>> refThreeSum(int[] A) {
        List<List<Integer>>res = new ArrayList<>();
        if (A == null || A.length == 0){
            return res;
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i - 1 >= 0 && A[i] == A[i - 1]) {
                continue;// Skip equal elements to avoid duplicates
            }

            int left = i + 1, right = A.length - 1;
            while (left < right) {// Two Pointers
                int sum = A[i] + A[left] + A[right];
                if (sum == 0) {
                    res.add(Arrays.asList(A[i], A[left], A[right]));
                    while (left + 1 < right && A[left] == A[left+1]){// Skip equal elements to avoid duplicates
                        left++;
                    }
                    while (right -1 > left && A[right] == A[right-1]){// Skip equal elements to avoid duplicates
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> learnThreeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i<nums.length; i++){
            if(i>=1 && nums[i]==nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i]+ nums[left]+nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left],nums[right]));
                    while (left+1<right && nums[left+1]==nums[left]){
                        left++;
                    }
                    while (right-1>left && nums[right-1]==nums[right]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    right--;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> resultList = refThreeSum(new int[]{-1, -1, -1, 0, 0, 0, 1, 1, 2, 3});

        for(List<Integer> innerList: resultList){
            for (Integer item : innerList){
                System.out.print(item+",");
            }
            System.out.println();
        }
    }
}
