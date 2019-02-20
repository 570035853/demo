package designPatterns.structuralDesignPatterns.adapterPattern.MobilePhoneAdapter;

import java.math.BigDecimal;

/**
 * Created by jialei.zou on 2018/10/31 .
 */
public class AbstractMobilePhonePrice implements MobilePhonePrice {

    @Override
    public BigDecimal getIphonePrice(){
        throw new RuntimeException("iphone price not defined yet");
    }

    @Override
    public BigDecimal getHuaWeiPrice(){
        throw new RuntimeException("Huawei price not defined yet");
    }

    @Override
    public BigDecimal getXiaoMiPrice(){
        throw new RuntimeException("Xiaomi price not defined yet");
    }
}
