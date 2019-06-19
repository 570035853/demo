package algorithm.leetcode.Algorithms._1_100._55_JumpGame;

/**
 * Created by jialei.zou on 2018/12/8 .
 * ref: https://leetcode.com/problems/jump-game/solution/


 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 Example 1:

 Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
 jump length is 0, which makes it impossible to reach the last index.



 */
public class JumpGame {

    /**
     * 2019.05.23第一轮回顾的时候写出来的，主要想法：
     * 设置一个能到达的数组，从初始位置开始，挨个向后，依次初始化能到达的位置，最后做判断
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for (int i=0; i<nums.length-1; i++){
            int step = nums[i];
            if(canReach[i]){
                while (step>0){
                    if(i+step<nums.length){
                        canReach[i+step] = true;
                    }
                    step--;
                }
                if(canReach[nums.length-1]){
                    return true;
                }
            }
        }
        //如下不能进行返回，因为有[0]的情况
        //return false;
        return canReach[nums.length-1]==true;
    }

    /**
     * 递归的思想
     * 1. 正向的查找
     * @param position
     * @param nums
     * @return
     */
    public static boolean ref1CanJump(int position, int[] nums){
        if(position == nums.length -1){
            return true;
        }

        int furthestJump = Math.min(nums[position]+position, nums.length -1);
        for (position = position+1; position<=furthestJump; position++){
            if(ref1CanJump(position, nums)){
               return true;
            }
        }
        return false;
    }


    /**
     * 巧妙的理解题意
     * 1. 从后想前的
     * @param nums
     * @return
     */
    public static boolean ref2CanJump(int[] nums){
        int position = nums.length -1;
        for (int i = nums.length -1; i>=0; i--){
            if((nums[i]+i)>=position){
                position = i;
            }
        }
        return position == 0;
    }



    public static void main(String[] args) {
        System.out.println(ref1CanJump(0, new int[]{0, 1, 2}));
        System.out.println(ref2CanJump(new int[]{0, 1, 2}));

        System.out.println(ref1CanJump(0, new int[]{1, 2, 4, 0, 0, 3}));
        System.out.println(ref2CanJump(new int[]{1, 2, 4, 0, 0, 3}));

        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));

    }

}
