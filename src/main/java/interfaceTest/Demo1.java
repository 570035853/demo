package interfaceTest;

/**
 * Created by jialei.zou on 2019/7/8 .
 */
public class Demo1 {

    interface A{
        int x = 0;
    }


    class B{
        int x = 1;
    }

    class C extends B implements A{
        public void pX(){
//            System.out.println(x);
        }
    }
}
