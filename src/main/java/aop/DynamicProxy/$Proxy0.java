package aop.DynamicProxy;

/**
 * Created by jialei.zou on 2019/3/16 .
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy0 extends Proxy implements Sell {
    //这5个Method对象分别代表equals()、toString()、ad()、sell()、hashCode()方法
    private static Method m1;
    private static Method m2;
    private static Method m4;
    private static Method m3;
    private static Method m0;

    //构造方法接收一个InvocationHandler对象为参数，这个对象就是代理类的“直接委托类”（真正的委托类可以看做代理类的“间接委托类”）
    public $Proxy0(InvocationHandler var1)   {
        super(var1);
    }

    //对equals方法的调用实际上转为对super.h.invoke方法的调用，父类中的h即为我们在构造方法中传入的InvocationHandler对象，以下的toString()、sell()、ad()、hashCode()等方法同理
    @Override
    public final boolean equals(Object var1)   {
        try {
            return ((Boolean)super.h.invoke(this, m1, new Object[]{var1})).booleanValue();
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final String toString() {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final void ad()   {
        try {
            super.h.invoke(this, m4, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final void sell()   {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final int hashCode()   {
        try {
            return ((Integer)super.h.invoke(this, m0, (Object[])null)).intValue();
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    //这里完成Method对象的初始化（通过反射在运行时获得Method对象）
    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m4 = Class.forName("Sell").getMethod("ad", new Class[0]);
            m3 = Class.forName("Sell").getMethod("sell", new Class[0]);
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }

    public static void main(String[] args) {
        $Proxy0 proxy0 = new $Proxy0(null);
    }
}