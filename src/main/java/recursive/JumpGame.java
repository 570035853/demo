package recursive;

/**
 * Created by jialei.zou on 2018/12/8 .
 * ref: https://leetcode.com/problems/jump-game/solution/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        return false;
    }

    /**
     * 递归的思想
     * 1.
     * 2.
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
     * 1.
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

    }

}
