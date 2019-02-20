package javaImmutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/11/18 .
 * ref: http://qiusli.github.io/blog/2013/08/08/java-immutable/
 */
public final class JavaImmutable {

    private final int j = 2;
    private final int i = 1;
    private final List<String> stringList = new ArrayList<>();

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }

    public List<String> getList(){
        List<String> newStringList = new ArrayList<>();
        for (String str: stringList){
            newStringList.add(str);
        }
        return newStringList;
    }

}
