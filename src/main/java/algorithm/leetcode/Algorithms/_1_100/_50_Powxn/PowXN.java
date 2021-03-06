package algorithm.leetcode.Algorithms._1_100._50_Powxn;

/**
 * Created by jialei.zou on 2019/5/30 .
 ref:
 https://leetcode.com/problems/powx-n/

 Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 Example 3:

 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 Note:

 -100.0 < x < 100.0
 n is a 32-bit signed integer, within the range [−231, 231 − 1]

 */
public class PowXN {

    /**
     * 思路是将n按照1，2，4，8这种进行拆分，另外，将x(2的某次方)的放入map中
     *
     * 看下ref，其实并没有考虑溢出的情况，不过学习下解决基数问题，及拆分的方式
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(2, 100));
    }
}
