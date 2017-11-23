package multiThreadTask.executeByGivenOrder.masterSlave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zoujialei on 17/11/6.
 * 多线程并发控制
 * 参考网址：https://www.ibm.com/developerworks/cn/java/j-lo-concurrent-frmk/
 */
public class Test {

    public static void main(String[] args) {
        //创建任务线程
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        T4 t4 = new T4();
        List<ThreadEntity> list = new ArrayList<ThreadEntity>();
        list.add(t3);
        list.add(t4);
        list.add(t1);
        list.add(t2);

        Master masterControl = new Master();
        masterControl.setList(list);

        //运行条件初始化
        HashMap<String, String> condition = new HashMap();
        condition.put("T1", "ready");
        condition.put("T2", "wait");
        condition.put("T3", "wait");
        condition.put("T4", "wait");
        masterControl.setCondition(condition);
        t1.setCondition(condition);
        t2.setCondition(condition);
        t3.setCondition(condition);
        t4.setCondition(condition);

        //开跑
        masterControl.start();
    }

}
