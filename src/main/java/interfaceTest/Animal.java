package interfaceTest;

/**
 * Created by zoujialei on 2018/5/5.
 */
public interface Animal {

    String hello();

    /**
     * Object里面有该方法，加次接口是为了希望实现的类重新定义下该方法，如果不定义也没问题，就相当于使用了Object里面的方法
     * @param obj
     * @return
     */
    boolean equals(Object obj);
}
