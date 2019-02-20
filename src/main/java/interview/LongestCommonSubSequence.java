package interview;

import java.util.HashMap;

/**
 * 参考：https://blog.csdn.net/u014285517/article/details/50287313
 *
 *
 * 下面这个网址：pos的介绍错误，但可以参考下代码，用于找出序列，实际pos是用于找到最长子序列的上一个元素
 * https://blog.csdn.net/lawrencesgj/article/details/7881851
 *
 */
public class LongestCommonSubSequence {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 4, 6,19, 7, 8};
        int max = getMaxNum(array);
        System.out.println(max);
    }

    public static int getMaxNum(int[] array){
        int length = array.length;
        int[] f = new int[length];
        for(int i = 0; i< length; i++){
            f[i] = 1;
        }
        int max = 0;
        for (int i = 0; i< length;i++){
            for (int j = 0; j<i; j++){
                if(array[i]>array[j]){
                    if(f[i]<f[j]+1){
                        f[i]= f[j]+1;
                        if(f[i]>max){
                            max = f[i];
                        }
                    }
                }
            }
        }
        return max;

    }

}
