package ioTest;

import java.io.*;

/**
 * Created by zoujialei on 17/11/27.
 */
public class IOTest {

    public static void main(String[] args) {
        try {
            String filePathIn = "/Users/admin/Documents/ls/CoreEnterpriseMonthlyDataReport.ftl";
            InputStream inputStream = new FileInputStream(filePathIn);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            File file = new File(filePathIn);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);




            byte[] content = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(content);

            bufferedInputStream.close();



            String filePathOut = "/Users/admin/Documents/ls/out.doc";
            FileOutputStream fileOutputStream = new FileOutputStream(filePathOut);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            String filePathOutBak = "/Users/admin/Documents/ls/out1.doc";
            FileOutputStream fileOutputStreamBak = new FileOutputStream(filePathOutBak);
            BufferedOutputStream bufferedOutputStreamBak = new BufferedOutputStream(fileOutputStreamBak);


            bufferedOutputStream.write(content);
            bufferedOutputStreamBak.write(content);

            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            bufferedOutputStreamBak.flush();
            bufferedOutputStreamBak.close();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
