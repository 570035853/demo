package multiThread.multiThreadTask;

/**
 * Created by zoujialei on 17/11/2.
 */
public class MyThread extends Thread{
    private int ticket = 50;
    private int order;

    public MyThread(int order){
        this.order = order;
    }

    @Override
    public void run(){
            while (ticket>0){
                Thread thread = Thread.currentThread();
                ticket--;
                //各自单独有自己的ticket
                if(ticket % 5 == order){
                    System.out.println("thread:" + thread.hashCode() + "   order:"+ order + "       ticket:" + ticket);
                }
            }

    }


}
