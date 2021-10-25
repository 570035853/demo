package normalTest.ocrDeal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import normalTest.file.FileUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/10/24 .
 * ref: http://unirest.io/java.html
 */
public class OcrDeal {


    public static String postRequestStr(String requestUri){
        try {
            HttpResponse<String> bookResponse = Unirest.get(requestUri).asObject(String.class);
            String result = bookResponse.getBody();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            List<String> userIds = FileUtils.getString("/Users/zou/Documents/FHJR/bx/线上用户处理/24个16岁以下用户.txt");
            int i=0;
            for (String userId: userIds){
                String result = postRequestStr("http://10.10.52.191:16768/api/v3/user/"+userId+ "/asset?version=3.0");
                JSONObject jsonObject = JSON.parseObject(result);
                JSONObject data = JSON.parseObject(jsonObject.getString("data"));
                System.out.println(userId+":"+ data.getString("regularAmount"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
