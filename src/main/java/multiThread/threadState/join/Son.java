package multiThread.threadState.join;

/**
 * Created by jialei.zou on 2018/8/28 .
 */
public class Son extends Thread{

    @Override
    public void run(){
        System.out.println("son: start...");
        try {
            Thread.currentThread().sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("son: end...");
    }
}
