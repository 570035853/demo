package leetcode.Algorithms._901_1000._905_SortArrayByParity;

/**
 * Created by jialei.zou on 2019/5/29 .
 * ref:
 * https://leetcode.com/problems/sort-array-by-parity/

 Given an array A of non-negative integers, return an array consisting of all
 the even elements of A, followed by all the odd elements of A.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [3,1,2,4]
 Output: [2,4,3,1]
 The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


 Note:

 1 <= A.length <= 5000
 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    /**
     * 1. 刚开始没有加low<A.length的判断，写成了while (A[low]%2!=1)
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        if(A==null || A.length<2){
            return A;
        }
        int low = 0; int high = A.length-1;
        while (low<high){
            while (low<A.length&&A[low]%2!=1){
                low++;
            }
            while (high>=0&&A[high]%2 != 0){
                high--;
            }
            if(low<high){
                swap(A, low, high);
                low++;
                high--;
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
        SortArrayByParity parity = new SortArrayByParity();
        int[] result = parity.sortArrayByParity(new int[]{3,1,2,4});
        for (int item: result){
            System.out.printf(item+",");
        }

    }
}
