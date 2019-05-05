package javaLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jialei.zou on 2019/4/26 .
 ref:
 https://liuhao163.github.io/JAVA%E4%B8%AD%E7%9A%84%E7%AE%A1%E7%A8%8B/

 */
public class BlockQueue {
    ReentrantLock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    private Queue queue = new LinkedList();
    private int queSize = 10;

    public BlockQueue(int queSize) {
        this.queSize = queSize;
    }

    public void enq(Object o) {
        lock.lock();
        try {
            //如果为慢noFull阻塞线程
            if (queue.size() == queSize) {
                notFull.await();
            }
            queue.add(o);
            //添加成功通知deq停止阻塞
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object deque() {
        lock.lock();
        try {
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            //如果为空notEmpty阻塞线程
            if (queue.size() == 0) {
                notEmpty.await();
            }
            return queue.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            //出队列成功通知队列未满可以入队列
            notFull.signal();
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        BlockQueue blockQueue = new BlockQueue(3);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                blockQueue.deque();
                System.out.println("thread1 run end");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 run start");
                blockQueue.enq(new Integer(1));
                blockQueue.enq(new Integer(2));
                blockQueue.enq(new Integer(3));
                blockQueue.enq(new Integer(4));
                blockQueue.enq(new Integer(5));
                blockQueue.enq(new Integer(6));
                blockQueue.enq(new Integer(7));
                blockQueue.enq(new Integer(8));
                blockQueue.enq(new Integer(9));
                blockQueue.enq(new Integer(10));
                blockQueue.enq(new Integer(11));
                blockQueue.enq(new Integer(12));
                System.out.println("thread2 run end");
            }
        });

        thread2.start();
        Thread.sleep(10);
        thread1.start();
        Thread.sleep(10);
        thread1.interrupt();
        thread1.join();
        thread2.join();

    }
}
