package designPatterns.observerPattern;

/**
 * Created by jialei.zou on 2018/11/3 .
 */
public class MyRunnable implements Runnable {

    MyTopic topic;
    String message;

    MyRunnable(MyTopic topic, String msg){
        this.topic = topic;
        this.message = msg;
    }

    @Override
    public void run(){
        topic.postMessage(message);
    }
}
