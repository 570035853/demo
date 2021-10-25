package algorithm.leetcode.Algorithms._1_100._17_LetterCombinationsOfAPhoneNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 ref:
 https://leetcode.com/problems/letter-combinations-of-a-phone-number/

 Created by jialei.zou on 2018/12/14 .
 Given a string containing digits from 2-9 inclusive,
 return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Note that 1 does not map to any letters.

 2-abc
 3-def
 4-ghi
 5-jkl
 6-mno
 7-qprs
 8-tuv
 9-wxyz

 Example:

 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:

 Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsOfAPhoneNumber {


    private static HashMap<String, List<String>> initData(){
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        hashMap.put("2", Arrays.asList("a","b","c"));
        hashMap.put("3", Arrays.asList("d","e","f"));
        hashMap.put("4", Arrays.asList("g","h","i"));
        hashMap.put("5", Arrays.asList("j","k","l"));
        hashMap.put("6", Arrays.asList("m","n","o"));
        hashMap.put("7", Arrays.asList("q","p","r","s"));
        hashMap.put("8", Arrays.asList("t","u","v"));
        hashMap.put("9", Arrays.asList("w","x","y","z"));
        return hashMap;
    }



    private static void printAllString(String input){
        char[] arrays = input.toCharArray();
        fixPrintAllString(arrays, 0, arrays.length-1, "",initData());
    }

    private static void fixPrintAllString(char[] arrays, int from ,int to, String str, HashMap<String, List<String>>map){
        if(from > to){
            System.out.println(str);
            return;
        }
        List<String> list = map.get(arrays[from]+"");
        for (int i =0; i<list.size(); i++){
            fixPrintAllString(arrays, from+1, to, str+list.get(i), map);
        }
    }


    /**
     * 总结：
     * 1. 技巧点1，letters的定义
     * 2. cmd.equals("")字符串的比较不要在用==这种低级错误了
     */
    private String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits == null || digits.equals("")){
            return result;
        }
        helper(digits, new LinkedList<>(), result);
        return result;
    }

    private void helper(String cmd, List<String> innerList, List<String> result){
        if(cmd.equals("")){
            String item = "";
            for (String i: innerList){
                item = item+i;
            }
            result.add(item);
            return;
        }
        char[] arrays = letters[cmd.charAt(0)-'0'].toCharArray();
        for (char c: arrays){
            innerList.add(c+"");
            helper(cmd.substring(1), innerList, result);
            innerList.remove(innerList.size()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber number = new LetterCombinationsOfAPhoneNumber();
        List<String> result = number.letterCombinations("23");
        for (String item: result){
            System.out.printf(item+",");
        }
    }

    /**
     * 如下是其他人写的,
     */

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> refLetterCombinations(String digits) {
        List<String> ret = new LinkedList<>();
        combination("", digits, 0, ret);
        return ret;
    }

    private static void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}
