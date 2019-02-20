package javaOverride;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by zoujialei on 2018/5/21.
 * Read more: http://www.java67.com/2012/08/what-is-method-overriding-in-java-example-tutorial.html#ixzz5G77S4Cu9
 */
public class Son extends Father{

    /**
     * father's method getAge is proected, son's can be protected protected or public
     * Third rule to override method in Java is that overriding method can not reduce accessibility of overridden method in Java
     */
//    @Override
//    protected int getAge(){
//        return 50;
//    }


    @Override
    public int getAge(){
        return 20;
    }

    /**
     * father throws IOExcption, son cannot throw checked Exception which is higher in hierarchy than fathe's method, like 'Exception'
     * Another worth noting rule of method overriding in Java is that overriding  method can not throw checked Exception which is higher in hierarchy
     * than overridden method. Which means if overridden method throws IOException than overriding method can not throw java.lang.Exception in its
     * throws clause because java.lang.Exception comes higher than IOException in Exception hierarchy. This rule doesn't apply to RuntimeException
     * in Java, which is not even need to be declared in throws clause in Java.

     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public String getName(String file) throws IOException {
        File nameList = new File(file);
        if(nameList == null){
            throw new IOException("nameList not exist");
        }
        return "";
    }

    /**
     * You can not override private, static and final method in Java. private and static method are bonded during compile time using static
     * binding in Java  and doesn't resolve during runtime. overriding final method in Java is compile time error. Though private and static
     * method can be hidden if you declare another method with same and signature in sub class.

     */

}
