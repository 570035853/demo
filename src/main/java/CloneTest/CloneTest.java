package CloneTest;

/**
 * Created by zoujialei on 18/1/9.
 */
public class CloneTest {


    public static void main(String[] args) {
        ClassNotCloneable classNotCloneable = new ClassNotCloneable();
        ClassCloneable from = new ClassCloneable();
        ClassCloneable toClone = from.clone(from);
    }

}
