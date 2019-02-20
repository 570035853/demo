package threadLocal;

/**
 * Created by jialei.zou on 2018/7/27 .
 */
public class ThreadLocalDemo {
    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        if(threadLocal.get()==null){
            System.out.println("还没有放入数据");
            threadLocal.set("已放入数据");
            threadLocal.set("放入覆盖数据");
        }

        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
    }
}
