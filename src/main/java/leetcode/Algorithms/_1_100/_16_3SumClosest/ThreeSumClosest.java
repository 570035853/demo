package leetcode.Algorithms._1_100._16_3SumClosest;

import java.util.Arrays;

/**
 * Created by jialei.zou on 2018/11/25 .
 * ref: https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    /**
     * 提交能通过，但是效率特别低
     * @param nums
     * @param target
     * @return
     */
    public static int myThreeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length<3){
            return 0;
        }
        int delta = Integer.MAX_VALUE;
        int result = 0;
        for (int i=0;i<nums.length;i++){
            for (int j= i+1; j<nums.length; j++){
                for (int k = j+1; k<nums.length; k++){
                    int sum = Math.abs((nums[i]+nums[j]+nums[k])-target);
                    if(sum<delta){
                        delta = Math.abs((nums[i]+nums[j]+nums[k])-target);
                        result = nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }

        return result;
    }


    /**
     *  https://leetcode.com/problems/3sum-closest/discuss/195679/Java-O(n2)-solution-beats-99.96
     *  总结：思维是没有想到可以先排序
     *  1. 先排序，后前后分别查找；
     *  2. Arrays.sort是升序排列
     * @param nums
     * @param target
     * @return
     */
    public int ref1ThreeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int k=0;k<nums.length-2;k++){
            int val = target - nums[k];
            for(int i=k+1, j=nums.length-1;i<j;){
                int d = val - nums[i] - nums[j];
                if(d==0){
                    return target;
                }

                if(d<0){
                    j--;
                }
                else{
                    i++;
                }

                int abs = Math.abs(d);
                if(diff>abs){
                    diff = abs;
                    sum = target - d;
                }
            }
        }
        return sum;
    }


    /**
     * https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
     * 1. 初始最大值的设定
     * @param num
     * @param target
     * @return
     */
    public int ref2threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("closest sum:"+myThreeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
