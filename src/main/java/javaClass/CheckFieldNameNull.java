package javaClass;

import org.apache.commons.lang.StringUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sun.tools.java.ClassType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * Created by jialei.zou on 2018/8/6 .
 */
public class CheckFieldNameNull {

    public static String checkFieldNameNull(Object source) throws Exception{
        Class<?> sourceClass = source.getClass();

        for (; sourceClass != Object.class; sourceClass = sourceClass.getSuperclass()){
            Field[] fields = sourceClass.getDeclaredFields();
            sourceClass.getMethods();
            for (Field field : fields){
                String getMethod;
                String filedName = field.getName();
                if(field.getType() == boolean.class){
                    getMethod = MessageFormat.format("is{0}{1}", filedName.substring(0, 1).toUpperCase(), filedName.substring(1) );
                }else {
                    getMethod = MessageFormat.format("get{0}{1}", filedName.substring(0, 1).toUpperCase(), filedName.substring(1) );
                }

                Method method = sourceClass.getDeclaredMethod(getMethod);

                Object value = method.invoke(source);
                if(value == null){
                    return filedName+"不能为空";
                }
                if(value.getClass() == String.class){
                    if(StringUtils.isEmpty(value.toString())){
                        return filedName+"不能为空";
                    }
                }

            }
        }

        return null;
    }

    public static void main(String[] args) {

//        ToBeCheck toBeCheck = new ToBeCheck();
//
//        try {
//            System.out.println(checkFieldNameNull(toBeCheck));
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        System.out.println(("3302DB49-7338-444D-A7B6-7B31BA3A4885".hashCode())/32&1);
        System.out.println(("3302DB49-7338-444D-A7B6-7B31BA3A4885".hashCode()));
        System.out.println(("3302DB49-7338-444D-A7B6-7B31BA3A4885".hashCode()/32));
        System.out.println(("3302DB49-7338-444D-A7B6-7B31BA3A4885".hashCode()>>>5));

        System.out.println(("3302DB49-7338-444D-A7B6-7B31BA3A4885".hashCode()>>>5)&1);


        System.out.println((33>>>5)&1);
        System.out.println((33/32)&1);

    }
}
