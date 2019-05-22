package interview.loadBalance;

import java.util.*;

/**
 * Created by jialei.zou on 2019/5/13 .
 */
public class RoundRoubinWeight {
    private static HashMap<String, Integer> ipMap = new HashMap<>();
    static {
        ipMap.put("192.168.0.1", 1);
        ipMap.put("192.168.0.2", 2);
        ipMap.put("192.168.0.3", 3);
    }

    private static int pos;

    public static String getService(){
        Set<String> ipSet = ipMap.keySet();
        List<String> ipList = new ArrayList<>();

        Iterator<String> iterator = ipSet.iterator();
        while (iterator.hasNext()){
            String serviceName = iterator.next();
            int weight = ipMap.get(serviceName);
            for (int i=0;i<weight;i++){
                ipList.add(serviceName);
            }
        }

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
        for (int i=0; i<10; i++){
            System.out.println(RoundRoubinWeight.getService());
        }
    }
}
