package multiThreadTask.executeByGivenOrder.masterSlave;

import java.util.HashMap;

/**
 * Created by zoujialei on 17/11/5.
 */
public class T1 extends ThreadEntity{

    public synchronized boolean isReady(){
        if (super.condition != null){
            String status = super.condition.get("T1");
            if(status != null && "ready".equals(status)){
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
        System.out.println("I am T1, start");
        condition.put("T1", "finished");
        System.out.println("I am T1, end");
    }
}
