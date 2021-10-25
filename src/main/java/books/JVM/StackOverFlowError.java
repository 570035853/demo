package books.JVM;

/**
 * Created by jialei.zou on 2019/6/21 .
 */
public class StackOverFlowError {

    /**
     * 很快就会有报错
     */
    public void stackOverFlow(){
        stackOverFlow();
    }

    public static void main(String[] args) {
        StackOverFlowError stack = new StackOverFlowError();
        stack.stackOverFlow();
    }
}
