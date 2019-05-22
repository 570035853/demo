package multiThread.daemonThread;

/**
 * Created by jialei.zou on 2019/5/18 .
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        }, "ThreadForbidJVMExit");
        //添加下面这样，JVM跑完"main thread is here"之后就退出了，但是不加下面这样，就一直不退出
//        thread.setDaemon(true);
        thread.start();

        System.out.println("main thread is here");
    }

}
