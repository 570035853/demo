package leetcode.Algorithms._1_100._11_containerWithMostWater;

/**
 * Created by jialei.zou on 2018/12/21 .
 ref: https://leetcode.com/problems/container-with-most-water/

 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.


 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 the max area of water (blue section) the container can contain is 49.

 Example:

 Input: [1,8,6,2,5,4,8,3,7]
 Output: 49

 */
public class ContainerWithMostWater {


    public static int maxArea(int[] height) {
        int max = 0;
        if(height == null || height.length<2){
            return max;
        }

        for (int i = 0; i<height.length;i++){
            for (int j= i+1; j<height.length; j++){
                int newValue = (j-i)*Math.min(height[i], height[j]);
                if(newValue>max){
                    max = newValue;
                }
            }
        }
        return max;
    }

    //先算最远的双方，然后想中间靠拢，谁小放弃谁
    public static int ref2MaxArea(int[] height){
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while (i<j){
            max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
            if(height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(ref2MaxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
