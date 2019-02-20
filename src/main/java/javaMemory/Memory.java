package javaMemory;

/**
 * Created by jialei.zou on 2018/11/9 .
 */
public class Memory {

    public static void main(String[] args){ //main 方法本身放入方法区。   　
        Sample test1 = new Sample("test1"); //test1是引用，所以放到栈区里， Sample是自定义对象应该放到堆里面
        Sample test2 = new Sample("test2");
        test1.printName();
        test2.printName();
    }




}
