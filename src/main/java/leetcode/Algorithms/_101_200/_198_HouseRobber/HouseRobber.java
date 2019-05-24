package leetcode.Algorithms._101_200._198_HouseRobber;

/**
 * Created by jialei.zou on 2019/5/24 .
 ref:
 https://leetcode.com/problems/house-robber/
 You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed, the only constraint stopping you
 from robbing each of them is that adjacent houses have security system connected and
 it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 Example 1:
 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.


 Example 2:
 Input: [2,7,9,3,1]
 Output: 12
 Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 Total amount you can rob = 2 + 9 + 1 = 12.

 */
public class HouseRobber {

    /**
     * 思考问题应该如下思考，在i的位置要么不抢，则i的值为a[i-1], 如果强则需要比较a[i-1], a[i-2]+a[i]这两个值哪个大
     * 想到的递推公式是a[i]=Math.max(a[i-1], a[i-2]+a[i])
     * 初始化a[0], a[1]
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{1,2,3,1}));
        System.out.println(houseRobber.rob(new int[]{2,7,9,3,1}));

    }
}
