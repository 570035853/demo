package interview.AddWithoutForIf;

public class AddWithoutForIf {

    private static int sum = 0;

    AddWithoutForIf(int n){
        sum = sum + n;
        System.out.println("sum:"+sum);
    }

    public static boolean add(int n) {
        sum += n;
        // 返回值用boolean,利用&&短路,避免了if判断
        return n != 1 && add(n - 1);
    }

    public static void main(String[] args) {
        add(100);
        System.out.println(AddWithoutForIf.sum);
    }

}
