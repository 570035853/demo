package interview.designMode.factory;

public class CarFactory {

    public Car getCarCorpByBrand(String brand){
        if("BENZ".equals(brand)){
            return new Benz();
        }
        else{
            return new Audi();
        }
    }
}
