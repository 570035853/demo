package interview.loadBalance;

import java.util.*;

/**
 * Created by jialei.zou on 2019/5/13 .
 * https://blog.csdn.net/zhou2s_101216/article/details/78358354
 */
public class RoundRoubin {

    private static HashMap<String, Integer> ipMap = new HashMap<>();
    static {
        ipMap.put("192.168.0.1", 1);
        ipMap.put("192.168.0.2", 1);
        ipMap.put("192.168.0.3", 1);
    }

    private static int pos;

    public static String getService(){
        /**
         * 参考的里面对原map进行了一次复制，没有根本改变问题，没有进行复制
         */
        Set<String> ipSet = ipMap.keySet();
        List<String> ipList = new ArrayList<>();
        ipList.addAll(ipSet);

        String serverName;
        synchronized (RoundRoubin.class){
            if(pos>=ipList.size()){
                pos = 0;
            }
            serverName = ipList.get(pos);
            pos++;
        }


        return serverName;
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            System.out.println(RoundRoubin.getService());
        }
    }
}
