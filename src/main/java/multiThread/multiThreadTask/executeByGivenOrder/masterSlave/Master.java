package multiThread.multiThreadTask.executeByGivenOrder.masterSlave;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zoujialei on 17/11/5.
 */
public class Master extends Thread {

    public List<ThreadEntity> getList() {
        return list;
    }

    public void setList(List<ThreadEntity> list) {
        this.list = list;
    }

    private List<ThreadEntity> list;

    public HashMap<String, String> condition;



    @Override
    public void run(){
        System.out.println("master start");
        while (true){
            for (ThreadEntity entity: list){
                if(entity.isReady() && !entity.getCalled()){
                    entity.start();
                    entity.setCalled(true);
                }
            }
            Thread thread = Thread.currentThread();
            try {
                thread.sleep(200);
            }catch (Exception e){
                //do nothing
            }
        }
    }

    public HashMap<String, String> getCondition() {
        return condition;
    }

    public void setCondition(HashMap<String, String> condition) {
        condition = condition;
    }
}
