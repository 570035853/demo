package aop.cglib.UserCglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * Created by jialei.zou on 2019/3/16 .
 */
public class UserMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] arg,
                            MethodProxy proxy) throws Throwable {
        System.out.println("before:"+method.getName());
        Object object = proxy.invokeSuper(obj, arg);
        System.out.println("after:"+method.getName());
        return object;
    }

}
