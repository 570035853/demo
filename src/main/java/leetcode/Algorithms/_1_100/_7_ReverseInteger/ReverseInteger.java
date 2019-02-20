package leetcode.Algorithms._1_100._7_ReverseInteger;

/**
 * Created by jialei.zou on 2018/11/20 .
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {


    /**
     * 没有想出来，如果翻转后，超过最大值如何处理
     * 1. 正数的最大值末尾肯定是7（111），负数的最大值是（-8）
     * 2. 4/10和6/10最后都是0，-4/10和-6/10最后也都是0，所以/10操作可以认为是消去最后一位
     *
     * @param value
     * @return
     */
    public static int myReverseInteger(int value){
        String result = "";
        boolean negative = false;
        if(value<0){
            negative = true;
        }
        value = Math.abs(value);
        while (value>0){
            int reminder = value - 10*(value/10);
            value = value/10;
            result = result + reminder;
        }
        if(negative){
            result = "-"+result;
        }
        return new Integer(result).intValue();
    }

    public static int modifyReverse(int x){
        int result = 0;
        while (x != 0){
            int reminder = x % 10;
            x = x/10;
            if(result>Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && reminder>7)){
                return 0;
            }
            if(result<Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && reminder<-8)){
                return 0;
            }
            result = result*10 + reminder;
        }

        return result;
    }

    //2147483647  2147483648
    //相当于比较了最大值和最小值
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println("1235 reverse:"+myReverseInteger(1235));
        System.out.println("-1235 reverse:"+myReverseInteger(-1235));
        System.out.println("1235 reverse:"+modifyReverse(1235));
        System.out.println("-1235 reverse:"+modifyReverse(-1235));
        System.out.println(-6/10);
        System.out.println(-4/10);
        System.out.println(-466%10);

    }

}
