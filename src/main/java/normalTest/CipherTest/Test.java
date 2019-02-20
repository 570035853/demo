package normalTest.CipherTest;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jialei.zou on 2018/9/3 .
 */
public class Test {

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor = null;
            long startOld = System.currentTimeMillis();
            OldCipher cipher = new OldCipher();
            cipher.encrypt("610326198707031813");
            long startOldFirst = System.currentTimeMillis();
            OldCipher cipher1 = new OldCipher();
            cipher1.encrypt("310112197208240018");
            OldCipher cipher2 = new OldCipher();
            cipher2.encrypt("430781198406294014");
            OldCipher cipher3 = new OldCipher();
            cipher3.encrypt("142703198803052717");
            OldCipher cipher4 = new OldCipher();
            cipher4.encrypt("6217001860005459029");

            for(int i = 0; i<100; i++){
                OldCipher cipher5 = new OldCipher();
                cipher5.encrypt("6217001860005459029");
            }
            long endOld = System.currentTimeMillis();
            System.out.println("old first cost=" + (startOldFirst-startOld));
            System.out.println("old cost=" + (endOld-startOldFirst));


            long start = System.currentTimeMillis();
            System.out.println(DESTextCipher.encrypt("610326198707031813"));
            long start1 = System.currentTimeMillis();
            DESTextCipher.encrypt("310112197208240018");
            DESTextCipher.encrypt("430781198406294014");
            DESTextCipher.encrypt("142703198803052717");
            DESTextCipher.encrypt("6217001860005459029");

            long end = System.currentTimeMillis();
            for(int i = 0; i<100; i++){
                DESTextCipher.encrypt("6217001860005459029");
            }
            System.out.println("cost1=" + (start1-start));
            System.out.println("cost=" + (end-start1));



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
