package multiThread.connectionPool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by jialei.zou on 2019/5/18 .
 * 参考《java并发编程的艺术》4.4.1 P106等待超时模式

 准备方面
 由于用到java.Connection接口，需要引用包
 <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.13</version>
 </dependency>

 实现
 需要保存一个池子，对池子资源的访问要做并发控制，

 相关知识点
 对于接口的实现，可以使用动态代理的方式，实现InvocationHandler接口，说明
 1. 可以学习作者生成动态代理的实现方式：接口待实现的方法有很多，使用动态代理，可以使得实现类很简洁，从而只关注连接池的相关资源
 2. 先暂时不看InvocationHandler的相关细节

 作者程序的亮点是
 1. 用list来实现的池子，每一个的增加删除，都用了syn来进行锁控制
 2. 对于超时时间的控制两个并行条件，队列为空+还有剩余的等待时间，则需要进行等待，否则就开始查看到底池子里面有没有资源

 *
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int size){
        for (int i = 0; i<size; i++){
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    public void releaseConnection(Connection connection){
        synchronized (pool){
            pool.addLast(connection);
            pool.notifyAll();
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized (pool){
            if(mills<=0){
                while (pool.isEmpty()){
                    wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis()+mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining>0){
                    wait(remaining);
                    remaining = future-System.currentTimeMillis();
                }
                if(pool.size()>0){
                    return pool.removeFirst();
                }else {
                    return null;
                }

            }
        }

    }
}
