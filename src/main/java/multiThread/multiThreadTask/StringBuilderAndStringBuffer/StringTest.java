package multiThread.multiThreadTask.StringBuilderAndStringBuffer;

/**
 * Created by zoujialei on 17/12/6.
 */
public class StringTest {

    private static StringBuilder builder = new StringBuilder();

    private static StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) {
        StringBuilderAddATest builderAddATest = new StringBuilderAddATest();
        builderAddATest.setBuilder(builder);
        StringBuilderAddBTest builderAddBTest = new StringBuilderAddBTest();
        builderAddBTest.setBuilder(builder);

        new Thread(builderAddATest).start();
        new Thread(builderAddBTest).start();
        new Thread(builderAddATest).start();
        new Thread(builderAddBTest).start();

        try {
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(builder.length());

        System.out.println("************************************");

        StringBufferAddATest bufferAddATest = new StringBufferAddATest();
        StringBufferAddBTest bufferAddBTest = new StringBufferAddBTest();
        bufferAddATest.setBuffer(buffer);
        bufferAddBTest.setBuffer(buffer);

        new Thread(bufferAddATest).start();
        new Thread(bufferAddBTest).start();

        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(buffer.toString());
        System.out.println(buffer.length());



    }
}
