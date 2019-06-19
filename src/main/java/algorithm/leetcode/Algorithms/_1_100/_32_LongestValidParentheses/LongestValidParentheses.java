package algorithm.leetcode.Algorithms._1_100._32_LongestValidParentheses;

import algorithm.leetcode.Algorithms._1_100._20_ValidParentheses.ValidParentheses;

import java.util.Stack;

/**
 * Created by jialei.zou on 2019/2/15 .
 ref:
 https://leetcode.com/problems/longest-valid-parentheses/

 Given a string containing just the characters '(' and ')',
 find the length of the longest valid (well-formed) parentheses substring.

 Example 1:
 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"

 Example 2:
 Input: ")()())"
 Output: 4

 Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    /**
     * ) (()) ((( ((()))
     *    4         6
     * 没有想清楚如上怎么计算，想到的方法是是n2的方式查询，检查每一个开始，到任意结束位置，确认是否为有效的输入（题目20的方法）
     *
     * 后记录：
     * 自己用的方法就是答案里面给的brute force， 复杂度是o(n3)
     *
     * 知识点：
     * 1. "abc".substring(0,3)结果是abc, 3所在的位置不包括，也不越界
     * 2. DP的方式见下面的ref
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int max = 0;
        if(s == null || s.length() == 0){
            return max;
        }
        for (int i = 0; i<s.length(); i++){
            for (int j=i+1; j<s.length();j++){
                System.out.println(s.substring(i,j+1)+","+i+","+j);
                if(ValidParentheses.isValid(s.substring(i,j+1))){
                    max = Math.max(max, j+1-i);
                }
            }
        }
        return max;
    }

    /**
     * 看了DP之后的自我练习
     * @param s
     * @return
     */
    public static int longestValidParenthesesPractise(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i=1; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2?dp[i-2]+2:2);
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = (i-dp[i-1])>=2? (dp[i-dp[i-1]-2]+dp[i-1]+2):(dp[i-1]+2);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 以下是ref中的DP
     * @param s
     * @return
     */

    public int refLongestValidParenthesesDF(String s) {
        int max = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] +
                            ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int refLongestValidParenthesesStack(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String str = "()(())";
        System.out.println(longestValidParentheses(str));
        System.out.println(longestValidParenthesesPractise(str));

    }
}
