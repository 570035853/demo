package javaOverride.JavaPolymorphic;

/**
 * Created by zoujialei on 2018/5/22.
 */
public class PolymorohicTest {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        trainAnimal(dog);
        trainAnimal(cat);
    }

    public static void trainAnimal(Animal animal){
        animal.hello();
    }
}
