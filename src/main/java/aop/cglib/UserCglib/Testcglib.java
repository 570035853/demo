package aop.cglib.UserCglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by jialei.zou on 2019/3/16 .
 */
public class Testcglib {

    public static void main(String[] args) {
        //该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zou/Documents/zoujialei/ls");
        Enhancer enhancer = new Enhancer();
        //继承被代理类
        enhancer.setSuperclass(User.class);
        //设置回调
        enhancer.setCallback(new UserMethodInterceptor());
        //生成代理类对象
        User user = (User)enhancer.create();
        //在调用代理类中方法时会被我们实现的方法拦截器进行拦截
        user.methodPublic1();
//        user.methodPublic2("22222222");
//        user.defaultMethod1(111);
//        user.defaultMethod2();

    }
}
