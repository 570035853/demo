package designPatterns.decoratePattern;

/**
 * Created by jialei.zou on 2018/11/2 .
 * ref: https://www.journaldev.com/1540/decorator-design-pattern-in-java-example
 * 1. 实现了各种车的装饰增加，非常灵活（运行时候加载：看类的话，无法得知如何装饰，对于CarDecorator的子类来说，无法知道运行的时候父类如何加载）
 * 2. 有些类似于linux的管道
 * 3. Decorator pattern is used a lot in Java IO classes, such as FileReader, BufferedReader etc.
 */
public class DecoratorPatternTest {

    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();

    }
}
