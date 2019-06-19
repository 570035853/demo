package algorithm.leetcode.Algorithms._1_100._38_CountAndSay;

/**
 * Created by jialei.zou on 2019/5/22 .
 ref:
 https://leetcode.com/problems/count-and-say/

 The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.



 Example 1:
 Input: 1
 Output: "1"


 Example 2:
 Input: 4
 Output: "1211"
 */
public class CountAndSay {

    /**
     * 总结：
     * 1. 肯定需要两个交替的String
     * 2. 当前的字符及对应的个数分别用一个表示就够了
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String result = "1";
        while (n>1){
            String next = "";
            char c= result.charAt(0);
            int num = 1;
            for (int i = 1; i<result.length(); i++){
                if(result.charAt(i)==c){
                    num++;
                }else {
                    next = next + num + c +"";
                    c = result.charAt(i);
                    num = 1;
                }
            }
            next = next + num + c +"";
            result = next;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
    }
}
