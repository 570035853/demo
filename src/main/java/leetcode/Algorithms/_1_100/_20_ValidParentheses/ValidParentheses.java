package leetcode.Algorithms._1_100._20_ValidParentheses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jialei.zou on 2019/2/15 .
 ref:
 https://leetcode.com/problems/valid-parentheses/

 Given a string containing just the characters '(', ')', '{', '}',
 '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true

 */
public class ValidParentheses {

//    static {
//        isValid("a");
//        isValid("b");
//    }
//    boolean result =isValid("c");

    /**
     * 如下相关的知识点，可见《内部类的使用示例》
     *
     */
    private static Set<Character> leftSet = new HashSet<Character>(){
        {
            add('(');
            add('[');
            add('{');
        }
    };


    private static Set<Character> rightSet = new HashSet<Character>(){
        {
            add(')');
            add(']');
            add('}');
        }
    };

    /**
     * 补充知识点：
     * 1. set的声明及添加元素
     * 2. char的范围包括[({}
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if(s == null || "".equals(s)){
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<chars.length; i++){
            if(leftSet.contains(chars[i])){
                stack.push(chars[i]);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else {
                    Character top = stack.pop();
                    if(!isMatch(top,chars[i])){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatch(char left, char right){
        if(left == '('){
            return right == ')';
        }else if(left == '{'){
            return right == '}';
        }else if(left == '['){
            return right == ']';
        }else {
            return false;
        }
    }


    /*************************以下是ref***********************/
    /**
     * 总结：
     * 1. 使用栈的方式实现
     * 2. map.containsKey()判断key是否存在的方法
     * 3. char包含)这些特殊字符
     * 4. map可以put(char)，自动装箱，之后可以用get(Character)
     */

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean refIsValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("():"+isValid("()"));
        System.out.println("()[]{}:"+isValid("()[]{}"));
        System.out.println("(]:"+isValid("(]"));
        System.out.println("([)]:"+isValid("([)]"));
        System.out.println("{[]}:"+isValid("{[]}"));
    }


}
