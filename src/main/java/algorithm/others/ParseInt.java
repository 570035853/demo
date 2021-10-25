package algorithm.others;

/**
 * Created by jialei.zou on 2019/6/23 .
 */
public class ParseInt {

    public int parseInt(String s){
        if(s==null || s.length()==0){
            throw new RuntimeException("invalid input");
        }
        char[] arrays = s.toCharArray();
        int result =0;
        boolean negetive = false;
        int cur = 0;
        if(arrays[0]=='+' || arrays[0] == '-'){
            if(arrays.length == 1){
                throw new RuntimeException("invalid input");
            }
            if(arrays[0] == '-'){
                negetive = true;
            }
            cur++;
        }
        while (cur<arrays.length){
            int itemValue = arrays[cur]-'0';
            if(!(itemValue>=0) && (itemValue<=9)){
                throw new RuntimeException("invalid input");
            }
            if(negetive){
                if(result<Integer.MIN_VALUE/10 ||(result==Integer.MIN_VALUE/10 && itemValue>8)){
                    throw new RuntimeException("invalid input");
                }
                result = 10*result-itemValue;
            }else {
                if(result>Integer.MAX_VALUE/10 ||(result==Integer.MAX_VALUE/10 && itemValue>7)){
                    throw new RuntimeException("invalid input");
                }
                result = 10*result+itemValue;
            }

            cur++;
        }
        return result;

    }

    public static void main(String[] args) {
        ParseInt parseInt = new ParseInt();
        System.out.println(parseInt.parseInt("456"));
        System.out.println(parseInt.parseInt("-456"));
        System.out.println(parseInt.parseInt("2147483647"));
        System.out.println(parseInt.parseInt("-2147483648"));


//        System.out.println(parseInt.parseInt("--56"));
//        System.out.println(parseInt.parseInt("999999999999999999999999"));



    }

}
