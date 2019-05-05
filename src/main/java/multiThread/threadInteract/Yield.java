package multiThread.threadInteract;

/**
 * Created by jialei.zou on 2018/8/24 .
 */
public class Yield {

    public static void main(String[] args) {
        new MyThread("high", 10).start();
        new MyThread("low", 1).start();
        new MyThread("middle", 5).start();

    }

}
