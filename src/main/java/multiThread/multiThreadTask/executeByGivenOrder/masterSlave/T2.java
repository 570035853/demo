package multiThread.multiThreadTask.executeByGivenOrder.masterSlave;

/**
 * Created by zoujialei on 17/11/5.
 */
public class T2 extends ThreadEntity{

    public synchronized boolean isReady(){
        if (super.condition != null){
            String status = super.condition.get("T1");
            if(status != null && "finished".equals(status)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void run(){
        System.out.println("I am T2, start");
        condition.put("T2", "finished");
        System.out.println("I am T2, end");
    }
}
