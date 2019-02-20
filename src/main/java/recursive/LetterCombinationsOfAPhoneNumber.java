package recursive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/12/14 .
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

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


    private static HashMap<String, List<String>> initDate(){
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


    /**
     * 错误行的错误原因，假设后面String都是一个固定值d，第一层如何需要分别循环a、b、c,则循环就成了 ad、bad、cbad
     * @param arrays
     * @param from
     * @param to
     * @param str
     * @param map
     * @return
     */
    private static String printAllString(char[] arrays, int from ,int to, String str, HashMap<String, List<String>>map){
        if(from > to){
            return "";
        }
        List<String> list = map.get(arrays[from]+"");
        for (int i =0; i<arrays.length; i++){
            System.out.println("in:"+str);
            //错误：
            str = str + list.get(i)+ printAllString(arrays, from+1, to, str, map);
            System.out.println("out:"+str);
            if(str.length()==arrays.length){
                System.out.println("result:"+str);
                str = "";
            }
        }
        return str;
    }



    private static void printAllString(String input){
        char[] arrays = input.toCharArray();
        fixPrintAllString(arrays, 0, arrays.length-1, "",initDate());
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

    public static void main(String[] args) {
        printAllString("23");
//        List<String> list = letterCombinations("23");
//        System.out.println("list:"+list.toString());
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
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
