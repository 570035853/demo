package algorithm.stock;

/**
 * Created by jialei.zou on 2019/3/4 .
 ref:
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction
 (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Note that you cannot sell a stock before you buy one.

 Example 1:

 Input: [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Not 7-1 = 6, as selling price needs to be larger than buying price.
 Example 2:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 自己想到的动态规划，收到了接雨水方法影像，可以看下ref1，里面的就是边走边看
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length<2){
            return 0;
        }
        int[] leftLowPrice = new int[prices.length];
        leftLowPrice[0] = prices[0];
        for(int i=1; i<leftLowPrice.length; i++){
            leftLowPrice[i] = Math.min(prices[i], leftLowPrice[i-1]);
        }
        int max = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]-leftLowPrice[i]>max){
                max = prices[i]-leftLowPrice[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();
        System.out.println(sellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(sellStock.maxProfit(new int[]{7,6,4,3,1}));

    }


    /**
     * ref1中空间使用上只用了o(1)
     * @param prices
     * @return
     */
    public int ref1MaxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice){
                minprice = prices[i];
            }
            else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 常规思维2
     * @param prices
     * @return
     */
    public int ref2MaxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit){
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

}
