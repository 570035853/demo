package interview;

/**
 * Created by zoujialei on 2018/6/26.
 * ref: https://tech.imdada.cn/2017/06/30/daojia-redis/
 */
public class Redis {

    public static void main(String[] args) {

        for(int i = 0; i<5 ;i++){
            try {
                writeToRedis();
                break;
            }catch (Exception e){
                System.out.println("");
                if(i==4){
                    sendToMq();
                }
            }
        }
    }

    private static void writeToRedis(){
        System.out.println("wirte to redis");
    }

    private static void sendToMq(){
        System.out.println("send to mq");
    }


}
