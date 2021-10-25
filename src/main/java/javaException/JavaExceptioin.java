package javaException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoujialei02
 * @date 2021/3/18
 */
public class JavaExceptioin {

    public static void main(String[] args) {
        try {
            dealData();
        }catch (Exception e){
            System.out.println("main catch error");
        }

    }

    public static void dealData(){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(0);
        list.add(5);

        boolean catchException = false;
        for (Integer item : list){
            try {
                System.out.println("now print:"+item);
                System.out.println(5/item);
            }catch (Exception e){
                e.printStackTrace();
                catchException = true;
            }
        }

        if(catchException){
            throw new RuntimeException();
        }
    }
}
