package multiThreadTask.executeByGivenOrder.masterSlave;

import java.util.HashMap;

/**
 * Created by zoujialei on 17/11/5.
 */
public class T4 extends ThreadEntity{

    public synchronized boolean isReady(){
        if (super.condition != null) {
            String statusT2 = super.condition.get("T2");
            String statusT3 = super.condition.get("T3");
            if ((statusT2 != null && "finished".equals(statusT2)) && (statusT3 != null && "finished".equals(statusT3))) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void run(){
        System.out.println("I am T4, start");
        condition.put("T4", "finished");
        System.out.println("I am T4, end");
    }
}
