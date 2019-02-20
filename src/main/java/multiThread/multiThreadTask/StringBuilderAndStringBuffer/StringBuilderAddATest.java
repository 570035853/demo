package multiThread.multiThreadTask.StringBuilderAndStringBuffer;

/**
 * Created by zoujialei on 17/12/6.
 */
public class StringBuilderAddATest implements Runnable{

    private StringBuilder builder;

    public StringBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public void run(){
        for (int i = 0; i<10000; i++ ){
            this.builder.append("a");
        }
    }
}
