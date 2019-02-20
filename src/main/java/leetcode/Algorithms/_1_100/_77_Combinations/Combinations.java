package leetcode.Algorithms._1_100._77_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/12/24 .
 * ref: https://leetcode.com/problems/combinations/
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 *
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursive(n, 0, k, temp, result);
        return result;
    }

    /**
     * 如下的程序是有问题的，正确的程序见ref1
     * 自己想到了是一个递归，数学方式也有了概要了解，规律的抽象以及边界的定义没有搞定
     * @param n
     * @param start
     * @param k
     * @param temp
     * @param result
     */
    private static void recursive(int n, int start, int k, List<Integer> temp, List<List<Integer>> result){
        if(start == k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i<k; i++){
            for (int j = start; j<n-k+start+1;j++){
                temp.add(j+1);
                recursive(n, start+1, k, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> result = combine(4, 2);
        List<List<Integer>> result = ref1Combine(4, 2);

        for (List<Integer> innerList: result){
            for (Integer item: innerList){
                System.out.printf(item+",");
            }
            System.out.println();
        }
        System.out.println(result.size());

        List<List<Integer>> result1 = ref1Combine(4, 3);

        for (List<Integer> innerList: result1){
            for (Integer item: innerList){
                System.out.printf(item+",");
            }
            System.out.println();
        }
        System.out.println(result1.size());
    }

    public static List<List<Integer>> ref1Combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        ref1Combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    /**
     1,2,3,4
     1,2,4,
     1,3,4,
     2,3,4,
     3,4
     4

     最后截出来：
     1,2,3,
     1,2,4,
     1,3,4,
     2,3,4,

     1.整体想法是组合只要是递增着涨，就不会有重复
     2.for+start用户控制遍历的范围，k用户控制还需要多少个元素就加入到result中

     * @param combs
     * @param comb
     * @param start
     * @param n
     * @param k
     */
    public static void ref1Combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k ==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            ref1Combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}
