package Json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jialei.zou on 2018/8/1 .
 */
public class JSONtest {

    public static void main(String[] args) {
        Map<String, Object> callBackNull  = null ;
        String dataNull = JSON.toJSONString(callBackNull);
        //data: null
        System.out.println(dataNull);

        Map<String, Object> callBackNew = new HashMap<>();
        String dataNew = JSON.toJSONString(callBackNew);
        System.out.println(dataNew);
        System.out.println("dataNew size"+callBackNew.size());

        Map<String, Object> callBackName = new HashMap<>();
        callBackName.put("name","wang");
        String dataCallBackName = JSON.toJSONString(callBackName);
        System.out.println(dataCallBackName);
        System.out.println("callBackName size"+callBackName.size());

        String empty = "";

        Map<String, Object> nullJson = JSON.parseObject(null, Map.class);

        Map<String, Object> callBackNullFromJson = JSON.parseObject(dataNull, Map.class);

        Map<String, Object> callBackNewFromJson = JSON.parseObject(dataNew, Map.class);

        Map<String, Object> callBackNameFromJson = JSON.parseObject(dataCallBackName, Map.class);


        String desc = "评价得{num}金豆".replace("{num}", "12");
        System.out.println(desc);
        String desc1 = "评价得金豆{num}".replace("{num}", "");
        System.out.println(desc1);

    }
}
