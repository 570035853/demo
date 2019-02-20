package multiThread.multiThreadTask.ThreadPoolExecutor;

/**
 * Created by zoujialei on 2018/6/18.
 */
public class Task implements Runnable{

    private int index;

    public Task(int index){
        this.index = index;
    }

    @Override
    public void run(){
        System.out.println("current thread:" + index + " start");
        try {
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("current thread:" + index + " end");
    }
}
