package leetcode.Algorithms._1_100._11_containerWithMostWater;

/**
 * Created by jialei.zou on 2018/12/21 .
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
