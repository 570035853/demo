package normalTest;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by zoujialei on 2018/1/16.
 */
public class TempTest1 {



    public static void main(String[] args) {

        String origin = "adjust\t\n" +
                "2023-01-13 09:51:17.305\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-3, mt_level:ERROR, mt_datetime:2023-01-13 09:51:17+0800, traceId__:4181474359792090368, es_datetime:2023-01-13 09:51:17.305, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:17 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900202481247045},\"3\":{\"i64\":147930},\"4\":{\"i64\":812627393},\"10\":{\"i64\":1673401277}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$660/916808727.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor130.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:305, mt_servername:set-gh-thhmerchant-mgov-detector02.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:15.981\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-1, mt_level:ERROR, mt_datetime:2023-01-13 09:51:15+0800, traceId__:-5298050088826012283, es_datetime:2023-01-13 09:51:15.981, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:15 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278885803350794374},\"3\":{\"i64\":157231},\"4\":{\"i64\":3667207003},\"10\":{\"i64\":1673314875}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$661/172610977.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor168.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:981, mt_servername:set-gh-thhmerchant-mgov-detector01.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:15.315\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-3, mt_level:ERROR, mt_datetime:2023-01-13 09:51:15+0800, traceId__:1716230004370970042, es_datetime:2023-01-13 09:51:15.315, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:15 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900201693432242},\"3\":{\"i64\":157415},\"4\":{\"i64\":30491881},\"10\":{\"i64\":1673401275}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$660/916808727.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor130.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:315, mt_servername:set-gh-thhmerchant-mgov-detector02.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:15.110\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-2, mt_level:ERROR, mt_datetime:2023-01-13 09:51:15+0800, traceId__:-2788099093805541575, es_datetime:2023-01-13 09:51:15.110, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:15 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900200987606227},\"3\":{\"i64\":153319},\"4\":{\"i64\":968576725},\"10\":{\"i64\":1673401275}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$661/172610977.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor168.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:110, mt_servername:set-gh-thhmerchant-mgov-detector01.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:14.598\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-1, mt_level:ERROR, mt_datetime:2023-01-13 09:51:14+0800, traceId__:-2650228224576496537, es_datetime:2023-01-13 09:51:14.598, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:14 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900200937684300},\"3\":{\"i64\":153247},\"4\":{\"i64\":3401398960},\"10\":{\"i64\":1673401274}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$660/916808727.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor130.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:598, mt_servername:set-gh-thhmerchant-mgov-detector02.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:05.808\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-2, mt_level:ERROR, mt_datetime:2023-01-13 09:51:05+0800, traceId__:2118592522615838749, es_datetime:2023-01-13 09:51:05.808, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:05 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900200091117664},\"3\":{\"i64\":155424},\"4\":{\"i64\":124340826},\"10\":{\"i64\":1673401265}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$663/467463168.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor174.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:808, mt_servername:set-mt-thhmerchant-mgov-detector05.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:04.319\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-3, mt_level:ERROR, mt_datetime:2023-01-13 09:51:04+0800, traceId__:-3750911613821361521, es_datetime:2023-01-13 09:51:04.319, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:04 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900204266559685},\"3\":{\"i64\":168096},\"4\":{\"i64\":3031541606},\"10\":{\"i64\":1673401264}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$663/467463168.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor174.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:319, mt_servername:set-mt-thhmerchant-mgov-detector05.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:02.030\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-0, mt_level:ERROR, mt_datetime:2023-01-13 09:51:02+0800, traceId__:1726265420721435832, es_datetime:2023-01-13 09:51:02.030, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:02 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900203218371012},\"3\":{\"i64\":150233},\"4\":{\"i64\":3561891535},\"10\":{\"i64\":1673401261}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$661/172610977.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor168.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:030, mt_servername:set-gh-thhmerchant-mgov-detector01.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:51:01.829\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-3, mt_level:ERROR, mt_datetime:2023-01-13 09:51:01+0800, traceId__:-8494964734505781117, es_datetime:2023-01-13 09:51:01.829, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:51:01 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900203974055178},\"3\":{\"i64\":157415},\"4\":{\"i64\":2817941057},\"10\":{\"i64\":1673401261}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$663/467463168.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor174.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:829, mt_servername:set-mt-thhmerchant-mgov-detector05.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:50:58.465\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-3, mt_level:ERROR, mt_datetime:2023-01-13 09:50:58+0800, traceId__:-3624033909449768024, es_datetime:2023-01-13 09:50:58.465, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:50:58 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900200433787447},\"3\":{\"i64\":154432},\"4\":{\"i64\":1191325583},\"10\":{\"i64\":1673401258}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$661/172610977.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor168.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:465, mt_servername:set-gh-thhmerchant-mgov-detector01.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:50:55.677\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-2, mt_level:ERROR, mt_datetime:2023-01-13 09:50:55+0800, traceId__:-8080291641433229236, es_datetime:2023-01-13 09:50:55.677, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:50:55 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900203324432532},\"3\":{\"i64\":161643},\"4\":{\"i64\":2895996669},\"10\":{\"i64\":1673401255}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$663/467463168.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor174.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:677, mt_servername:set-mt-thhmerchant-mgov-detector05.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:50:55.382\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-2, mt_level:ERROR, mt_datetime:2023-01-13 09:50:55+0800, traceId__:-8392852083123051999, es_datetime:2023-01-13 09:50:55.382, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:50:55 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900200706811658},\"3\":{\"i64\":154432},\"4\":{\"i64\":1731314827},\"10\":{\"i64\":1673401255}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$661/172610977.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor168.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:382, mt_servername:set-gh-thhmerchant-mgov-detector01.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:50:49.589\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-3, mt_level:ERROR, mt_datetime:2023-01-13 09:50:49+0800, traceId__:-2038939308609945878, es_datetime:2023-01-13 09:50:49.589, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:50:49 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900204161504403},\"3\":{\"i64\":159401},\"4\":{\"i64\":251744338},\"10\":{\"i64\":1673401249}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$663/467463168.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor174.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:589, mt_servername:set-mt-thhmerchant-mgov-detector05.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:50:46.998\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-2, mt_level:ERROR, mt_datetime:2023-01-13 09:50:46+0800, traceId__:6085791408671259236, es_datetime:2023-01-13 09:50:46.998, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:50:46 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900192987145354},\"3\":{\"i64\":149564},\"4\":{\"i64\":509120722},\"10\":{\"i64\":1673401246}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$660/916808727.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor130.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:998, mt_servername:set-gh-thhmerchant-mgov-detector02.mt\n" +
                "adjust\t\n" +
                "2023-01-13 09:50:46.134\n" +
                "mt_appkey:com.sankuai.thhmerchant.mgov.detector, mt_thread:mafka-consume-thread#thh.mgov.detector.order_check.delay_action_prod#thh.mgov.detector.order_check_processor-0, mt_level:ERROR, mt_datetime:2023-01-13 09:50:46+0800, traceId__:-3253943588250506968, es_datetime:2023-01-13 09:50:46.134, mt_logger_name:com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer, es_timestamp:2023/01/13 09:50:46 +0800, message: consume message error! message:{\"1\":{\"rec\":{\"1\":{\"str\":\"order_fulfillment_delay_fine_check_chaidan_nov11shopping2022\"},\"2\":{\"i64\":278900201072578425},\"3\":{\"i64\":164573},\"4\":{\"i64\":2228030363},\"10\":{\"i64\":1673401246}}}}\n" +
                "java.lang.NullPointerException\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.lambda$checkAndReportIfNeeded$11(DelayActionProcessor.java:156)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor$$Lambda$663/467463168.accept(Unknown Source)\n" +
                "\tat java.util.Optional.ifPresent(Optional.java:159)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.delay.DelayActionProcessor.checkAndReportIfNeeded(DelayActionProcessor.java:129)\n" +
                "\tat com.meituan.thh.merchant.governance.detector.message.consumer.DelayActionConsumer.receive(DelayActionConsumer.java:40)\n" +
                "\tat sun.reflect.GeneratedMethodAccessor174.invoke(Unknown Source)\n" +
                "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.lang.reflect.Method.invoke(Method.java:497)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.doInvoke(MdpListenerWrapper.java:138)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.MdpListenerWrapper.onRecvMessage(MdpListenerWrapper.java:63)\n" +
                "\tat com.meituan.mdp.boot.starter.mafka.consumer.AbstractMdpListener.recvMessage(AbstractMdpListener.java:53)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.consumerCallBack(DefaultConsumerProcessor.java:1275)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:1141)\n" +
                "\tat com.meituan.mafka.client.consumer.DefaultConsumerProcessor$MafkaParallarWork.call(DefaultConsumerProcessor.java:975)\n" +
                "\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n" +
                "\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n" +
                "\tat java.lang.Thread.run(Thread.java:745)\n" +
                ", mt_millisecond:134, mt_servername:set-mt-thhmerchant-mgov-detector05.mt";

        String[] list =  origin.split("java.lang.NullPointerException");
        List<String> messagesList = new LinkedList<>();
        for (int i=0; i<list.length-1; i++){
            int start = list[i].indexOf("consume message error! message:");
            int end = list[i].indexOf("}}}}");
            String message = list[i].substring(start+31, end+4);
            System.out.println(message);
            messagesList.add(message);
        }

        for (String item : messagesList){
//            System.out.println(item);
        }

    }





    public static int getSum(int[] nums){
        int result =0;

        int left = 0;
        int right = nums.length -1;
        int leftMax = 0, rightMax = 0;
        while (left <right){
            leftMax = Math.max(nums[left], leftMax);
            rightMax = Math.max(nums[right], rightMax);
            if(leftMax<rightMax){
                result = result + (leftMax-nums[left]);
                left++;
            }else {
                result = result + (rightMax-nums[right]);
                right--;
            }
        }

        return result;
    }

}
