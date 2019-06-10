package leetcode.Algorithms._901_1000._922_SortArrayByParityII;

/**
 * Created by jialei.zou on 2019/5/29 .
 ref:
 https://leetcode.com/problems/sort-array-by-parity-ii/

 Given an array A of non-negative integers, half of the integers in A are odd,
 and half of the integers are even.

 Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [4,2,5,7]
 Output: [4,5,2,7]
 Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


 Note:

 2 <= A.length <= 20000
 A.length % 2 == 0
 0 <= A[i] <= 1000


 *
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        if(A==null || A.length<2){
            return A;
        }
        int len = A.length;
        int even =0; int odd = 1;
        while (even<len && odd<len){
            while (even < A.length && A[even]%2 == 0){
                even = even+2;
            }
            while (odd < A.length && A[odd]%2 == 1){
                odd = odd+2;
            }
            if(even<len && odd<len){
                swap(A, even, odd);
                even = even+2;
                odd = odd+2;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j){
        int tem = A[j];
        A[j] = A[i];
        A[i] = tem;
    }

    public static void main(String[] args) {
        SortArrayByParityII parityII = new SortArrayByParityII();
        int[] result = parityII.sortArrayByParityII(new int[]{4,2,5,7});
        for (int item: result){
            System.out.printf(item+",");
        }
    }
}
