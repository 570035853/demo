package algorithm.leetcode.Algorithms._1_100._45_JumpGameII;

/**
 * Created by jialei.zou on 2019/6/16 .
 ref:
 https://leetcode.com/problems/jump-game-ii/

 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 Example:

 Input: [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
 Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Note:

 You can assume that you can always reach the last index.

 */
public class JumpGameII {

    /**
     Runtime: 421 ms, faster than 5.04% of Java online submissions for Jump Game II.
     Memory Usage: 41.2 MB, less than 31.01% of Java online submissions for Jump Game II.
     思路就是：
     dp，result代表达到当前位置的最小步骤，具体过程是，从第一步开始，就看能到达什么位置，并记录到相应位置步数，
     其实还能优化，第一个找到终点的就return就可以了
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] result = new int[nums.length];
        for (int i =0 ; i<nums.length-1; i++){
            int step = nums[i];
            for (int j = 1; j<=step; j++){
                if((i+j) >= nums.length){
                    break;
                }
                if(result[i+j] == 0){
                    result[i+j] = result[i]+1;
                }
            }
        }
        return result[nums.length-1];
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{2,3,1,1,4}));
    }
}
