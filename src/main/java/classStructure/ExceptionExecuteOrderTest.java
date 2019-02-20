package classStructure;

import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by zoujialei on 17/12/17.
 * 补充相关知识点：
 * 参考网址：https://www.ibm.com/developerworks/cn/java/j-lo-finally/
 * 参考书籍：深入理解JAVA虚拟机
 *
 * 前置知识：
 * 1. 控制转移语句：return、throw、break、continue
 *
 * 其他相关知识点：
 * 1. 具体finally的实现：Java虚拟机将finally模块中的内容作为subroutine，直接插入到try和catch语句的控制转移语句前；
 * 2. 单独强调下方法返回值：在执行subroutine之前，try或catch代码块会将返回值保存到本地变量表，执行完subroutine之后，
 *    恢复保留的返回值到操作数栈，然后返回给调用者。
 *
 */
public class ExceptionExecuteOrderTest {

    public static void main(String[] args) {
        System.out.println("result: " + inc());
        ConcurrentSkipListMap test = new ConcurrentSkipListMap();
    }

    public static int inc(){
        int x = 0;


        try{
            int y = x/0;
            x++;
//            StringBuffer stringBuffer = null;
//            stringBuffer.append("something");
            System.out.println("try block, x =" + x);
            return x;
        }catch (NullPointerException e){
            x++;
            System.out.println("catch block, x =" + x);
            return x;
        }finally {
            x++;
            System.out.println("finally block, x =" + x);
//            int z = x/0;
//            System.out.println("finally block, z =" + x);
            return x;  //直接回控制转移
        }
    }
}
