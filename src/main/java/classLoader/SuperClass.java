package classLoader;

/**
 * Created by zoujialei on 2018/5/19.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public String getName(){
        return "";
    }

    public static int value = 123;
}
