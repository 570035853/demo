package designPatterns.decoratePattern;

/**
 * Created by jialei.zou on 2018/11/2 .
 */
public class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}