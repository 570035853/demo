package multiThread.normalTest;

/**
 * Created by jialei.zou on 2019/4/25 .
 */
public class CountProblem {

    /**
     * 即便是volatile类型，也解决不了输出是不到2倍数据的问题，因为只是解决了可见性，并没有锁住共享变量
     */
//    private volatile int count;
    private int count;


    private void countManyTimes(){
        for (int i = 0; i<1000000; i++){
            count++;
//            synchronized (this){count++;}  //这样是能解决问题的
        }
    }

    public static void main(String[] args) {
        CountProblem countProblem = new CountProblem();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                countProblem.countManyTimes();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                countProblem.countManyTimes();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(countProblem.count);

    }
}
