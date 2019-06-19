package algorithm.leetcode.Algorithms.StringToInteger;

/**
 * Created by jialei.zou on 2018/11/22 .
 */
public class StringToInteger {

    /**
     * 需要有str-array、判断是否是数字或正负号
     * 1. char和数字之间的值对应关系
     * 2. 向后查询的判断
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        str = str.trim();
        if(str.length()==0){
            return 0;
        }
        char[] arry = str.toCharArray();
        if(!isValidStart(arry[0])){
            return 0;
        }
        boolean negative = false;
        if(arry[0] == '-' || arry[0] == '+'){
            str = str.substring(1);
            if(arry[0]=='-'){
                negative = true;
            }
        }
        int result = 0;
        if(str.length()>0){
            char[] arryIn = str.toCharArray();
            for (int i=0;i<arryIn.length; i++){
                if(arryIn[i]>='0'&&arryIn[i]<='9'){
                    if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10&&arryIn[i]>=8)){
                        if(negative){
                            return Integer.MIN_VALUE;
                        }else {
                            return Integer.MAX_VALUE;
                        }
                    }
                    result = result*10+arryIn[i];
                }
                else {
                    if(negative){
                        return 0-result;
                    }
                    return result;
                }
            }
        }
        return result;
    }

    public static int myModifyAtoi(String str) {
        str = str.trim();
        if(str.length()==0){
            return 0;
        }
        char[] arry = str.toCharArray();
        if(!isValidStart(arry[0])){
            return 0;
        }
        boolean negative = false;
        if(arry[0] == '-' || arry[0] == '+'){
            str = str.substring(1);
            if(arry[0]=='-'){
                negative = true;
            }
        }
        int result = 0;
        if(str.length()>0){
            char[] arryIn = str.toCharArray();
            for (int i=0;i<arryIn.length; i++){
                int value = arryIn[i] - '0';   //调整的地方
                if(value>=0&&value<=9){
                    if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10&&value>=8)){
                        if(negative){
                            return Integer.MIN_VALUE;
                        }else {
                            return Integer.MAX_VALUE;
                        }
                    }
                    result = result*10+value;
                }
                else {
                    if(negative){
                        return 0-result;
                    }
                    return result;
                }
            }
        }
        if(negative){
            return 0-result;
        }
        return result;
    }


    private static boolean isValidStart(char c){
        if(c == '-' || c=='+' || c>='0'&&c<='9'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("result:"+myModifyAtoi(   "-42"));
        System.out.println("result:"+myModifyAtoi(   "42"));
        System.out.println("result:"+myModifyAtoi(   "  -42"));
        System.out.println("result:"+myModifyAtoi(   "4193 with words"));
        System.out.println("result:"+myModifyAtoi(   "words and 987"));
        System.out.println("result:"+myModifyAtoi(   "-91283472332"));
        System.out.println("result:"+myModifyAtoi(   "91283472332"));
        System.out.println("result:"+myModifyAtoi(   "2147483646"));

    }
}
