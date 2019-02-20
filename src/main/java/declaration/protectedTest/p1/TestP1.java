package declaration.protectedTest.p1;

import declaration.protectedTest.p2.SonP2;

/**
 * Created by zoujialei on 2018/7/6.
 */
public class TestP1 {



    public static void main(String[] args) {
        SonP1 sonP1 = new SonP1();
        sonP1.f();


        SonP2 sonP2 = new SonP2();
        sonP2.f();



    }
}
