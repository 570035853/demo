package designPatterns.observerPattern;

/**
 * Created by jialei.zou on 2018/11/3 .
 */
public interface Observer {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);
}