package leetcode.Algorithms._1_100._78_SubSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jialei.zou on 2019/1/6 .
 Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 */
public class Subsets {

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        permutation(result, item, from +1, to, nums);
//    }

    /**
     * 如下是错误的答案，自己整体思路还是不清楚，对于递归
     * @param result
     * @param item
     * @param from
     * @param to
     * @param nums
     */
    private void permutation(List<List<Integer>> result, List<Integer> item, int from, int to, int[] nums){
        if(from == to){
            result.add(new ArrayList<>(item));
        }
        permutation(result, item, from +1, to, nums);
        item.add(nums[from]);
        permutation(result, item, from +1, to, nums);

    }

    public static List<List<Integer>> ref1Subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    /**
     * 问题：
     * 1. list.add(new ArrayList<>(tempList));
     * 为什么不是把里面有的所有位数都遍历完了，才打印，而是边访问，边打印？
     * 总体上来说：add是增加元素的地方，remove是减少元素的地方
     * 例如 对于1234的情况
     * 1 2 开始后，后面正向是经历一次+3 +4
     * 不会出现 1 2 空 空  这种情况，所以不能等到最后，才打印
     *
     * @param list
     * @param tempList
     * @param nums
     * @param start
     */
    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = ref1Subsets(new int[]{1, 2, 3, 4});
        for (List<Integer> innerList: result){
            for (Integer item: innerList){
                System.out.printf(item+",");
            }
            System.out.println();
        }
    }


}
