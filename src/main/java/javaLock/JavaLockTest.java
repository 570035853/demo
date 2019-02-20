package javaLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zoujialei on 2018/5/31.
 */
public class JavaLockTest {

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                reentrantLock.tryLock();
                reentrantLock.tryLock();
                try {
                    System.out.println("new thread begin do something ");
                    Thread.sleep(5000);
                    System.out.println("new thread wake up and finish its job ");
                }catch (Exception e){
                    System.out.println("try lock error");
                }finally {
                    reentrantLock.unlock();
                    reentrantLock.unlock();
                }
            }
        };

        new Thread(runnable).start();
        try {
            Thread.sleep(50);
        }catch (Exception e){

        }

        try {
            if(reentrantLock.tryLock(10, TimeUnit.SECONDS)){
                System.out.println("try lock got the lock, do something here");
            }else {
                System.out.println("failed to get the lock within given time");
            }

        }catch (Exception e){
            System.out.println("catch error");
        }finally {
            if(reentrantLock.isHeldByCurrentThread()){
                reentrantLock.unlock();
            }
        }

        System.out.println("end here");


        try {
            Thread.sleep(50000);
        }catch (Exception e){

        }


    }
}
