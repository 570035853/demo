package leetcode.Algorithms._101_200._131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/1/23 .
 ref: https://leetcode.com/problems/palindrome-partitioning/
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]

 总体思路非常好
 https://leetcode.com/problems/palindrome-partitioning/discuss/182307/Java%3A-Backtracking-Template-General-Approach
 All backtracking problems are composed by these three steps: choose, explore, unchoose.
 So for each problem, you need to know:

 choose what? For this problem, we choose each substring.
 how to explore? For this problem, we do the same thing to the remained string.
 unchoose Do the opposite operation of choose.
 Let's take this problem as an example:
 1.Define helper(): Usually we need a helper funcition in backtracking problem, to accept more parameters.
 2.Parameters: Usually we need the following parameters
    1） The object you are working on:  For this problem is String s.
    2) A start index or an end index which indicate which part you are working on:
        For this problem, we use substring to indicate the start index.
    3) A step result, to remember current choose and then do unchoose :
        For this problem, we use List<String> step.
    4) A final result, to remember the final result.
    Usually when we add, we use 'result.add(new ArrayList<>(step))' instead of 'result.add(step)',
    since step is reference passed. We will modify step later, so we need to copy it and add the copy to the result;

 3.Base case: The base case defines when to add step into result, and when to return.
 4.Use for-loop: Usually we need a for loop to iterate though the input String s, so that we can choose all the options.
 5.Choose: In this problem, if the substring of s is palindrome, we add it into the step, which means we choose this substring.
 6.Explore: In this problem, we want to do the same thing to the remaining substring. So we recursively call our function.
 7.Un-Choose: We draw back, remove the chosen substring, in order to try other options.

 The above is mainly the template, the code is shown below:
 1. 可以归类为字符串的处理
 2. 可以归类的递归调用
 */
public class PalindromePartitioning {

    /**
     * todo 手写练手
     * 关于切分，没什么思路
     * 还是要看下之前字符串的相关操作，包括递归的相关操作
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        return null;
    }

    /**
     * 亮点：
     * 1. 本题目的解题思路
     * 2. 判断是否为回文的写法
     * @param s
     * @return
     */
    public List<List<String>> refPartition(String s) {
        // Backtracking
        // Edge case
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }
    public void helper(String s, List<String> step, List<List<String>> result) {
        // Base case
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) {
                continue;// only do backtracking when current string is palindrome
            }

            step.add(temp);  // choose
            helper(s.substring(i, s.length()), step, result); // explore
            step.remove(step.size() - 1); // unchoose
        }
        return;
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    /**
     * todo 待看
     * https://leetcode.com/problems/palindrome-partitioning/discuss/41974/My-Java-DP-only-solution-without-recursion.-O(n2)
     * @param s
     * @return
     */
    public static List<List<String>> ref2Partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }
}
