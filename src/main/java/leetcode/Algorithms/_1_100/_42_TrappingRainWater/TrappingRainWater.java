package leetcode.Algorithms._1_100._42_TrappingRainWater;

/**
 * Created by jialei.zou on 2019/2/28 .
 *
 ref:
 https://leetcode.com/problems/trapping-rain-water/

 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

 图片
 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.
 Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6

 看链接里面的图，接雨水

 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        if(height == null || height.length<=1){
            return 0;
        }
        int size = height.length;
        int[] leftTallest = new int[size];
        int[] rightTallest = new int[size];
        for (int i=1;i<size;i++){
            leftTallest[i] = Math.max(leftTallest[i-1], height[i-1]);
        }
        for (int i=size-2; i>0; i--){
            rightTallest[i] = Math.max(rightTallest[i+1], height[i+1]);
        }
        int sum = 0;
        for (int i = 1; i<size-1;i++){
            if(height[i]<leftTallest[i] && height[i]<rightTallest[i]){
                sum = sum + Math.min(leftTallest[i], rightTallest[i])-height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
