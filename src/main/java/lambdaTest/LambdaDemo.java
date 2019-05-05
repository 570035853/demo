package lambdaTest;

/**
 * Created by jialei.zou on 2019/5/5 .
 * ref:
 * https://www.runoob.com/java/java8-lambda-expressions.html
 *
 *
 */
public class LambdaDemo {


    public static void main(String[] args) {
        MathOperation add = (a, b)->a+b;
        MathOperation subtraction = (int a, int b)->a-b;
        MathOperation multiplication = (a, b) ->{return 1*b;};
        System.out.println(add.operation(1, 2));

        GreetingMsg greetingMsg = greeting -> "hello "+greeting;
        System.out.println(greetingMsg.msg("google"));
        System.out.println(greetingMsg.msg("alibaba"));


        LambdaDemo lambdaDemo = new LambdaDemo();

        //operate的操作还是在本类内，所以访问权限没问题
        System.out.println("10 + 5 = " + lambdaDemo.operate(10, 5, add));
        System.out.println("10 - 5 = " + lambdaDemo.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambdaDemo.operate(10, 5, multiplication));

    }




    interface MathOperation{
        int operation(int a, int b);
    }

    interface GreetingMsg{
        String msg(String greeting);
    }

    private int operate(int a, int b, MathOperation operation){
        return operation.operation(a,b);
    }

}
