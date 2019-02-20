package leetcode.Algorithms._101_200._139_WordBreak;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by jialei.zou on 2019/1/23 .
 ref:
 https://leetcode.com/problems/word-break/

 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false

可以归类为DP问题

 */
public class WordBreak {


    /**
     * 按照自己理解的题目意思写出来的没问题，
     *
     * 实际想要的是，从任何一个位置都可以开始， 之前的思路是，wordDict逐个消去s中的元素
     * 但是没想好如何解决如下情况
     * abbbc
     * ["b","bc"]
     *
     *
     如下，题目期望返回的是true
     "bb"
     ["a","b","bbb","bbbb"]
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size()<1){
            return false;
        }
        int size= 0;
        for (; size<wordDict.size();size++){
            String cur = wordDict.get(size);
            int curLength = cur.length();
            boolean exist = false;
            while (s!= null && s.length()>0){
                if(s.length()<curLength){
                    return false;
                }
                if(!exist ){
                    if(!s.startsWith(cur)){
                        return false;
                    }else {
                        exist = true;
                        s=s.substring(curLength);
                    }
                }else {
                    if(!s.startsWith(cur)){
                        break;
                    }else {
                        s=s.substring(curLength);
                    }
                }
            }
        }
        if(size == wordDict.size()){
            return true;
        }else {
            return false;
        }
    }

    /**
     https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
     * @param s
     * @param dict
     * @return
     */
    public boolean ref1WordBreak(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }


    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code" )));
        System.out.println(wordBreak("applepenapple",  Arrays.asList("apple","pen" )));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat" )));

    }
}
