package designPatterns.structuralDesignPatterns.adapterPattern.SocketAdapter;

/**
 * Created by jialei.zou on 2018/11/1 .
 */
public class Socket {

    Volt getVolt(){
        return new Volt(120);
    }
}
