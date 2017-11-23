package multiThreadTask.executeByGivenOrder.masterSlave;

import java.util.HashMap;

/**
 * Created by zoujialei on 17/11/5.
 */
abstract class ThreadEntity extends Thread{
    abstract boolean isReady();

    private volatile Boolean called = false;

    protected HashMap<String, String> condition;

    public Boolean getCalled() {
        return called;
    }

    public void setCalled(Boolean called) {
        this.called = called;
    }


    public HashMap<String, String> getCondition() {
        return condition;
    }

    public void setCondition(HashMap<String, String> condition) {
        this.condition = condition;
    }

}
