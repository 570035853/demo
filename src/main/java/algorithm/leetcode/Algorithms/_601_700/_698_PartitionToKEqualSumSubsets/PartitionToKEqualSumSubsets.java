package algorithm.leetcode.Algorithms._601_700._698_PartitionToKEqualSumSubsets;

import java.util.Arrays;

/**
 * Created by jialei.zou on 2019/4/19 .
 ref:
 https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

 Given an array of integers nums and a positive integer k, find whether it's possible to
 divide this array into k non-empty subsets whose sums are all equal.



 Example 1:

 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.


 Note:

 1 <= k <= len(nums) <= 16.
 0 < nums[i] < 10000.
 */
public class PartitionToKEqualSumSubsets {

    /**
     * demo使用{5, 5, 4, 4, 3, 3, 2, 2}, k=4 可以验证相关逻辑
     * @param groups
     * @param row
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) {return true;}
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) {return true;}
                groups[i] -= v;
            }
            /**
             * 官方给的答案里面，有如下逻辑，实际不需要如下判断，代码逻辑也没有问题，另外，我理解
             */
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {return false;}
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) {return false;}
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }


    enum Result { TRUE, FALSE }


    boolean search(int used, int todo, Result[] memo, int[] nums, int target) {
        if (memo[used] == null) {
            memo[used] = Result.FALSE;
            int targ = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if ((((used >> i) & 1) == 0) && nums[i] <= targ) {
                    if (search(used | (1<<i), todo - nums[i], memo, nums, target)) {
                        memo[used] = Result.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Result.TRUE;
    }

    /**
     * 没看懂，继续看 todo
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsetsDP(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {return false;}

        Result[] memo = new Result[1 << nums.length];
        memo[(1 << nums.length) - 1] = Result.TRUE;
        return search(0, sum, memo, nums, sum / k);
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets subsets = new PartitionToKEqualSumSubsets();
        System.out.println(subsets.canPartitionKSubsets(new int[]{5, 5, 4, 4, 3, 3, 2,2 }, 4));
        System.out.println("second round");
        System.out.println(subsets.canPartitionKSubsetsDP(new int[]{5, 5, 4, 4, 3, 3, 2,2,4 }, 4));

    }
}
