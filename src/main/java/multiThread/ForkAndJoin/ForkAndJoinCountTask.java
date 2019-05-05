package multiThread.ForkAndJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by jialei.zou on 2019/5/4 .
 * ref: 《并发编程的艺术》P177
 */
public class ForkAndJoinCountTask extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 2;

    private int start;
    private int end;

    public ForkAndJoinCountTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer compute(){
        int sum = 0;
        boolean canCompute = (end - start)<= THRESHOLD;
        if(canCompute){
            for (int i = start; i<=end; i++){
                sum +=i;
            }
        }else {
            //任务大于阈值，进行拆分
            int mid = (start+end)/2;
            ForkAndJoinCountTask left = new ForkAndJoinCountTask(start, mid);
            ForkAndJoinCountTask right = new ForkAndJoinCountTask(mid+1, end);

            //执行子任务
            left.fork();
            right.fork();

            //等待子任务执行完毕，并得到其结果
            Integer leftValue = left.join();
            Integer rightValue = right.join();

            //合并
            sum = leftValue + rightValue;

        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkAndJoinCountTask task = new ForkAndJoinCountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
