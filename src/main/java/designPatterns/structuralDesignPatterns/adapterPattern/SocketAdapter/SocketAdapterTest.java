package designPatterns.structuralDesignPatterns.adapterPattern.SocketAdapter;

/**
 * Created by jialei.zou on 2018/11/1 .
 * ref: https://www.journaldev.com/1827/java-design-patterns-example-tutorial#adapter-pattern
 * 1. 类似一个插线板（Socket），转换头输出口（SocketAdapter）,转换器（SocketAdapterImpl）
 * 2. 类的适配器，通过继承原有功能类（Socket）及实现接口的方式实现；
 *    对象的适配器，通过将对象作为最终转换器实现类的一部分实现
 */
public class SocketAdapterTest {

    public static void main(String[] args) {
        SocketAdapter classSocketAdapter = new ClassSocketAdapterImpl();
        SocketAdapter objectSocketAdapter = new ObjectSocketAdapterImpl();
        System.out.println("ClassSocketAdapterImpl.get3VoltAdapter():"+classSocketAdapter.get3VoltAdapter().getValue());
        System.out.println("ObjectSocketAdapterImpl.get3VoltAdapter():"+objectSocketAdapter.get3VoltAdapter().getValue());
    }
}
