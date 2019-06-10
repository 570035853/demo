package interview.designMode.observerTest;

import java.math.BigDecimal;
import java.util.Observable;

/**
 * Created by zoujialei on 18/1/8.
 */
public class Stock extends Observable{
    private BigDecimal price;

    public void setPrice(BigDecimal price) {
        this.price = price;
        super.setChanged();
        super.notifyObservers(price);
    }
}
