package javaOverride;

import java.io.File;
import java.io.IOException;

/**
 * Created by zoujialei on 2018/5/21.
 */
public class Father {

    protected int getAge(){
        return 50;
    }


    public String getName(String file) throws IOException{
        File nameList = new File(file);
        if(nameList == null){
            throw new IOException("nameList not exist");
        }
        return "";
    }
}
