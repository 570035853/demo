package multiThread.threadInteract.join;

/**
 * Created by jialei.zou on 2018/8/28 .
 */
public class Father extends Thread{

    @Override
    public void run(){
        System.out.println("Father: start");
        Son son = new Son();
        son.start();
        try {
            son.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Father: stop");


    }

    public static void main(String[] args) {
        Boolean replaceUserCardToUserCenter = null;
        System.out.println("replaceUserCardToUserCenter result:" + (replaceUserCardToUserCenter==null?"null":replaceUserCardToUserCenter) + "   orderId:");
    }

}
