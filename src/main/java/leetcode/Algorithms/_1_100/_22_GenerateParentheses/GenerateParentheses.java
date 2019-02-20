package leetcode.Algorithms._1_100._22_GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/12/15 .
 * ref:https://leetcode.com/problems/generate-parentheses/solution/
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses{

    private static List<String> getAll(int n){
        List<String> linkedList = new LinkedList<>();
        ref1GenerateParentheses(linkedList, "",0, 0, n);
        return linkedList;
    }

    /**
     * ref: https://blog.csdn.net/gatieme/article/details/51095236
     * @param result
     * @param item
     * @param left
     * @param right
     * @param n
     */
    private static void ref1GenerateParentheses(List<String> result, String item, int left, int right, int n){
        if ((left == n)&&(right == n)){
            result.add(item);
            return;
        }
        if(left<n){
            ref1GenerateParentheses(result, item+"(", left+1, right, n);
        }
        if(right<n &&right<left){
            ref1GenerateParentheses(result, item+")", left, right+1, n);
        }
    }






    public static void main(String[] args) {
        List<String> result = getAll(3);
        print(result);
    }

    private static void print(List<String> linkedList){
        for (String item: linkedList){
            System.out.println(item);
        }
    }


}
