package interview.factory;

public class Demo {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car benz = carFactory.getCarCorpByBrand("BENZ");
        benz.produce();
    }


}
