package wordTest;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.nio.*;
import java.util.HashMap;

/**
 * Created by zoujialei on 17/11/27.
 */
public class WordExportTest {

    public static void main(String[] args) {

        try {
            /** 初始化配置文件 **/
            Configuration configuration = new Configuration();
            /** 设置编码 **/
            configuration.setDefaultEncoding("utf-8");
            /** 我的ftl文件是放在D盘的**/
            String fileDirectory = "/Users/admin/Documents/ls/";
            /** 加载文件 **/
            configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
            /** 加载模板 **/
            Template template = configuration.getTemplate("CoreEnterpriseMonthlyDataReport.ftl");
            /** 准备数据 **/
            HashMap dataMap = new HashMap();

            /** 表格数据 studentList和freemarker标签要对应**/

            /** 指定输出word文件的路径 **/
            String outFilePath = "/Users/admin/Documents/ls/myFreeMarker.doc";
            File docFile = new File(outFilePath);
            FileOutputStream fos = new FileOutputStream(docFile);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            template.process(dataMap, out);

            if (out != null) {
                out.close();
            }
        } catch (Exception e) {
            //do nothing
            e.printStackTrace();
        }




    }


}
