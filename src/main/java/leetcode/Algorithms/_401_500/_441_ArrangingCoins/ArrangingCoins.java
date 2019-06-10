package leetcode.Algorithms._401_500._441_ArrangingCoins;

/**
 * Created by jialei.zou on 2019/5/30 .
 ref:
 https://leetcode.com/problems/arranging-coins/

 You have a total of n coins that you want to form in a staircase shape,
 where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.

 Example 2:
 n = 8
 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int result = 0;
        //大于result才能进行下一步，初始化result为0更合理一点
        while (n>result){
            n=n-(result+1);
            result++;
        }
        return result;
    }


    public int arrangeCoinsBinSearch(int n) {
        if(n==0){
            return 0;
        }
        int low = 1; int high = n;
        while (low<=high){
            int mid = (high-low)/2+low;
            double result = 0.5*mid*mid+0.5*mid;
            if(result>n){
                high = mid-1;
            }else { //<=
                if(mid == n || 0.5*(mid+1)*(mid+1)+0.5*(mid+1)>n){
                    return mid;
                }
                low=mid+1;
            }
        }
        return -1;
    }

    /**
     n = (x + 1) * x / 2
     x² + x = 2n
     x² + x + 1/4 - 1/4 = 2n
     (x + 1/2)² = 2n + 1 / 4
     (x + 1/2)² = (8n + 1) / 4
     x + 1/2 = sqrt(8n + 1) / 2
     x = (sqrt(8n + 1) / 2) - (1 / 2)
     x = (sqrt(8n + 1) - 1) / 2
     * @param n
     * @return
     */
    public int arrangeCoinsRef2(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }

    public static void main(String[] args) {
        ArrangingCoins coins = new ArrangingCoins();
        System.out.println(coins.arrangeCoins(1));
        System.out.println(coins.arrangeCoins(2));
        System.out.println(coins.arrangeCoins(3));

        System.out.println(coins.arrangeCoinsBinSearch(1));
        System.out.println(coins.arrangeCoinsBinSearch(2));
        System.out.println(coins.arrangeCoinsBinSearch(3));
        System.out.println(coins.arrangeCoinsBinSearch(5));



    }
}
