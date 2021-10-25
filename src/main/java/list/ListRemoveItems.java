package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author zoujialei02
 * @date 2020/6/21
 */
public class ListRemoveItems {


    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(5L);
        list.add(3L);
        list.add(6L);
        List<Long> excludeIds = Arrays.asList(5L, 3L);
        removeItems(list, excludeIds);
        printList(list);
    }


    private static void removeItems(List<Long> list, List<Long> ids){
        if(list == null){
            return;
        }
        Iterator<Long> iterator = list.iterator();
        while (iterator.hasNext()){
            Long item = iterator.next();
            if(ids.contains(item)){
                iterator.remove();
            }
        }
    }

    private static void printList(List<Long> list){
        if(list != null){
            for(Long item: list){
                System.out.println(item);
            }
        }
    }
}
