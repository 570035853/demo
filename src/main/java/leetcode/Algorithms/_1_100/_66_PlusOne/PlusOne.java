package leetcode.Algorithms._1_100._66_PlusOne;

/**
 * Created by jialei.zou on 2019/1/10
 ref: https://leetcode.com/problems/plus-one/
 Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list,
 and each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

 Example 1:
 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.

 Example 2:
 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 */
public class PlusOne {

    /**
     * 思路还是比较简单的，主要是实现，要求就是+1，
     * 如果末尾<9,直接+1
     * 如果末位等于9，变为0，前一位1，前一位也是相同情况，不断向前+1，直到数组第一位，如果还是9，得给数组增加一位了
     *
     * 推荐的答案里面思路和我是一致的，不过推荐的答案里面，更巧妙的地方是，该返回的时候就直接返回了，所以后续没有
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i>=0; i--){
            if(digits[i]<9){
                digits[i] = digits[i]+1;
                break;
            }else {
                digits[i] =0;
            }
        }
        if(digits[0]==0){
            int[] newDigit = new int[length+1];
            newDigit[0]=1;
            return newDigit;
        }
        return digits;
    }

    private static void printNums(int[] digits){
        for (int item: digits){
            System.out.printf(item+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] result = plusOne(new int[]{4,3,2,2});
        int[] result1 = plusOne(new int[]{0});
        int[] result2 = plusOne(new int[]{9,9,9});
        printNums(result);
        printNums(result1);
        printNums(result2);
    }

    public int[] refPlusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                //1.更优的地方，该返回就直接返回了
                return digits;
            }

            digits[i] = 0;
        }

        //2.更优化的地方，因为有前一步的返回，所以这个地方不用做在做判断了
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
