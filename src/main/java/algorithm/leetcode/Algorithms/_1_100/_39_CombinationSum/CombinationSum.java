package algorithm.leetcode.Algorithms._1_100._39_CombinationSum;

import java.util.*;

/**
 * Created by jialei.zou on 2018/12/11 .
 ref: https://leetcode.com/problems/combination-sum/
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:der

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(candidates == null || candidates.length<1){
            return result;
        }
        helper(result, new ArrayList<>(), candidates, target, 0);

        return result;

    }

    private void helper(List<List<Integer>> result, List<Integer> item,int[] candidates, int target, int pos){
        if(target == 0){
            result.add(new ArrayList<>(item));
        }else if(target>0){
            for (int i = pos; i<candidates.length; i++){
                item.add(candidates[i]);
                helper(result, item, candidates, target-candidates[i], i);
                item.remove(item.size()-1);
            }
        }else { //target<0
            //do nothing
        }
    }

    /**
     * 以上是自己的练习
     */

    /**
     * 1. candidates的子数组
     * 2. 每一个list如何产生和记录的控制
     * @param result
     * @param item
     * @param candidates
     * @param target
     */
    public void combinationRe(List<List<Integer>> result, List<Integer> item, int position, int[] candidates, int target ){
        if(target<0 ||(position == candidates.length-1)){
            return ;
        }
        int num = target/candidates[position];
        for (int i = position; i<=num; i++ ){
            target = target - candidates[position]*num;
            if(target>0){
                item.add(candidates[position]);
                combinationRe(result, item,i, candidates, target);

            }else if(target == 0){
                result.add(new ArrayList<>(item));
                break;
            }
        }
        return;
    }


    public static List<List<Integer>> refCombinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum(result,new ArrayList<Integer>(),candidates,target,0);
        return result;
    }

    /**
     * 总体思路为：{2, 3, 6 ,9} target为12这种
     * 从位置为第一的开始，看看加一个2以及后面的3、6、9，能否搞定（子问题，target-2），如果不能搞定，去掉这个2，看后面的3，6，9(也是子问题)；以此类推，重复该
     * @param result
     * @param cur
     * @param candidates
     * @param target
     * @param start
     */
    public static void combinationSum(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target,int start) {
        if (target > 0) {
            for (int i = start;i < candidates.length;i++) { // not using the condition "target >= candidates[i]"
                cur.add(candidates[i]);
                combinationSum(result, cur, candidates, target-candidates[i],i);
                cur.remove(cur.size() - 1);  //注意：删除的是指定位置元素，并不是全部元素
            }
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }
    }


    public static void main(String[] args) {
//        refCombinationSum(new int[]{2, 3}, 7);
//        permutation(new char[]{'a','b','c'}, 0,2);

        CombinationSum combinationSum = new CombinationSum();

        List<List<Integer>> result = combinationSum.combinationSum(new int[]{2, 3}, 7);
        System.out.println();


    }


    /**
     * 如下的全排列也是相同思想
     * abcde这种 第一个元素可以是任何一个，所以所有元素都和第一个交换一便，然后第一个+后面的各种全排列（子问题）
     * @param s
     * @param from
     * @param to
     */
    public static void permutation(char[] s,int from,int to) {
//        if(to <= 1){
//            return;
//        }
        if(from == to) {
            System.out.println(s);
        } else {
            for(int i=from; i<=to; i++) {
                swap(s,i,from); //交换前缀，使其产生下一个前缀
                permutation(s, from+1, to);
                swap(s,from,i); //将前缀换回，继续做上一个前缀的排列
            }
        }
    }
    public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }







}
