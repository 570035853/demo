package aop.Reflect;

/**
 * Created by jialei.zou on 2019/5/27 .
 */
public class People {
    private String name;
    private int age;


    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People(String name) {
        this.name = name;
        this.age = 18;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(getName() + " " + getAge());
    }
}