package designPatterns.structuralDesignPatterns.adapterPattern.SocketAdapter;

/**
 * Created by jialei.zou on 2018/11/1 .
 */
public class ClassSocketAdapterImpl extends Socket implements SocketAdapter{

    @Override
    public Volt get3VoltAdapter(){
        Volt volt = getVolt();
        return convertVolt(volt, 40);
    }

    @Override
    public Volt get20VoltAdapter(){
        Volt volt = getVolt();
        return convertVolt(volt, 6);
    }

    private Volt convertVolt(Volt volt, int i){
        return new Volt(volt.getValue()/i);
    }
}
