package rxJavaTest;

import io.reactivex.*;
import org.reactivestreams.Subscriber;

/**
 * Created by zoujialei on 2018/4/20.
 */
public class HelloWorldTest {

    public static void main(String[] args) {









        Flowable.just("Hello world").subscribe(System.out::println);



    }
}
