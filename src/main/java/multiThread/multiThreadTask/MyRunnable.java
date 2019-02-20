package multiThread.multiThreadTask;

/**
 * Created by zoujialei on 17/11/2.
 */
public class MyRunnable implements Runnable{
    int ticket = 50;



    public void run(){
            while (ticket>0){
                ticket--;
                Thread thread = Thread.currentThread();
                System.out.println("thread:" + thread.hashCode() + "       ticket:" + ticket);
                try {
                    Thread.sleep(5);
                }catch (Exception e){
                    //do noting
                }

            }

    }
}
