package common;

/**
 * Created by jialei.zou on 2019/5/2 .
 */
public class SleepUtils {

    public static void seconds(int seconds){

        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
