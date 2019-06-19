package algorithm.leetcode.Algorithms._201_300._242_ValidAnagram;

/**
 * Created by jialei.zou on 2019/6/18 .
 ref:
 https://leetcode.com/problems/valid-anagram/

 Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:
 Input: s = "anagram", t = "nagaram"
 Output: true

 Example 2:
 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return s==t;
        }
        if(s.length()==0 || t.length() ==0){
            return s.equals("") && t.equals("") ;
        }
        if(s.length()!=t.length()){
            return false;
        }
        int[] items = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i<sChars.length ; i++){
            items[sChars[i]-'a']++;
        }
        for (int i = 0; i<tChars.length; i++){
            items[tChars[i]-'a']--;
        }
        for (int i=0; i<26; i++){
            if(items[i]!=0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram",  "nagaram"));
        System.out.println(validAnagram.isAnagram("rat",  "car"));
    }
}
