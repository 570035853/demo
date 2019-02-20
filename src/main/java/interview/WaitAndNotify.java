package interview;

public class WaitAndNotify {

    public static void main(String[] args) {
        final Object object = new Object();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T1 start!");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1 end!");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T2 start!");
//                    object.notifyAll();
                    object.notify(); //随机通知一个
                    System.out.println("T2 end!");
                }
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T3 start!");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T3 end!");
                }
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                synchronized (object) {
                    System.out.println("T4 start!");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T4 end!");
                }
            }
        };

        t1.start();
        t3.start();
        t4.start();
        t2.start();

    }
}
