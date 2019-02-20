package javaThis;

/**
 * Created by jialei.zou on 2018/7/30 .
 */
public class Father {

    public void show(){
        System.out.println("show");
    }
    public void fMe(){
        System.out.println("fMe");
        fMe1();//invovespecial调用 调用私有方法
        System.out.println(this);
        this.fMe1();//invovespecial调用 ？JVM方法调用（invokevirtual） - codeZhu - 博客园
    }
    public void fMe1(){
        System.out.println("fMe1");
    }
}
