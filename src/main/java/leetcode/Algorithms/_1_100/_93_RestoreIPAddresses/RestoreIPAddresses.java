package leetcode.Algorithms._1_100._93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/1/9 .

 ref: https://leetcode.com/problems/restore-ip-addresses/
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 Example:

 Input: "25525511135"
 Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {

    /**
     * 自己写的，后面看下其他人的答案
     * 1. 没有判断s.length()>12，导致输入过长字符串，时间超时（注释在了相应代码处）
     * 2. 没有判断出1.010.011.22这种不是（注释在了相应代码处）
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        permutation(result, "",s, 1);
        return result;
    }

    private static void permutation(List<String> result, String temp,  String s, int pos){
        //1. 没有判断s.length()>12，导致输入过长字符串，时间超时
        if(s == null || "".equals(s) || s.length()>12){
            return;
        }
        if(pos == 4){
            if(isValid(s)){
                temp = temp+s;
                result.add(temp);
                return;
            }
        }
        if(s.length()>=1&&isValid(s.substring(0, 1))){
            permutation(result,  temp+s.substring(0, 1)+".",s.substring(1),pos+1);
        }
        if(s.length()>=2&&isValid(s.substring(0, 2))){
            permutation(result,  temp+s.substring(0, 2)+".",s.substring(2),pos+1);
        }
        if(s.length()>=3&&isValid(s.substring(0, 3))){
            permutation(result,  temp+s.substring(0, 3)+".", s.substring(3),pos+1);
        }

    }

    private static boolean isValid(String s){
        if(s.length()>3){
            return false;
        }
        //2. 没有判断出1.010.011.22这种不是
        if(s.startsWith("0")){
            return s.equals("0");
        }
        return Integer.valueOf(s).intValue()<=255;
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(1));
        System.out.println("abc".substring(0,1));

//        List<String> result = restoreIpAddresses("25525511135");
        List<String> result = restoreIpAddresses("1");

        for (String item: result){
            System.out.println(item);
        }
    }


    /**
     * ref的感觉是，就是为了此题目，也比较直接
     * @param s
     * @return
     */
    public List<String> refRestoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(refIsValid(s1) && refIsValid(s2) && refIsValid(s3) && refIsValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean refIsValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}
