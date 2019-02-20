package javaStatic.staticNewDemo;

/**
 * Created by jialei.zou on 2018/7/30 .
 */
public class StaticNewDemo {


    public static void main(String[] args) {

        System.out.println(StaticNew.threadLocal.hashCode());

        System.out.println(StaticNew.threadLocal.hashCode());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(StaticNew.threadLocal.hashCode());
            }
        };
        new Thread(runnable).start();
    }
}
