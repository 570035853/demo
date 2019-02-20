package designPatterns.decoratePattern;

/**
 * Created by jialei.zou on 2018/11/2 .
 */
public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c){
        this.car=c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}
