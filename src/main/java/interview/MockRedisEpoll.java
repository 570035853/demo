package interview;

import java.util.ArrayList;
import java.util.List;

public class MockRedisEpoll {


    public static String redis(String setGet){
        while (true){
            register();

            List<String> readyList = getReadyList();
            for (String ready: readyList){
                response();
            }
        }
    }

    /**
     * register
     */
    private static void register(){
        System.out.println("register");
    }

    private static List<String> getReadyList(){
        return new ArrayList<>();
    }

    private static void response(){
        System.out.println("response");
    }
}
