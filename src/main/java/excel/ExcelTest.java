package excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;

/**
 * @author zoujialei02
 * @date 2021/9/2
 */
public class ExcelTest {

    public static void main(String[] args) {

        for (int i =0 ; i<20; i++){
            importExcel();
        }
    }

    public static void importExcel() {
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read("/Users/zoujialei/Documents/项目开发/团好货/类目调整0827/团好货类目调整汇总.xlsx", CategoryInfo.class, new SchoolDataListener()).build();
            ReadSheet readSheet = EasyExcel.readSheet(1).build();
            excelReader.read(readSheet);
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }

    public static void importExcelSimple() {
        //sheet() 默认读取第一个sheet
        EasyExcel.read("F:\\测试数据.xlsx", CategoryInfo.class, new SchoolDataListener()).sheet().doRead();
    }
}
