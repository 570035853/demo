package classLoader;

public class MyNumber {
    public static MyNumber myNumber=new MyNumber(2.8);
    private static double value=20;
    public double currentvalue;

    public MyNumber(double number){
        currentvalue=value-number;
    }


    public static void main(String[] args) {

        MyNumber myNumber=new MyNumber(2.8);
        double result3=myNumber.currentvalue;
        System.out.println("result1----:"+result3);
        //17.2

        double result1= MyNumber.myNumber.currentvalue;
        System.out.println("result1----:"+result1);
        //-2.8

        double result2= MyNumber.myNumber.currentvalue;
        System.out.println("result2----:"+result2);
        //-2.8



    }
}
