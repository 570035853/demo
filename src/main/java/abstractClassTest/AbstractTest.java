package abstractClassTest;

/**
 * Created by zoujialei on 2018/5/5.
 */
public class AbstractTest {
    public static void main(String[] args) {
        Animal monkey = new Animal() {
            @Override
            Double height() {
                return null;
            }
        };
    }
}
