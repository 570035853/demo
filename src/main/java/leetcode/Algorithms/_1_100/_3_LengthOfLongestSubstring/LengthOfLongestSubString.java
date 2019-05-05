package leetcode.Algorithms._1_100._3_LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jialei.zou on 2018/12/10 .
 * ref：
 https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 */
public class LengthOfLongestSubString {

    public int myLengthOfLongestSubstring(String s) {
        return 0;
    }


    /**
     * 全部遍历的想法
     * 1. 字符串的长度s.length()
     * 2. Math.max(int i,int j)的使用
     * 3. substring(int start, int end)理解错误，实际最后一个exclusive，下表是从0开始的，所以j是小于等于
     * @param s
     * @return
     */
    public int ref1BruteForth(String s){
        int length = s.length();
        int max = 0, i = 0, j = 0;
        for (;i<length;i++){
            for (j=i+1;j<=length;j++){
                String subStr = s.substring(j,j);
                if(withoutRepeatableChar(subStr)){
                    max = Math.max(max, subStr.length());
                }
            }
        }
        return max;
    }

    /**
     * 1. 滑动窗口想法
     * 2. while条件的实现
     * @param s
     * @return
     */
    public int ref2LengthOfLongestSubstring(String s){
        int max = 0, i = 0, j = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        char[] arrays = s.toCharArray();
        while (i<length && j<length){
            if(!set.contains(arrays[j])){
                set.add(arrays[j]);
                max = Math.max(max, j-i+1);
                j++;
            }else {
                set.remove(arrays[i]);
                i++;
            }
        }
        return max;
    }

    /**
     * 标准答案里面set.add(s.charAt(j++)); 实际是先进行了s.charAt(j)后续进行的j+1
     * 类似System.out.println(j++);也是先进行print j，之后是j+1
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringOptimize(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 1. set里面的E，char对应的是Character
     * 2. set的contains和add
     * @param str
     * @return
     */
    private boolean withoutRepeatableChar(String str){
        Set<Character> set = new HashSet<>();
        char[] arrays = str.toCharArray();
        for (char itme : arrays){
            if(set.contains(itme)){
                return false;
            }
            set.add(itme);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("abcd".length());
        System.out.println("abcd".substring(1,4));

//        System.out.println(lengthOfLongestSubstring("abc"));
        int j= 0;
        System.out.println("abc".charAt(1));
        System.out.println("abc".charAt(j++));
        System.out.println(j++);

    }
}
