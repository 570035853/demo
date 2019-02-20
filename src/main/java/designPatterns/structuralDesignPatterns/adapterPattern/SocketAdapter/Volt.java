package designPatterns.structuralDesignPatterns.adapterPattern.SocketAdapter;

/**
 * Created by jialei.zou on 2018/11/1 .
 *
 */
public class Volt {

    private int value;

    public Volt(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
