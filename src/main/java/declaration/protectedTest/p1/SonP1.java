package declaration.protectedTest.p1;

/**
 * Created by zoujialei on 2018/7/6.
 */
public class SonP1 extends Father{
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
