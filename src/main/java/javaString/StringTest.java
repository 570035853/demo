package javaString;

/**
 * Created by jialei.zou on 2018/11/20 .
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "cat";
        String c = new String("ca")+new String("t");
        System.out.println("c==a?:"+(c==a));  //false
        c.intern();
        System.out.println("c==a?:"+(c==a));  //false
        c = c.intern();
        System.out.println("c==a?:"+(c==a));  //true
    }


}
