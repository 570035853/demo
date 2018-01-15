package enumTest;

/**
 * Created by zoujialei on 18/1/9.
 * https://www.w3schools.in/java-tutorial/enumeration/
 * 上述网址介绍的不错，包括背景及Java自己枚举类型特性
 重点如下：
 Values() and valuesOf() methods
 All enumerations automatically contain two predefined methods: values() and valuesOf(). The general forms of these statements are:

 public static enum-type[ ] values()
 public static enum-types valuesOf (string str)
 The values() method returns an array that contains a list of the enumeration constants and
 the valueOf() method returns the enumeration constant whose values corresponds to the string passed in str.
 *
 * 所以比较经典的使用enum的方式如下，定义enum类的构造方法，然后，进行类型的枚举（根据定义的构造方法）
 *
 *
 */
public enum BankEnum {
    JTYH("jtyh"),
    JSYH("jsyh"),
    PFYH("pfyh"),
    GDYH("gdyh"),
    ;

    String desc;
    BankEnum(String desc){

    }

    public static void main(String[] args) {
        for (BankEnum item : BankEnum.values()){
            System.out.println(item);
        }
        BankEnum itemLowerCase;
        BankEnum itemUpperCase;
        itemLowerCase = BankEnum.valueOf("JTYH");
        itemUpperCase = BankEnum.valueOf("PFYH");
        System.out.println(itemLowerCase);
        System.out.println(itemUpperCase);
    }
}
