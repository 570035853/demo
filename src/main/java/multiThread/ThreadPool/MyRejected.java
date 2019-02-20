package multiThread.ThreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jialei.zou on 2018/9/10 .
 */
public class MyRejected {
    public MyRejected(){
    }

    public class Handle implements RejectedExecutionHandler{
        public Handle(){}

        private final static int ONE = 1;

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("自定义处理..");
            System.out.println("当前被拒绝任务为：" + r.toString());
        }
    }
}

