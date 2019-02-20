package normalTest.ocrDeal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jialei.zou on 2018/10/24 .
 * ref: http://unirest.io/java.html
 */
public class OcrDeal {

    private static Set<String> getUserId(String file) throws FileNotFoundException, IOException{
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Set<String> userIds = new HashSet<>();
        String str;

        while ((str= bufferedReader.readLine()) != null){
            userIds.add(str);
        }
        bufferedReader.close();
        reader.close();
        return userIds;
    }


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
            Set<String> userIds = getUserId("/Users/zou/Documents/ls/userIds.txt");
            for (String userId: userIds){
                String result = postRequestStr("http://10.10.52.180:17117/admin/insertUserPayForbidRecordOrUpdate/"+userId);
                System.out.println(userId+":"+result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
