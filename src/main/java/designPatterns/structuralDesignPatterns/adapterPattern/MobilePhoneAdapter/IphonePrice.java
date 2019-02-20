package designPatterns.structuralDesignPatterns.adapterPattern.MobilePhoneAdapter;

import java.math.BigDecimal;

/**
 * Created by jialei.zou on 2018/10/31 .
 */
public class IphonePrice extends AbstractMobilePhonePrice {

    @Override
    public BigDecimal getIphonePrice(){
        return new BigDecimal("10000");
    }
}
