package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zoujialei on 17/12/5.
 * fail-fast和fail-safe相关知识点
 * 参考网址：
 * http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html
 * http://blog.csdn.net/chenssy/article/details/38151189（里面说的方案一有问题）
 *
 */
public class ArrayListTest {

    private static String toBeRemoved = "toBeRemoved";

    private static List<String> getNameList(){
        List<String> nameList = new ArrayList<String>();
        nameList.add("wanghaichao");
        nameList.add("suri");
        nameList.add(toBeRemoved);
        nameList.add("wangwenbang");
        nameList.add("changchao");
        return nameList;
    }

    private static void printNameWithoutIterator(List<String> nameList){
        for (int i = 0, len = nameList.size(); i < len; i++){
            if(toBeRemoved.equals(nameList.get(i))){
                nameList.remove(i);
                len--;
                i--;
                continue;
            }
            System.out.println("name: " + nameList.get(i));
        }
    }

    private static void printNameWithIterator(List<String> nameList){
        Iterator<String> ir = nameList.iterator();
        while (ir.hasNext()){
            String item = ir.next();
            if(toBeRemoved.equals(item)){
                ir.remove();
                //ir.remove(); //看源码可知，不能连续remove，目前认为是权衡了代码复杂度，做的位置设定，不允许连续remove
                continue;
            }
            System.out.println("name " + item);
        }
    }

    public static void main(String[] args) {
//        printNameWithoutIterator(getNameList());
//        System.out.println("***********************");
//        printNameWithIterator(getNameList());

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(null);
        list.add(null);
        System.out.println("list size:" + list.size() + "list:" + list.toString());

    }



}
