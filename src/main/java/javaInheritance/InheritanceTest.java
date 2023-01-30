package javaInheritance;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zoujialei02
 * @date 2022/11/17
 */
public class InheritanceTest {

    public static void main(String[] args) {

        Father father = new Father();
        father.setId(1);

        Son son = new Son();
        son.setId(2);
        son.setName("sonName");
        son.setCloth("lining");
        List<Father> list = new ArrayList<>();

        list.add(father);
        list.add(son);

        System.out.println(JSON.toJSONString(list));
    }
}
