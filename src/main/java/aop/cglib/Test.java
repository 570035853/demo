package aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

/**
 * Created by jialei.zou on 2019/3/9 .
 */

public class Test {

    /**
     * 了解其cglib基本实现原理
     */
    public void testFixedValue() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib";
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null)); //拦截test，输出:Hello cglib
        System.out.println(proxy.toString());  //拦截test，输出:Hello cglib

        //因为getClass是final方法，没有做拦截：输出class aop.cglib.SampleClass$$EnhancerByCGLIB$$282a8aa2
        System.out.println(proxy.getClass());

        /**
         * 因为hashCode不是final，会被拦截，但是该方法要求输出的是int，而拦截输出的是String类型（"hello cglib"）
         * 输出
         * Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Number
         at aop.cglib.SampleClass$$EnhancerByCGLIB$$282a8aa2.hashCode(<generated>)
         */
        System.out.println(proxy.hashCode());

    }



    public void testInvocationHandler() throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    return "hello cglib";
                }else{
                    throw new RuntimeException("Do not know what to do");
                }
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null));
        System.out.println(proxy.toString());
    }


    public static void main(String[] args) throws Exception{
        Test cglibTest = new Test();
//        cglibTest.testFixedValue();
        cglibTest.testInvocationHandler();
    }
}
