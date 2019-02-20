package declaration.protectedTest.p2;

import declaration.protectedTest.p1.SonP1;

/**
 * Created by zoujialei on 2018/7/6.
 */
public class TestP2 {
    public static void main(String[] args) {
        SonP1 sonP1 = new SonP1();
//        sonP1.f(); //会报错，f仅能在p1包中使用及其子类

        SonP2 sonP2 = new SonP2();
//        sonP2.f();//会报错，f仅能在p1包中使用及其子类
    }
}
