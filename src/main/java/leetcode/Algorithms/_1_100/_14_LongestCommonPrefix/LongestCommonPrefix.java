package leetcode.Algorithms._1_100._14_LongestCommonPrefix;

/**
 * Created by jialei.zou on 2018/12/21 .
 *
 */
public class LongestCommonPrefix {

    /**
     * 明天看答案解析
     * 1. 没考虑到[],紧接着又没有考虑到[""]情况
     * 2. break跳出外层循环的使用
     * 3. charAt的使用
     * 4. 如何让代码更简洁，见下面的ref方法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs == null || strs.length<1 || strs[0].equals("")){
            return result;
        }
        boolean flag = true;
        int pos = 0;
        here:
        while (flag){
            char add;
            if(pos<strs[0].length()){
                add = strs[0].charAt(pos);
            }else {
                break;
            }

            for (int i = 0; i<strs.length; i++){
                if(!(pos<strs[i].length()) || !(add == strs[i].charAt(pos))){
                    flag = false;
                    break here;
                }
            }
            pos++;
            result = result+add;
        }
        return result;
    }

    /**
     * 如下方式更简洁：
     * 注意：最后return的是str[0]
     * @param strs
     * @return
     */
    public static String refLongestCommonPrefix(String[] strs) {
        if(strs == null || strs.length<1){
            return "";
        }
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j=0; j<strs.length; j++){
                if(strs[j].length()==i || !(c==strs[j].charAt(i))){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"aa","a"}));

    }
}
