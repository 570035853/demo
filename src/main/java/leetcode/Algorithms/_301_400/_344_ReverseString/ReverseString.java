package leetcode.Algorithms._301_400._344_ReverseString;

/**
 * Created by jialei.zou on 2019/2/27 .
 ref:

 https://leetcode.com/problems/reverse-string/

 Write a function that reverses a string. The input string is given as an array of characters char[].

 Do not allocate extra space for another array, you must do this by modifying
 the input array in-place with O(1) extra memory.

 You may assume all the characters consist of printable ascii characters.



 Example 1:

 Input: ["h","e","l","l","o"]
 Output: ["o","l","l","e","h"]
 Example 2:

 Input: ["H","a","n","n","a","h"]
 Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if(s == null || s.length<1){
            return;
        }
        char tem;
        for (int i=0; i<s.length/2; i++){
            tem = s[s.length -1 -i];
            s[s.length - 1-i] = s[i];
            s[i] = tem;
        }
    }

    public static void main(String[] args) {

    }
}
