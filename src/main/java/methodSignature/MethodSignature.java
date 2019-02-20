package methodSignature;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoujialei on 2018/6/9.
 */
public class MethodSignature {

    public void getAge(List<String> name){

    }

    //same erasure error
//    public String getAge(List<Integer> name){
//
//    }
    public static void main(String[] args) {
        ArrayList<String> arrayList1=new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass()==arrayList2.getClass());
    }

}
