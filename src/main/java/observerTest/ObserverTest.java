package observerTest;

import java.math.BigDecimal;

/**
 * Created by zoujialei on 18/1/8.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Stock shyh = new Stock();
        StockHolder holder1 = new StockHolder();
        StockHolder holder2 = new StockHolder();
        StockHolder holder3 = new StockHolder();
        shyh.addObserver(holder1);
        shyh.addObserver(holder2);
        shyh.addObserver(holder3);

        shyh.setPrice(new BigDecimal("200"));

        shyh.setPrice(new BigDecimal("250"));


    }
}
