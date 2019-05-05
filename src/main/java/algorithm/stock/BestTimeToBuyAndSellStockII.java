package algorithm.stock;

/**
 * Created by jialei.zou on 2019/3/4 .
 122
 ref:
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions
 as you like (i.e., buy one and sell one share of the stock multiple times).

 Note: You may not engage in multiple transactions at the same time (i.e., you must
 sell the stock before you buy again).

 Example 1:

 Input: [7,1,5,3,6,4]
 Output: 7
 Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 Example 2:

 Input: [1,2,3,4,5]
 Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 engaging multiple transactions at the same time. You must sell before buying again.
 Example 3:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length<2){
            return 0;
        }
        int i = 0;
        int j = i+1;
        int profit = 0;
        while (j<prices.length){
            if(prices[i]>=prices[j]){
                i++;
                j++;
            }else {
                while (j<prices.length){
                    //注意点：到了末尾的逻辑的确和不到末尾不一样，要区别对待下
                    if(j==prices.length-1){
                        profit = profit + prices[j]-prices[i];
                        return profit;
                    }
                    if(prices[j+1]>=prices[j]){
                        j++;
                    }else {
                        profit = profit + prices[j]-prices[i];
                        i=j+1;
                        j=i+1;
                        break;
                    }
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
