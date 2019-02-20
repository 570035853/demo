package multiThread.threadState;

/**
 * Created by jialei.zou on 2018/8/24 .
 */
public class MyThread extends Thread {
    MyThread(String name, int priority){
        super(name);
        this.setPriority(priority);
    }

    @Override
    public void run(){
        for (int i = 0; i<15; i++){
            System.out.println(this.getName()+": "+ i);
            if(i>=5){
                yield();
            }
//            try {
//                Thread.currentThread().sleep(10);
//            }catch (Exception e){
//
//            }

        }
    }
}
