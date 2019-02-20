package multiThread.multiThreadTask.StringBuilderAndStringBuffer;

/**
 * Created by zoujialei on 17/12/6.
 */
public class StringBufferAddATest implements Runnable{
    private StringBuffer buffer;

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        for (int i = 0; i<1000; i++){
            buffer.append("a");
        }
    }
}
