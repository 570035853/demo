package javaInheritance;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.beans.Transient;

/**
 * @author zoujialei02
 * @date 2022/11/17
 */
@Data
public class Son extends Father{

    private String name;

    @JSONField(serialize = false)
    private String cloth;
}
