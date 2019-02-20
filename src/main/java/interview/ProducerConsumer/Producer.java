package interview.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

    private BlockingQueue<Data> queue;

    private AtomicInteger count = new AtomicInteger();

    private Random random = new Random();

    public Producer(BlockingQueue<Data> queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(random.nextInt(1000));
                int id = count.incrementAndGet();
                Data data = new Data(id, "id:"+id);
                System.out.println("try to add data, id:" + id + "current thread:"+Thread.currentThread().getName());
                if(!queue.offer(data, 2, TimeUnit.SECONDS)){
                    System.out.println("add data failed(2 seconds), id:"+ id);
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
