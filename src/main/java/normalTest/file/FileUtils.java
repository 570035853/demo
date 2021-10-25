package normalTest.file;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {

    public static List<String> getString(String sourceFile) throws FileNotFoundException, IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile),"UTF-8"));
        List<String> result = new LinkedList<>();
        String str;

        while ((str= bufferedReader.readLine()) != null){
            result.add(str);
        }
        bufferedReader.close();
        return result;
    }

    public static void save(List<String> data, String destFile) throws IOException{
        if(data == null || data.size()<1){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String item: data){
            stringBuilder.append(item+"\n");
        }
        File file = new File(destFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(stringBuilder.toString());
        writer.flush();
        writer.close();

    }

}
