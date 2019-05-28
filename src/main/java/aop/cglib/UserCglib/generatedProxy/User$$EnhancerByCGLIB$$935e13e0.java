/*

package aop.cglib.UserCglib.generatedProxy;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import aop.cglib.UserCglib.User;
import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class User$$EnhancerByCGLIB$$935e13e0 extends User implements Factory {
    private boolean CGLIB$BOUND;
    private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
    private static final Callback[] CGLIB$STATIC_CALLBACKS;
    private MethodInterceptor CGLIB$CALLBACK_0;
    private static final Method CGLIB$methodPublic1$0$Method;
    private static final MethodProxy CGLIB$methodPublic1$0$Proxy;
    private static final Object[] CGLIB$emptyArgs;
    private static final Method CGLIB$methodPublic2$1$Method;
    private static final MethodProxy CGLIB$methodPublic2$1$Proxy;
    private static final Method CGLIB$defaultMethod1$2$Method;
    private static final MethodProxy CGLIB$defaultMethod1$2$Proxy;
    private static final Method CGLIB$defaultMethod2$3$Method;
    private static final MethodProxy CGLIB$defaultMethod2$3$Proxy;
    private static final Method CGLIB$finalize$4$Method;
    private static final MethodProxy CGLIB$finalize$4$Proxy;
    private static final Method CGLIB$equals$5$Method;
    private static final MethodProxy CGLIB$equals$5$Proxy;
    private static final Method CGLIB$toString$6$Method;
    private static final MethodProxy CGLIB$toString$6$Proxy;
    private static final Method CGLIB$hashCode$7$Method;
    private static final MethodProxy CGLIB$hashCode$7$Proxy;
    private static final Method CGLIB$clone$8$Method;
    private static final MethodProxy CGLIB$clone$8$Proxy;

    static void CGLIB$STATICHOOK1() {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
        CGLIB$emptyArgs = new Object[0];
        Class var0 = Class.forName("aop.cglib.UserCglib.User$$EnhancerByCGLIB$$935e13e0");
        Class var1;
        Method[] var10000 = ReflectUtils.findMethods(new String[]{"finalize", "()V", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, (var1 = Class.forName("java.lang.Object")).getDeclaredMethods());
        CGLIB$finalize$4$Method = var10000[0];
        CGLIB$finalize$4$Proxy = MethodProxy.create(var1, var0, "()V", "finalize", "CGLIB$finalize$4");
        CGLIB$equals$5$Method = var10000[1];
        CGLIB$equals$5$Proxy = MethodProxy.create(var1, var0, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$5");
        CGLIB$toString$6$Method = var10000[2];
        CGLIB$toString$6$Proxy = MethodProxy.create(var1, var0, "()Ljava/lang/String;", "toString", "CGLIB$toString$6");
        CGLIB$hashCode$7$Method = var10000[3];
        CGLIB$hashCode$7$Proxy = MethodProxy.create(var1, var0, "()I", "hashCode", "CGLIB$hashCode$7");
        CGLIB$clone$8$Method = var10000[4];
        CGLIB$clone$8$Proxy = MethodProxy.create(var1, var0, "()Ljava/lang/Object;", "clone", "CGLIB$clone$8");
        var10000 = ReflectUtils.findMethods(new String[]{"methodPublic1", "()V", "methodPublic2", "(Ljava/lang/String;)V", "defaultMethod1", "(I)V", "defaultMethod2", "()V"}, (var1 = Class.forName("aop.cglib.UserCglib.User")).getDeclaredMethods());
        CGLIB$methodPublic1$0$Method = var10000[0];
        CGLIB$methodPublic1$0$Proxy = MethodProxy.create(var1, var0, "()V", "methodPublic1", "CGLIB$methodPublic1$0");
        CGLIB$methodPublic2$1$Method = var10000[1];
        CGLIB$methodPublic2$1$Proxy = MethodProxy.create(var1, var0, "(Ljava/lang/String;)V", "methodPublic2", "CGLIB$methodPublic2$1");
        CGLIB$defaultMethod1$2$Method = var10000[2];
        CGLIB$defaultMethod1$2$Proxy = MethodProxy.create(var1, var0, "(I)V", "defaultMethod1", "CGLIB$defaultMethod1$2");
        CGLIB$defaultMethod2$3$Method = var10000[3];
        CGLIB$defaultMethod2$3$Proxy = MethodProxy.create(var1, var0, "()V", "defaultMethod2", "CGLIB$defaultMethod2$3");
    }

    final void CGLIB$methodPublic1$0() {
        super.methodPublic1();
    }

    public final void methodPublic1() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            var10000.intercept(this, CGLIB$methodPublic1$0$Method, CGLIB$emptyArgs, CGLIB$methodPublic1$0$Proxy);
        } else {
            super.methodPublic1();
        }
    }

    final void CGLIB$methodPublic2$1(String var1) {
        super.methodPublic2(var1);
    }

    public final void methodPublic2(String var1) {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            var10000.intercept(this, CGLIB$methodPublic2$1$Method, new Object[]{var1}, CGLIB$methodPublic2$1$Proxy);
        } else {
            super.methodPublic2(var1);
        }
    }

    final void CGLIB$defaultMethod1$2(int var1) {
        super.defaultMethod1(var1);
    }

    public final void defaultMethod1(int var1) {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            var10000.intercept(this, CGLIB$defaultMethod1$2$Method, new Object[]{new Integer(var1)}, CGLIB$defaultMethod1$2$Proxy);
        } else {
            super.defaultMethod1(var1);
        }
    }

    final void CGLIB$defaultMethod2$3() {
        super.defaultMethod2();
    }

    public final void defaultMethod2() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            var10000.intercept(this, CGLIB$defaultMethod2$3$Method, CGLIB$emptyArgs, CGLIB$defaultMethod2$3$Proxy);
        } else {
            super.defaultMethod2();
        }
    }

    final void CGLIB$finalize$4() throws Throwable {
        super.finalize();
    }

    protected final void finalize() throws Throwable {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            var10000.intercept(this, CGLIB$finalize$4$Method, CGLIB$emptyArgs, CGLIB$finalize$4$Proxy);
        } else {
            super.finalize();
        }
    }

    final boolean CGLIB$equals$5(Object var1) {
        return super.equals(var1);
    }

    public final boolean equals(Object var1) {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            Object var2 = var10000.intercept(this, CGLIB$equals$5$Method, new Object[]{var1}, CGLIB$equals$5$Proxy);
            return var2 == null ? false : ((Boolean)var2).booleanValue();
        } else {
            return super.equals(var1);
        }
    }

    final String CGLIB$toString$6() {
        return super.toString();
    }

    public final String toString() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        return var10000 != null ? (String)var10000.intercept(this, CGLIB$toString$6$Method, CGLIB$emptyArgs, CGLIB$toString$6$Proxy) : super.toString();
    }

    final int CGLIB$hashCode$7() {
        return super.hashCode();
    }

    public final int hashCode() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            Object var1 = var10000.intercept(this, CGLIB$hashCode$7$Method, CGLIB$emptyArgs, CGLIB$hashCode$7$Proxy);
            return var1 == null ? 0 : ((Number)var1).intValue();
        } else {
            return super.hashCode();
        }
    }

    final Object CGLIB$clone$8() throws CloneNotSupportedException {
        return super.clone();
    }

    protected final Object clone() throws CloneNotSupportedException {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (this.CGLIB$CALLBACK_0 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        return var10000 != null ? var10000.intercept(this, CGLIB$clone$8$Method, CGLIB$emptyArgs, CGLIB$clone$8$Proxy) : super.clone();
    }

    public static MethodProxy CGLIB$findMethodProxy(Signature var0) {
        String var10000 = var0.toString();
        switch(var10000.hashCode()) {
            case -1574182249:
                if (var10000.equals("finalize()V")) {
                    return CGLIB$finalize$4$Proxy;
                }
                break;
            case -508378822:
                if (var10000.equals("clone()Ljava/lang/Object;")) {
                    return CGLIB$clone$8$Proxy;
                }
                break;
            case -411343995:
                if (var10000.equals("defaultMethod2()V")) {
                    return CGLIB$defaultMethod2$3$Proxy;
                }
                break;
            case 132343965:
                if (var10000.equals("defaultMethod1(I)V")) {
                    return CGLIB$defaultMethod1$2$Proxy;
                }
                break;
            case 604503886:
                if (var10000.equals("methodPublic1()V")) {
                    return CGLIB$methodPublic1$0$Proxy;
                }
                break;
            case 987425847:
                if (var10000.equals("methodPublic2(Ljava/lang/String;)V")) {
                    return CGLIB$methodPublic2$1$Proxy;
                }
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return CGLIB$equals$5$Proxy;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return CGLIB$toString$6$Proxy;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return CGLIB$hashCode$7$Proxy;
                }
        }

        return null;
    }

    public User$$EnhancerByCGLIB$$935e13e0() {
        CGLIB$BIND_CALLBACKS(this);
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] var0) {
        CGLIB$THREAD_CALLBACKS.set(var0);
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] var0) {
        CGLIB$STATIC_CALLBACKS = var0;
    }

    private static final void CGLIB$BIND_CALLBACKS(Object var0) {
        User$$EnhancerByCGLIB$$935e13e0 var1 = (User$$EnhancerByCGLIB$$935e13e0)var0;
        if (!var1.CGLIB$BOUND) {
            var1.CGLIB$BOUND = true;
            Object var10000 = CGLIB$THREAD_CALLBACKS.get();
            if (var10000 == null) {
                var10000 = CGLIB$STATIC_CALLBACKS;
                if (CGLIB$STATIC_CALLBACKS == null) {
                    return;
                }
            }

            var1.CGLIB$CALLBACK_0 = (MethodInterceptor)((Callback[])var10000)[0];
        }

    }

    public Object newInstance(Callback[] var1) {
        CGLIB$SET_THREAD_CALLBACKS(var1);
        User$$EnhancerByCGLIB$$935e13e0 var10000 = new User$$EnhancerByCGLIB$$935e13e0();
        CGLIB$SET_THREAD_CALLBACKS((Callback[])null);
        return var10000;
    }

    public Object newInstance(Callback var1) {
        CGLIB$SET_THREAD_CALLBACKS(new Callback[]{var1});
        User$$EnhancerByCGLIB$$935e13e0 var10000 = new User$$EnhancerByCGLIB$$935e13e0();
        CGLIB$SET_THREAD_CALLBACKS((Callback[])null);
        return var10000;
    }

    public Object newInstance(Class[] var1, Object[] var2, Callback[] var3) {
        CGLIB$SET_THREAD_CALLBACKS(var3);
        User$$EnhancerByCGLIB$$935e13e0 var10000 = new User$$EnhancerByCGLIB$$935e13e0;
        switch(var1.length) {
            case 0:
                var10000.<init>();
                CGLIB$SET_THREAD_CALLBACKS((Callback[])null);
                return var10000;
            default:
                throw new IllegalArgumentException("Constructor not found");
        }
    }

    public Callback getCallback(int var1) {
        CGLIB$BIND_CALLBACKS(this);
        MethodInterceptor var10000;
        switch(var1) {
            case 0:
                var10000 = this.CGLIB$CALLBACK_0;
                break;
            default:
                var10000 = null;
        }

        return var10000;
    }

    public void setCallback(int var1, Callback var2) {
        switch(var1) {
            case 0:
                this.CGLIB$CALLBACK_0 = (MethodInterceptor)var2;
            default:
        }
    }

    public Callback[] getCallbacks() {
        CGLIB$BIND_CALLBACKS(this);
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    public void setCallbacks(Callback[] var1) {
        this.CGLIB$CALLBACK_0 = (MethodInterceptor)var1[0];
    }

    static {
        CGLIB$STATICHOOK1();
    }
}


*/