package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SchoolDataListener extends AnalysisEventListener<CategoryInfo> {

    List<CategoryInfo> categoryInfos = new ArrayList<>();

    //需要传参时，通过构造方法传进来
    public SchoolDataListener() {
    }

    /**
     * 每解析一行数据都会进行调用
     */
    @Override
    public void invoke(CategoryInfo data, AnalysisContext context) {
        //一般数据量大的时候应该分批处理，防止数据全部加载到内存，导致OOM。
        categoryInfos.add(data);
    }

    /**
     * 数据全部解析完成时调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("数据读取完毕:");
        String sql = "update thh_property_group_audit set category_4_name = '{categoryNewName}' where category_4_id = {categoryId} and category_4_name = '{categoryOldName}';";
        for (CategoryInfo item : categoryInfos){
            String categoryNewName = item.getCategoryAdjust().split("调整为")[1].replace("【","").replace("】","");
            System.out.println(sql.replace("{categoryNewName}", categoryNewName).
                    replace("{categoryId}", item.getCategory4Id())
                    .replace("{categoryOldName}", item.getCategory4Name()));
        }
    }

    /**
     * 每解析一行表头都会进行调用
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头:");
        headMap.forEach((k, v) -> System.out.println(v));
        System.out.println();
    }
}
