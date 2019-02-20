package leetcode.Algorithms._1_100._46_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/12/22 .
 */
public class Permutations {

    /**
     * 更多的是练习，因为之前有过字符串的全排列，一样的问题
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length<1){
            return result;
        }
        recursive(result, 0, nums.length, nums);
        return result;
    }

    private static void recursive(List<List<Integer>> result, int from, int to, int[] num){
        if(from == to){
            result.add(getList(num));
            return;
        }
        //既然和每一个都换，就是换到最后一个，到最后一个，实际的条件就是（int i= from; i<to;i++）
        for (int i= from; i<to;i++){
            swap(num, from, i);
            recursive(result, from+1, to, num);
            swap(num, from, i);
        }
    }

    private static void swap(int[] num, int i, int j){
        int tem = num[i];
        num[i] = num[j];
        num[j] = tem;
    }

    private static List<Integer> getList(int[] num){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<num.length;i++){
            list.add(num[i]);
        }
        return list;
    }

    private static void printAll(List<List<Integer>> list){
        System.out.println("[");
        for (List<Integer> innerList: list){
            System.out.print(" [");
            for (Integer item: innerList){
                System.out.print(item.intValue());
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[]{1,2,3});
        List<List<Integer>> ref1Result = ref1Subsets(new int[]{1,2,3});
        printAll(result);
        printAll(ref1Result);
    }


    public static List<List<Integer>> ref1Subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
