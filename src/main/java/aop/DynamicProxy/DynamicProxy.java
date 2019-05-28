package aop.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jialei.zou on 2019/3/16 .
 */
public class DynamicProxy implements InvocationHandler {
    private Object obj; //obj为委托类对象；
    public DynamicProxy(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如下语句打印：class com.sun.proxy.$Proxy0
        System.out.println("proxy:"+proxy.getClass()+" method:"+method+" args:"+args);
        System.out.println("before");
        Object result = method.invoke(obj, args);
        //如下方式会形成死循环，因为属于自己调用自己
//        Object result = method.invoke(proxy, args);
        System.out.println("after");
        return result;
    }
}
