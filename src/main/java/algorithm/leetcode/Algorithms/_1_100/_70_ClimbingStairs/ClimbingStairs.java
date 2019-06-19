package algorithm.leetcode.Algorithms._1_100._70_ClimbingStairs;

/**
 * Created by jialei.zou on 2019/2/27 .
 ref :
 https://leetcode.com/problems/climbing-stairs/

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    /**
     * 题目因为之前看过，是用动态规划就可以，用递归会存在反复计算同一个f(n)的过程
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int num[] = new int[n+1];
        num[1] = 1;
        num[2] = 2;
        for (int i=3;i<=n;i++){
            num[i]= num[i-1]+num[i-2];
        }
        return num[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));


    }
}
