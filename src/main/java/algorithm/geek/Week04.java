package algorithm.geek;

/**
 * Created by jialei.zou on 2019/5/8 .
 */
public class Week04 {
    /**




     Trie树
     简单：https://leetcode-cn.com/problems/longest-word-in-dictionary/  720
     中等：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
     困难：https://leetcode-cn.com/problems/word-search-ii/

     分治算法
     简单：https://leetcode-cn.com/problems/majority-element/
     中等：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
     困难：https://leetcode-cn.com/problems/burst-balloons/

     贪心算法
     简单：https://leetcode-cn.com/problems/assign-cookies/
     中等：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     困难：https://leetcode-cn.com/problems/ipo/

     回溯算法
     简单：https://leetcode-cn.com/problems/letter-case-permutation/  784
     中等：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/ 211
     困难：https://leetcode-cn.com/problems/n-queens/

     动态规划
     简单：https://leetcode-cn.com/problems/min-cost-climbing-stairs/ 746
     中等：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/ 309
     困难：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/  188
     困难：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/ 123
     困难：https://leetcode-cn.com/problems/edit-distance/ 72


     本周做的题目里面比较有代表性的题目有2类，
     第一个是买卖股票（对应题目188，309，123）
     第二个是字符串的匹配（对应的问题是720，211）

     对于买卖股票，主要用到的算法是动态规划，其中最具有代表性188题目，在给定的时间内进行不定次数的买卖，
     该题目花费时间比较长和没有想到的地方有2点
     1. 需要构建买卖两个数组，买卖两者之间相互依赖而有交替进行而又互为依赖
     2. 如何对两个数组进行初始化，第一次买，第二次买，第n次买等，买获得的收益在index为0的位置都初始化为-prices
     可以理解为初始化最差的情况，因为实际对于第二次买及后续的第n次买卖，理论上并可能在0的位置进行第二次买卖，初始化为最差的
     情况，后续在进行迭代的时候，按照状态转移方程的，一定会对其进行优化，因为状态转移每一步的选取都是最优的。

     对于字符串的匹配，本次设计的数据结构主要是trie树，之前虽然看过，但由于没有写过代码，印象不够深刻，做题目之前，又重新看了课程
     关键点是数据结构的定义

     另外，编程技巧上面，做题过程中，出现了二次没有深度复制的情况，导致预期数值和自己想的不一样，之后要尤为主意

     */
}
