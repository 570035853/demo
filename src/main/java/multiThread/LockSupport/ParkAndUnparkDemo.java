package multiThread.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by jialei.zou on 2019/6/8 .
 */
public class ParkAndUnparkDemo {

    public static void main(String[] args) {
        System.out.println("start");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("unpark first");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("unpark second");

        LockSupport.park(Thread.currentThread());
        System.out.println("park first");

        //后续两个会一直进行park
        LockSupport.park(Thread.currentThread());
        System.out.println("park second");
        LockSupport.park(Thread.currentThread());
        System.out.println("park third");


    }
}
