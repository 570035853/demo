package books.JVM;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/6/21 .
 */
public class OutOfMemoryError {

    /*
      用了10分钟才抛出了错误， 堆异常
    */
    public void heapOutOfMemoryError(){
        List list = new LinkedList();
        while (true){
            list.add(new OutOfMemoryError());
        }
    }

    /**
     * 方法区溢出
     */
    public void methodAreaOOM(){
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OutOfMemoryError.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }

    public static void main(String[] args) {
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
        outOfMemoryError.methodAreaOOM();
    }



}
