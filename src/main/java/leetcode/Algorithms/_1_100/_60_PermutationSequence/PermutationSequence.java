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

    public String getPermutation(int n, int k) {
        List<Integer> result = helper(1, n, new LinkedList<>(), k);
        String resultStr = "";
        if(result == null){
            return resultStr;
        }else {
            for (Integer item: result){
                resultStr = resultStr + item;
            }
        }
        return resultStr;

    }

    private List<Integer> helper(int start, int end, List<Integer> list, int k){
        if(start>end){
            count++;
            if(count == k){
                return list;
            }
            return null;
        }

        for (int i=1; i<=9; i++){
            list.add(i);
            List<Integer> innerResult = helper(start+1, end, list, k);
            if(null != innerResult){
                return innerResult;
            }
            list.remove(list.size()-1);
        }

        return null;
    }

    public static void main(String[] args) {
        PermutationSequence  permutationSequence = new PermutationSequence();
        String result = permutationSequence.getPermutation(3, 3);
        System.out.println(result);
    }

}
