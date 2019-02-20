package leetcode.Algorithms._1_100._29_DivideTwoIntegers;

/**
 * Created by jialei.zou on 2018/12/22 .
 ref: https://leetcode.com/problems/divide-two-integers/
 Given two integers dividend and divisor, divide two integers
 without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.

 Example 1:

 Input: dividend = 10, divisor = 3
 Output: 3
 Example 2:

 Input: dividend = 7, divisor = -3
 Output: -2
 Note:

 Both dividend and divisor will be 32-bit signed integers.
 The divisor will never be 0.
 Assume we are dealing with an environment which could only store integers
 within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 */
public class DivideTwoIntegers {

    /**
     * 自己想到的就是不听的减去，同事控制一下正负数
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        return 0;
    }

    /**
     * 如下两点是，转换成了指数级别的复杂度
     * @param dividend
     * @param divisor
     * @return
     */
    public int ref1divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    // It's easy to handle edge cases when
// operate with long numbers rather than int
    public long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }

        // Return if nothing to divide
        if (dividend < divisor) {
            return 0;
        }

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            divide += divide;
        }

        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
                (divide + divideLong((dividend-sum), divisor));
    }
}
