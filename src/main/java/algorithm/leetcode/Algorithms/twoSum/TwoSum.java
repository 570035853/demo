package algorithm.leetcode.Algorithms.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jialei.zou on 2018/9/30 .
 * ref:https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {


    public int[] myTwoSum(int[] nums, int target) {
        if(nums.length<2){
            return null;
        }
        int i,j;
        for(i = 0; i< nums.length-1; i++){
            j = i+1;
            if(j<nums.length){
                for(;j<nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return null;
    }

    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {   //实际此步可以改为i < nums.length-1
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }



    public int[] twoPathHashTable(int[] nums, int target){
        if(nums.length<2){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length; i++){
            map.put(nums[i],i);
        }
        for (int i = 0;i<nums.length; i++){
            Integer j = map.get(target-nums[i]);
            if(j!=null && i!=j){
                return new int[]{i,j};
            }
        }
        return null;
    }

    /**
     * 学习下命名 complement
     * @param nums
     * @param target
     * @return
     */
    public int[] onePathHashTable(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i= 0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return null;
    }




}
