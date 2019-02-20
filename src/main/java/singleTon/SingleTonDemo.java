package singleTon;

import java.util.HashMap;

/**
 * Created by zoujialei on 2018/6/22.
 */
public class SingleTonDemo {

    private volatile static SingleTonDemo singleTonDemo;


    private SingleTonDemo(){}

    public static SingleTonDemo getInstance(){
        if(singleTonDemo == null){
            synchronized (SingleTonDemo.class){
                if(singleTonDemo == null){
                    return new SingleTonDemo();
                }
                else {
                    return singleTonDemo;
                }
            }
        }else {
            return singleTonDemo;
        }

    }

    public static void main(String[] args) {

    }

}
