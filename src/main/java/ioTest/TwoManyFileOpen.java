package ioTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by jialei.zou on 2019/4/3 .
 */
public class TwoManyFileOpen {

    public static void main(String[] args) {

        File file = null;
        for (int i =0; i<30000; i++){
            if(i%10000 ==0 ){
                System.gc();
            }
            try {
                file = new File("/Users/zou/Documents/zoujialei/zxEnterpriseUserId.csv");
                // new FileReader里面有fd = new FileDescriptor();
                // 最后会报错： Too many open files in system
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
