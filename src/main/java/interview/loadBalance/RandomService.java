package interview.loadBalance;

/**
 * Created by jialei.zou on 2019/5/13 .
 */
public class RandomService {

    /**
     *
     random的主要方式是替换原有确定pos的部分，由严格轮训改为了如下

     Random random = new Random();
     serverName = ipList.get(random.nextInt(ipList.size()));
     */
}
