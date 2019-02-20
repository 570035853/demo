package normalTest.retry;

/**
 * Created by jialei.zou on 2018/9/5 .
 * 从ThreadPoolExecutor的addWorker看到的此关键字
 * retry 控制的是其后面跟着的for，单纯的continue及break只是控制当前一层
 */
public class Retry {

    public static void main(String[] args) {
        retry1();


    }

    public static void retry(){
        retry:
        for (int i = 0; i<10; i++){
            if(i == 5){
//                continue retry; //print: 0 1 2 3 4 6 7 8 9
                break retry; //print: 0 1 2 3 4
            }
            System.out.println("i value: "+i);
        }
    }

    public static void retry1(){
        test:
        for (int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(j == 2){
                    /**
                     i =0 j=0
                     i =0 j=1
                     i =1 j=0
                     i =1 j=1
                     i =2 j=0
                     i =2 j=1
                     i =3 j=0
                     i =3 j=1
                     i =4 j=0
                     i =4 j=1
                     i =5 j=0
                     i =5 j=1
                     i =6 j=0
                     i =6 j=1
                     i =7 j=0
                     i =7 j=1
                     i =8 j=0
                     i =8 j=1
                     i =9 j=0
                     i =9 j=1
                     */
                    continue test;
//                    break retry1; //print: i =0 j=0  \n  i =0 j=1
                }
                System.out.println("i ="+i+" j="+j);
            }
        }
    }
}
