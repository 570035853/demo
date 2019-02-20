package designPatterns.structuralDesignPatterns.adapterPattern.SocketAdapter;

/**
 * Created by jialei.zou on 2018/11/1 .
 */
public interface SocketAdapter {

    Volt get3VoltAdapter();

    Volt get20VoltAdapter();
}
