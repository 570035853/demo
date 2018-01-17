/*
 * This Class demonstrates use of annotations using reflection.
 *
 * demo ref:  http://www.importnew.com/10294.html(讲解的很不错)
 * @author Yashwant Golecha (ygolecha@gmail.com)
 * @version 1.0
 * 关键点说明：
    1. 是什么：可以理解为元数据，即描述数据的数据
    2. 产生背景：产生的原因是：之前都是XML松耦合来描述数据，实际部分代码的编写，紧耦合更为合适；两者优势：xml配置一些参数较为合适。
    3. 如何使用：JAVA的标注，需要有不同的用户，例如对于@Override，JVM是一个用户，对于@Autowired，spring是一个用户，我们自己也可以通过getAnnotation方式，在代码中使用；
    4. Annotation支持的数据类型：基本类型、String及枚举类型；
    5. demo见：git->annotationTest.
 */

package AnnotationTest;

import java.lang.reflect.Method;

public class TodoReport {
    public TodoReport() {
        super();
    }

    public static void main(String[] args) {
        getTodoReportForBusinessLogic();
    }

    /**
     * This method iterates through all messages of BusinessLogic class and fetches annotations defined on each of them.
     * After that it displays the information from annotation accordingly.
     */
    private static void getTodoReportForBusinessLogic() {
        
        Class businessLogicClass = BusinessLogic.class;
        for(Method method : businessLogicClass.getMethods()) {
            Todo todoAnnotation = (Todo)method.getAnnotation(Todo.class);
            if(todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
                System.out.println(" --------------------------- ");
            }
        }
    }
}
