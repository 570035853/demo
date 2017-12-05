package declaration.finalTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoujialei on 17/11/27.
 */
public class FinalTest {

    private final String name = "final";

    private final List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
        System.out.println("name: " + finalTest.name);
        //如下不能编译通过
//        finalTest.name = ""

        finalTest.list.add("zhangsan");
        System.out.println("list: " + finalTest.list.toString());

    }
}
