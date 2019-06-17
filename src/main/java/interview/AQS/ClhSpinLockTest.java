package interview.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jialei.zou on 2019/6/8 .
 */
public class ClhSpinLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = null;
        lock.lock();
        lock.unlock();
        CountDownLatch countDownLatch = null;
        try {
            countDownLatch.await();
            countDownLatch.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
