package javaMap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jialei.zou on 2019/6/24 .
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        concurrentHashMap.put("key", "hello");

        HashMap hashMap = new HashMap();
    }
}
