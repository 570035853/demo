package leetcode.Algorithms._1_100._60_PermutationSequence;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/3/3 .
 ref:
 https://leetcode.com/problems/permutation-sequence/

 The set [1,2,3,...,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note:

 Given n will be between 1 and 9 inclusive.
 Given k will be between 1 and n! inclusive.
 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"

 */
public class PermutationSequence {


    private int count=0;
    private String result = "";

    /**
     * 20190523 第一次回顾 写出来了，但是用时比较长，关键在swap那个函数保证有序性用了比较长的时间
     * 后续看下ref： todo
     * https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
     * 关注
     * 1. 如何控制K
     * 2. 如何保证的顺序，类似自己写的swap方法
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int num[] = new int[n];
        for (int i=1;i<=n;i++){
            num[i-1]= i;
        }
        helper(0, n-1, num, k);
        return result;

    }

    private void helper(int start, int end, int[] nums, int k){
        if(start==end){
            count++;
            print(count, nums);
            if(count == k){
                for (int item: nums){
                    result = result+item;
                }
            }
            return ;
        }

        for (int i=start; i<=end; i++){
            if(count<=k){
                swap(nums, start, i, true);
                helper(start+1, end, nums, k);
                swap(nums, start, i, false);
            }
        }

    }

    /**
     * 这个函数比较关键，在交换的同时，进行其他相关元素的整体左侧移动或者右侧移动
     * 例如
     * 1 2 3 4 5 交换4到1的位置实际过程是  4 123 5  （123实际整体右侧移动了）
     * 相应的换回来的 时候，123整体左侧移动了，这样为了保证题目要求的顺序
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums,int i,int j, boolean moveRight){
        if(moveRight){
            int tem = nums[j];
            for (int m=j; m>i; m--){
                nums[m] = nums[m-1];
            }
            nums[i]=tem;
        }else {//整体左移动
            int tem = nums[i];
            for (int m=i; m<j; m++){
                nums[m]= nums[m+1];
            }
            nums[j] = tem;
        }

    }

    private void print(int count, int[] nums){
        System.out.print("count:"+count+"  :");
        for (int item: nums){
            System.out.print(item);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        PermutationSequence  permutationSequence = new PermutationSequence();
        String result = permutationSequence.getPermutation(4, 9);
        System.out.println(result);
    }

}
