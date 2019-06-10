package interview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jialei.zou on 2019/6/8 .
 */
public class CASDemo {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        CASDemo casDemo = new CASDemo();
        //CAS实现见incrementAndGet方法的源代码
        casDemo.atomicInteger.incrementAndGet();
    }


}
