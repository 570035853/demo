package interfaceTest;

/**
 * Created by zoujialei on 2018/1/16.
 */
public class InterfaceTest {

    public static void main(String[] args) {
        Animal bird = new Animal() {
            @Override
            public String hello() {
                System.out.println("i am a bird");
                return "bird";
            }
        };

    }
}
