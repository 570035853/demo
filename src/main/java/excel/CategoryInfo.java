package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zoujialei02
 * @date 2021/9/2
 */
@Data
public class CategoryInfo {

    @ExcelProperty(value = "一级类目ID")
    private String category1Id;

    @ExcelProperty(value = "一级类目")
    private String category1Name;

    @ExcelProperty(value = "二级类目ID")
    private String category2Id;

    @ExcelProperty(value = "二级类目")
    private String category2Name;

    @ExcelProperty(value = "三级类目ID")
    private String category3Id;

    @ExcelProperty(value = "三级类目")
    private String category3Name;

    @ExcelProperty(value = "四级类目ID")
    private String category4Id;

    @ExcelProperty(value = "四级类目")
    private String category4Name;

    @ExcelProperty(value = "类目状态")
    private String categoryStatus;

    @ExcelProperty(value = "季节性商品")
    private String seasonProduct;

    @ExcelProperty(value = "原因")
    private String reason;

    @ExcelProperty(value = "备注/举例")
    private String remark;

    @ExcelProperty(value = "类目变更需求")
    private String categoryAdjust;

    @ExcelProperty(value = "调整状态")
    private String adjustStatus;
}