package multiThread.multiThreadTask.completableFuture;

/**
 * @author zoujialei02
 * @date 2021/11/3
 */
public class CaculateWeight {

    public static Integer getManWeight(){
        System.out.println("getManWeight start");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("getManWeight end");
        return 100;
    }

    public static Integer getWomenWeight(){
        System.out.println("getWomenWeight start");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("getWomenWeight end");
        return 120;
    }

    public static Integer getTotalWeight(int manWeight, int womenWeight){
        System.out.println("getTotalWeight start");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("getTotalWeight end");
//        throw new RuntimeException("getTotalWeight exception");
        return manWeight + womenWeight;
    }


}
