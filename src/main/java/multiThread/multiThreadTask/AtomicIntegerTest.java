package multiThread.multiThreadTask;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private AtomicInteger count = new AtomicInteger();

    public void increment(){
        count.incrementAndGet();
    }


    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        count.getAndAdd(4);
        System.out.println(count);
    }
}
