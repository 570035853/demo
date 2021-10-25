package algorithm.leetcode.Algorithms._1_100._22_GenerateParentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/12/15 .
 * ref:
 https://leetcode.com/problems/generate-parentheses/solution/
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
        // 或者条件判断也可以 if(right<left){
            ref1GenerateParentheses(result, item+")", left, right+1, n);
        }
    }



    public List<String> ref2GenerateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)){
                result.add(new String(current));
            }
        } else {
            //current里面的内容被原地置换了很多次
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
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
