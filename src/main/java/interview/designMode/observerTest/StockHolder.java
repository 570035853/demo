package interview.designMode.observerTest;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by zoujialei on 18/1/8.
 */
public class StockHolder implements Observer{

    @Override
    public void update(Observable o, Object arg){
        String className = this.getClass().getName();
        System.out.println("class:" + className + " price:" + (BigDecimal) arg);
    }
}
