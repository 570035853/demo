package searializableTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by zoujialei on 17/11/26.
 *<pre>
 public class SemaphoreDemo {
@DemoAnnotation
public void demoMethod() {
}
}
 </pre>
 *
 * 参考网址：https://www.ibm.com/developerworks/cn/java/j-lo-serial/index.html
 * 主要知识点：
 * 1.序列化ID，如果存储前和存储后不一样，反序列化会失败，报错“id不一致”；
 * 2.静态变量：不参与序列化，仅对象状态才保存
 * 3.父对象：由于JAVA构建对象，需要先构建父对象（无参数构造函数），如果父对象没有实现Seari接口，则父变量都是默认声明的值；
 * 4.敏感字段加密：可以在对象中重写wirteObject及readObject方法；
 * 5.多次序列化问题：如果连续写入一个对象，后面的写入，只是写入第一次写入对象的引用，如果第二次写去钱，修改了对象状态，是不能成功记录的。
 *
 */
public class SearializableTest {

    public static void main(String[] args) {
        testAttribute();


        testSearializableId();


    }


    /**
     * 序列化，并不会序列化类的属性，只是序列化对象的变量
     * 打印结果：A staticValue:5
     */
    private static void testAttribute(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/admin/ls/_17_skiplist.obj"));
            A aIn = new A();
            A.staticValue = 10;
            out.writeObject(aIn);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/admin/ls/_17_skiplist.obj"));
            A.staticValue = 5;
            A aOut = (A)in.readObject();
            in.close();
            System.out.println("A staticValue:" + aOut.staticValue);

        }catch (Exception e){
            //do nothing
        }
    }

    /**
     * 如果保存的时候，A的序列化ID为1，反序列化前，对ID进行了值改变，改为了2，则反序列化失败
     *java.io.InvalidClassException: searializableTest.A; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
     */
    private static void testSearializableId(){
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/admin/ls/_17_skiplist.obj"));
            A aOut = (A)in.readObject();
            in.close();
            System.out.println("A staticValue:" + aOut.staticValue);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
