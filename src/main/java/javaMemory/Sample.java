package javaMemory;

/**
 * Created by jialei.zou on 2018/11/9 .
 */
public class Sample //运行时, jvm 把appmain的信息都放入方法区
{
    /** 范例名称 */
    private String name; //new Sample实例后， name 引用放入栈区里, name 对应的 String 对象放入堆里
    /** 构造方法 */
    public Sample(String name){
        this .name = name;
    }
    /** 输出 */
    public void printName(){ //在没有对象的时候，print方法跟随sample类被放入方法区里。
        System.out.println(name);
    }
}