package normalTest;



import java.util.LinkedList;
import java.util.List;


/**
 * Created by zoujialei on 2018/1/16.
 */
public class TempTest {


    private static final Long ONE = 1L;

    public static void main(String[] args) {

//        testException();
//        System.out.println(System.getProperty("user.home"));
        testSwitch();


    }


    private static void testException(){
        throw new RuntimeException("");
    }

    private static void printAllString(String a){
        char[] arrays = a.toCharArray();
        printAll(arrays, 0,arrays.length-1);



    }

    private static void printAll(char[] array, int from, int to){
        if(from == to){
            System.out.println(array);
        }else {
            for (int i = from; i<=to; i++){
                swap(array, from,i);
                printAll(array, from+1, to);
                swap(array, from, i);
            }
        }

    }

    private static void swap(char[] array, int i, int j){
        char temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private static void testSwitch(){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer i: list){
            switch (i){
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                default:
            }
        }
    }


}
