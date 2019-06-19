package algorithm.leetcode.Algorithms._101_200._150_EvaluateReversePolishNotation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jialei.zou on 2019/2/16 .
 ref:
 https://leetcode.com/problems/evaluate-reverse-polish-notation/

 逆波兰式（Reverse Polish notation，RPN，或逆波兰记法），也叫后缀表达式（将运算符写在操作数之后）

 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Note:

 Division between two integers should truncate toward zero.
 The given RPN expression is always valid.
 That means the expression would always evaluate to a result and
 there won't be any divide by zero operation.
 Example 1:

 Input: ["2", "1", "+", "3", "*"]
 Output: 9
 Explanation: ((2 + 1) * 3) = 9

 Example 2:
 Input: ["4", "13", "5", "/", "+"]
 Output: 6

 Explanation: (4 + (13 / 5)) = 6
 Example 3:
 Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 Output: 22
 Explanation:
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22
 */
public class EvaluateReversePolishNotation {

    /**
     * 用栈的方式实现，思路比较清晰，没遇到一个特殊符号，出栈两个元素并运算，之后入栈
     *
     * 关注点：
     * 1. 关注ref如何定义set
     * 2. 关注ref古河定义calculate
     *
     * 记录：
     * 1. 主要calculate中a b的顺序，因为/不一样
     * 2. ref也比较类似，关注点1 2没有特别的实现方式
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Set<String> operatorSet = new HashSet<String>(){
            {
                add("+");
                add("-");
                add("*");
                add("/");
            }
        };

        Stack<String> stack = new Stack<>();
        for (int i= 0; i<tokens.length; i++){
            if(operatorSet.contains(tokens[i])){
                stack.push(calculate(stack.pop(), stack.pop(), tokens[i]));
            }else {
                stack.push(tokens[i]);
            }
        }

        return Integer.valueOf(stack.pop()).intValue();
    }

    private static String calculate(String b, String a, String operator){
        int value;
        switch (operator){
            case "+":
                value = Integer.valueOf(a).intValue()+Integer.valueOf(b).intValue();
                break;
            case "-":
                value = Integer.valueOf(a).intValue()-Integer.valueOf(b).intValue();
                break;
            case "*":
                value = Integer.valueOf(a).intValue()*Integer.valueOf(b).intValue();
                break;
            case "/":
                value = Integer.valueOf(a).intValue()/Integer.valueOf(b).intValue();
                break;
            default:
                throw new RuntimeException("invalid operator");
        }
        return value+"";
    }

    /**
     * ref也比较类似
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/discuss/47430/Java-Accepted-Code%3A-Stack-implementation.
     * 没有更好的思路
     * @param tokens
     * @return
     */
    public int refEvalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if(s.equals("+")) {
                S.add(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if(s.equals("*")) {
                S.add(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }

    public static void main(String[] args) {
        System.out.println(12/-132);
        System.out.println(122/-132);

        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
