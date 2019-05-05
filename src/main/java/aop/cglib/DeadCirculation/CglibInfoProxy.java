package aop.cglib.DeadCirculation;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by jialei.zou on 2019/3/9 .
 */
public class CglibInfoProxy implements MethodInterceptor{

    private Object target;
    public Object newInstance(Object source){
        target = source;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     *
     * @param o  代理类
     * @param method InfoDemo.welcome方法
     * @param objects  参数，该示例中是"zhangsan"
     * @param methodProxy 代理类的方法，这个是比JDK多出来的一个参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method!!!");
//        Object value = methodProxy.invoke(o, objects);
        /**
         * 只有上面这一句的话没标明，执行的是代理类的方法，代理类的方法调用intercept方法，intercept调用代理类的方法，
         * 如此反复，形成死循环，不停的打印 before method!!!
         */

        //如下三种方式都没有问题的
//        Object value = methodProxy.invoke(this.target, objects);
//        Object value = methodProxy.invokeSuper(o, objects);
        Object value = method.invoke(this.target, objects);

        return value;
    }
    public static void main(String[] args) {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\\\classes");
        InfoDemo instance = (InfoDemo) new CglibInfoProxy().newInstance(new InfoDemo());
        instance.welcome("zhangsan");

    }

}
