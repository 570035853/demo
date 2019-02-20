package interview;

/**
 * 剑指offer：试题：连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {


    public static int getGreatestSum(int array[]){
        if(array == null || array.length <1){
            return 0;
        }else {
            int sum = 0;
            int max = 0;
            for (int i = 0;i<array.length;i++){
                //**如果小于0，则赋值此次轮训的
                if(sum<0){
                    sum = array[i];
                }else {
                    sum = sum + array[i];
                }
                //**
                if(max<sum){
                    max = sum;
                }

            }
            return max;
        }
    }
}
