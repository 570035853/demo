package leetcode.Algorithms._1_100._43_MultiplyStrings;

/**
 * Created by jialei.zou on 2019/3/1 .
 ref:
 https://leetcode.com/problems/multiply-strings/

 Given two non-negative integers num1 and num2 represented as strings,
 return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class MultiplyStrings {

    /**
     * 思考点：
     * 1. while条件的循环，最终的判断点就是highDigitAddValue>0，确定了这一点，代码就清晰了，
     * 开始的时候想的比较多，但没有理清楚这一点
     *
     * 注意点：
     * 1. Integer.valueOf(num2.charAt(num2Length-1-i)-'0') 最后要减0
     * 2. num1.equals("0")的判断，判断要在最初，后续逻辑考虑的都是又数字的
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int num1Length = num1.length();
        int num2Length = num2.length();
        int result[] = new int[num1Length+num2Length];
        for (int i=0; i<num2Length; i++){
            for (int j=0; j<num1Length; j++){
                int innerResult = Integer.valueOf(num2.charAt(num2Length-1-i)-'0')*
                        Integer.valueOf(num1.charAt(num1Length-1-j)-'0');
                int pos = i+j;
                int highDigitAddValue =(result[pos] + innerResult)/10;
                result[pos] =(result[pos] + innerResult)%10;
                while (highDigitAddValue>0){
                    pos = pos+1;
                    result[pos] = result[pos] + highDigitAddValue;
                    if(result[pos]>=10){
                        result[pos] = result[pos]%10;
                        highDigitAddValue = 1;
                    }else {
                        highDigitAddValue = 0;
                    }
                }
            }
        }
        String resultStr = "";
        int i=result.length-1;
        for (; i>=0; i--){
            if(result[i]>0){
                break;
            }
        }
        for (;i>=0;i--){
            resultStr = resultStr + result[i];
        }
        return resultStr;
    }

    /**
     * 如下解决算法在看到过程中，思考时间较长的点
     * 1. 如何确定p1和p2位置：可知i=m-1,j=n-1的时候，是result数组的最后两个位置，m+n-1及m+n-2，对应i+j+1及i+j
     * 2. pos[p1]的位置会不会超过10：会超过，但是最终result[0]肯定不会，
     *    因为m，n相乘，位数要么是m+n-1（100*10）要么m+n(99*9), 而pos[p1]是不断向前进位的，
     *    所以自己的while循环是没有必要的，后续冲下下那块 todo
     * @param num1
     * @param num2
     * @return
     */
    public static String refMultiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            if(!(sb.length() == 0 && p == 0)) {  //长度为0，并且p==0 表明还没到非0的位置
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private static void printArray(int[] array){
        for (int item: array){
            System.out.printf(item+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        System.out.println(Integer.valueOf("2".charAt(0)-'0'));
//        System.out.println(multiply("2", "3"));
//        System.out.println(multiply("123", "456"));
//        System.out.println(multiply("0", "0"));

        System.out.println(refMultiply("999", "999"));



    }
}
