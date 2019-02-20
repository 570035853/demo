package designPatterns.structuralDesignPatterns.adapterPattern.MobilePhoneAdapter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jialei.zou on 2018/10/31 .
 * 总结：
 * 1. 接口的适配器模式：当接口中有多个方法，而不同的实现类只希望实现其中部分的时候，可以写一个抽象类，抽象类无具体实现，
 * 不同的实现类继承抽象类，重写抽象类里面的方法
 * 2. 关于AbstractMobilePhonePrice里面的方法，由于未定义的时候不能使用，直接抛个异常出来
 * 3. 公共类里面写的比较好的：Arrays.asList()
 *
 */
public class MobilePhonePriceTest {

    public static void main(String[] args) {
        AbstractMobilePhonePrice iphonePrice = new IphonePrice();
        BigDecimal price = iphonePrice.getIphonePrice();
        System.out.println("iphonePrice:"+ price);
        iphonePrice.getHuaWeiPrice();

        List<Integer> list = Arrays.asList(new Integer("1"), new Integer("2"));

    }
}
