package multiThread.multiThreadTask.future;

import java.util.concurrent.Callable;

/**
 * @author zoujialei02
 * @date 2021/6/29
 */
public class CallableTask implements Callable<SpuResult> {

    private long spuId;

    @Override
    public SpuResult call() throws Exception{
        SpuResult spuResult = new SpuResult();
        spuResult.setSpuName("名字"+this.spuId);
        spuResult.setSaleCount(55);

        Thread.sleep(2000);
        return spuResult;
    }

    public CallableTask(long spuId){
        this.spuId = spuId;
    }
}
