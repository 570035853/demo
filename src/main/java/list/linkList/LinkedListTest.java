package list.linkList;

import java.util.LinkedList;

/**
 * @author zoujialei02
 * @date 2020/4/11
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(2, 22);
        list.add(2, 23);

        for (Integer item: list){
            System.out.println(item);
        }


    }
}
