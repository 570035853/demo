package javaMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jialei.zou on 2018/8/10 .
 */
public class TreeMapAndHashMap {

    public static void main(String[] args) {
        //HashMap 遍历是不按顺序排列
        Map map=new HashMap();
        map.put("1", "m22");
        map.put("4", "m44");
        map.put(11, "m11");
        map.put(3, "m33");
        Iterator iter=map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry) iter.next();
            String key=entry.getKey().toString();
            String value=entry.getValue().toString();
            System.out.println(key+"*"+value);
        }

        //TreeMap 遍历是按顺序排列

        Map treemap=new TreeMap();
        treemap.put(3, "t22");
        treemap.put(4, "t33");
        treemap.put(5, "t55");
        treemap.put(1, "t11");
        treemap.put(2, "t44");
        Iterator titer=treemap.entrySet().iterator();
        while(titer.hasNext()){
            Map.Entry ent=(Map.Entry )titer.next();
            String keyt=ent.getKey().toString();
            String valuet=ent.getValue().toString();
            System.out.println(keyt+"*"+valuet);
        }
    }



}
