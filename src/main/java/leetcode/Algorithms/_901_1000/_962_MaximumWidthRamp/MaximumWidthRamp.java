package leetcode.Algorithms._901_1000._962_MaximumWidthRamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jialei.zou on 2019/5/30 .
 ref:
 https://leetcode.com/problems/maximum-width-ramp/
 Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].
 The width of such a ramp is j - i.

 Find the maximum width of a ramp in A.  If one doesn't exist, return 0.



 Example 1:

 Input: [6,0,8,2,1,5]
 Output: 4
 Explanation:
 The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
 Example 2:

 Input: [9,8,1,0,1,9,4,0,4,1]
 Output: 7
 Explanation:
 The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.


 Note:

 2 <= A.length <= 50000
 0 <= A[i] <= 50000
 */
public class MaximumWidthRamp {

    /**
     * 思路是
     * 因为要寻找最大距离，肯定要找到右侧最大的，如果右侧的更大，左侧的小，则直接抛弃左侧的；
     * 保存一个有序的递增序列，并用map保存其在原数组当中的位置，最后使用二分查找，找到第一个大于等于的元素
     * @param A
     * @return
     */
    public int maxWidthRamp(int[] A) {
        int result = 0;
        if(A == null || A.length<2){
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = new int[A.length];
        sorted[0] = A[A.length-1];
        map.put(A[A.length-1],A.length-1);
        int sortedLength = 0;

        for (int i=A.length-2; i>=0; i--){
            int longest = findIndex(map, sortedLength, sorted, A[i]);
            if(longest!=-1){
                result = Math.max(result, longest-i);
            }
            if(A[i]>sorted[sortedLength]){
                map.put(A[i], i);
                sortedLength++;
                sorted[sortedLength]=A[i];
            }
        }
        return result;

    }

    /**
     * 第一次提交的时候，二分查找while (low<=hign)括号里面没有写=，不应该
     * @param map
     * @param end
     * @param sorted
     * @param target
     * @return
     */
    private int findIndex(Map<Integer, Integer> map, int end, int[] sorted, int target){
        if(end==0){
            return sorted[0]>=target?map.get(sorted[0]):-1;
        }
        int low = 0;
        int hign = end;
        int index=-1;
        while (low<=hign){
            int mid = (low+hign)/2;
            if(sorted[mid]<target){
                low = mid+1;
            }else {//>=
                if(mid==0 || sorted[mid-1]<target){
                    index = mid;
                    break;
                }else {
                    hign = mid-1;
                }
            }
        }
        if(index != -1){
            return map.get(sorted[index]);
        }
        return -1;
    }


    /**
     * https://leetcode.com/articles/maximum-width-ramp/
     * 官方给的另外一个答案
     * todo 后续在看
     * @param A
     * @return
     */
    public int maxWidthRampRef1(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i){
            B[i] = i;
        }

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }


    public static void main(String[] args) {
        MaximumWidthRamp ramp = new MaximumWidthRamp();
//        System.out.println(ramp.maxWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println(ramp.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));

    }


}
