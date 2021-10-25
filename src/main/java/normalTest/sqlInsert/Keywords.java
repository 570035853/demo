package normalTest.sqlInsert;

import normalTest.file.FileUtils;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Keywords {

    public static void getSql() throws IOException{
        String sourceFile = "/Users/zoujialei/Documents/项目开发/敏感词过滤-备注信息/keywords.txt";
        String destFile = "/Users/zoujialei/Documents/项目开发/敏感词过滤-备注信息/result.sql";
        List<String> keywords = FileUtils.getString(sourceFile);
        List<String> sqls = new LinkedList<>();
        long time = new Date().getTime()/1000;
        for (String words: keywords){
            String sql = "INSERT INTO keywords (`clean`, `type`, `status`, `modtime`) VALUES ('"+words+"', 12, 0, "+time+");";
            sqls.add(sql);
        }
        FileUtils.save(sqls, destFile);
    }

    public static void main(String[] args) throws IOException{
        getSql();
    }
}
