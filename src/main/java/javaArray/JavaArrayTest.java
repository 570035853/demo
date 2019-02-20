package javaArray;

/**
 * Created by jialei.zou on 2018/11/8 .
 * 1. []在变量前后都可以
 * 2. 分为静态初始化和动态初始化，静态是声明和赋值是在一起的，动态是两者分开的。
 */
public class JavaArrayTest {

    public static void main(String[] args) {

        int[] sum0 = {1, 2, 3};
        int sum1[] = {1, 2, 3};
        int sum3[] = new int[3];
        for (int i = 0; i<sum3.length; i++){
            sum3[i] = i;
        }
        int[] sum4 ={}; //创建了一个空对象
        int[] sum5 =null;
    }


}
