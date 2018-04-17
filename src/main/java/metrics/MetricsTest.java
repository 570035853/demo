package metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by zoujialei on 2018/4/17.
 * ref: http://wuchong.me/blog/2015/08/01/getting-started-with-metrics/
 * demos show how the metrics are used to track and record methods
 */
public class MetricsTest {


    /**
     *
     */
    public static class GaugeTest {
        public static Queue<String> q = new LinkedList<String>();
        public static void main(String[] args) throws InterruptedException {
            MetricRegistry registry = new MetricRegistry();
            ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
            reporter.start(2, TimeUnit.SECONDS);
            registry.register(MetricRegistry.name(GaugeTest.class, "queue", "size"),
                    new Gauge<Integer>() {
                        public Integer getValue() {
                            return q.size();
                        }
                    });
            while(true){
                Thread.sleep(1000);
                q.add("Job-xxx");
            }
        }
    }


    public static class MeterTest {
        public static Random random = new Random();
        public static void request(Meter meter){
            System.out.println("request");
            meter.mark();
        }
        public static void request(Meter meter, int n){
            while(n > 0){
                request(meter);
                n--;
            }
        }
        public static void main(String[] args) throws InterruptedException {
            MetricRegistry registry = new MetricRegistry();
            ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
            reporter.start(1, TimeUnit.SECONDS);
            Meter meterTps = registry.meter(MetricRegistry.name(MeterTest.class,"request","tps"));
            while(true){
                request(meterTps,random.nextInt(5));
                Thread.sleep(1000);
            }
        }
    }



}
