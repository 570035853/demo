package javaInnerClass.InnerStaticClass;

/**
 * Created by jialei.zou on 2018/11/13 .
 */
public class House {

    int height;
    String location;

    public static class Bed{
        static int length;
        static int getLength(){
            return length;
        }
    }
}
