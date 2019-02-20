package designPatterns.decoratePattern;

/**
 * Created by jialei.zou on 2018/11/2 .
 */
public class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }

}
