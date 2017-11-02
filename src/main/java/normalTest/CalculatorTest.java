package normalTest;

import java.math.BigDecimal;

/**
 * Created by zoujialei on 17/10/26.
 */
public class CalculatorTest {

    public static void main(String[] args) {
        BigDecimal amt44604 = new BigDecimal("99641934.10");
        BigDecimal amt46723 = new BigDecimal("99252640.65");
        BigDecimal deltaAmt = amt44604.subtract(amt46723);
        System.out.println("deltaAmt:"+deltaAmt);

        BigDecimal amt = new BigDecimal("0.54").multiply(new BigDecimal("0.0005")).multiply(new BigDecimal("22"));
        System.out.println("amt:"+amt);
    }
}
