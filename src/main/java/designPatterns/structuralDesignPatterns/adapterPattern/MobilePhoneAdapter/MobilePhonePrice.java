package designPatterns.structuralDesignPatterns.adapterPattern.MobilePhoneAdapter;

import java.math.BigDecimal;

/**
 * Created by jialei.zou on 2018/10/31 .
 */
public interface MobilePhonePrice {

    BigDecimal getIphonePrice();

    BigDecimal getHuaWeiPrice();

    BigDecimal getXiaoMiPrice();
}
