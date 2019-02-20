package interview.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable{

    public Consumer(BlockingDeque<Data> queue){
        this.queue = queue;
    }

    BlockingDeque<Data> queue;

    private Random random = new Random();

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(random.nextInt(1000));
                Data data = queue.take();
                if(data != null){
                    System.out.println("get data:" + data.getId());
                }else {
                    System.out.println("get data null");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
