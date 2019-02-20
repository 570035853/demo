package lambdaTest;

/**
 * Created by zoujialei on 2018/4/24.
 */
public class FunctionalProgrammingTest {



    static Long add(Long a, Long b){
        return a+b;
    }

    static Long multiply(Long a, Long b){
        return a*b;
    }

    static Long subtract(Long a, Long b){
        return a-b;
    }

    public static void main(String[] args) {
        Long result = subtract(multiply(add(1L,2L), 3L), 4L);
        System.out.println("result:" + result);
    }
}
