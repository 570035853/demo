package aop.DynamicProxy;

/**
 * Created by jialei.zou on 2019/3/16 .
 */
public class Vendor implements Sell {
    @Override
    public void sell() {
        System.out.println("In sell method");
    }

    @Override
    public void ad() {
        System.out.println("ad method");
    }
}