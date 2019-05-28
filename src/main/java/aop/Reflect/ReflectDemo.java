package aop.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jialei.zou on 2019/5/27 .
 * ref:
 * https://www.cnblogs.com/absfree/p/5277665.html
 * 除了下述方法，还有获取方法，字段的方法等
 *
 */
public class ReflectDemo {

    public static void main(String[] args) {
        /**
         * 1. 如下三种获取目标Class的方法
         */
        Class<People> peopleClass1 = People.class;
        Class<People> peopleClass2 = null;
        try {
            peopleClass2 = (Class<People>)Class.forName("aop.Reflect.People");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        People people = new People("jack", 18);
        //如下无论指定还是不指定T都是可以的
//        Class<People> peopleClass3 = (Class<People>)people.getClass();
        Class peopleClass3 = people.getClass();


        System.out.println(peopleClass1);
        System.out.println(peopleClass2);
        System.out.println(peopleClass3);


        /**
         * 2. 如下方法可以获取类的构造方法
         */
        try {
            //只能获取public方法
//            Constructor constructorPublic = peopleClass1.getConstructor(String.class, int.class);
            //public private都可以
            Constructor constructor = peopleClass1.getDeclaredConstructor(String.class);
            // 设置 constructor 的 Accessible属性为ture以取消Java的访问检查
            constructor.setAccessible(true);
            try {
                People fromConstructor = (People) constructor.newInstance("jack");
                fromConstructor.speak();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }


        /**
         * 如下方法，可以获取类的普通方法
         */
        Method[] methods = peopleClass1.getMethods();  //公共方法，
        Method[] methodsIncludePrivate = peopleClass1.getDeclaredMethods();
        Method methodOne = null;
        try {
            methodOne = peopleClass1.getDeclaredMethod("setAge", int.class);
            Method methodOneIncludePrivate = peopleClass1.getDeclaredMethod("setAge", int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            methodOne.invoke(people, 20);
            System.out.println("now people age:"+people.getAge());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Field[] fields = peopleClass1.getFields();
        Field[] fieldsIncludePrivate = peopleClass1.getDeclaredFields();
        Field filedOne = null;
        try {
            filedOne = peopleClass1.getDeclaredField("name");
            filedOne.setAccessible(true);
            filedOne.set(people, "zhangsan");
            System.out.println("now people name:"+people.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
