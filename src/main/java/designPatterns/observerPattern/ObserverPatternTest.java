package designPatterns.observerPattern;

/**
 * Created by jialei.zou on 2018/11/3 .
 */
public class ObserverPatternTest {

    public static void main(String[] args) {
        //create subject
        MyTopic topic = new MyTopic();

        //create observers
        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        //attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        //check if any update is available
        obj1.update();

        //now send message to subject
//        topic.postMessage("New Message");

        MyRunnable myRunnable2 = new MyRunnable(topic, "second message");
        MyRunnable myRunnable1 = new MyRunnable(topic, "first message");

        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();

        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
