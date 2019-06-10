package interview.AQS;

import common.SleepUtils;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jialei.zou on 2019/6/8 .
 ref:
 http://zhanjindong.com/2015/03/11/java-concurrent-package-aqs-clh-and-spin-lock
 */
class ClhSpinLock {
    private final ThreadLocal<Node> prev;
    private final ThreadLocal<Node> node;
    private final AtomicReference<Node> tail = new AtomicReference<Node>(new Node());

    public ClhSpinLock() {
        this.node = new ThreadLocal<Node>() {
            //具体的方法initialValue，需要等get的时候才会调动到
            @Override
            protected Node initialValue() {
//                System.out.println("current thread id："+Thread.currentThread().getId()+" current node:"+node);
                return new Node();
            }
        };

        this.prev = new ThreadLocal<Node>() {
            @Override
            protected Node initialValue() {
                return null;
            }
        };
    }

    public void lock() {
        final Node node = this.node.get();
//        System.out.println("current thread id："+Thread.currentThread().getId()+" node:"+node);
        node.locked = true;
        // 一个CAS操作即可将当前线程对应的节点加入到队列中，
        // 并且同时获得了前继节点的引用，然后就是等待前继释放锁
        Node pred = this.tail.getAndSet(node);
        this.prev.set(pred);
        while (pred.locked) {// 进入自旋
        }
    }

    public void unlock() {
        final Node node = this.node.get();
        node.locked = false;
//        this.node.set(this.prev.get());
    }

    private static class Node {
        private volatile boolean locked;
    }


    public static void main(String[] args) {
        final ClhSpinLock lock = new ClhSpinLock();
        lock.lock();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getId() + " acquired the lock!");
                    lock.unlock();
                }
            }).start();
            SleepUtils.seconds(1);
        }

        System.out.println("main thread unlock!");
        lock.unlock();


        ReentrantLock lock1;
    }
}