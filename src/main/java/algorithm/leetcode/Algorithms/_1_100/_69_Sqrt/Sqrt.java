package algorithm.leetcode.Algorithms._1_100._69_Sqrt;

/**
 * Created by jialei.zou on 2019/2/27 .

 ref：
 https://leetcode.com/problems/sqrtx/

 Implement int sqrt(int x).

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

 Since the return type is an integer, the decimal digits are truncated and only
 the integer part of the result is returned.

 Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since
 the decimal part is truncated, 2 is returned.
 */
public class Sqrt {

    /**
     * 当初想着使用double数据类型的是，要求返回任何长度精度的结果都能调整
     * mySqrt2使用整数方式解决的
     * ref里面和mySqrt2区别不大，不再单独整理
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        double start = 0;
        double end = x;
        while (start<=end){
            double mid = (start+end)/2;
            double delta = mid*mid-x;
            if(0<=delta && delta<0.1){
                return Double.valueOf(mid).intValue();
            }
            if(mid*mid>x){
                end = mid;
            }else {
                start = mid;
            }
        }
        return -1;
    }


    public static int mySqrt2(int x) {
        int start = 0;
        int end = x;
        while (start<=end){
            int mid = (start+end)/2;

            if((mid*mid-x)<=0 && ((mid+1)*(mid+1)-x)>0){
                return mid;
            }
            if(mid*mid>x){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(10));
        System.out.println();
        System.out.println(mySqrt2(1));
        System.out.println(mySqrt2(2));
        System.out.println(mySqrt2(3));
        System.out.println(mySqrt2(4));
        System.out.println(mySqrt2(5));
        System.out.println(mySqrt2(10));



    }
}
