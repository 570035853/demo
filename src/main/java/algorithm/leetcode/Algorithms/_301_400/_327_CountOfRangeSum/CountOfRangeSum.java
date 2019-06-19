package algorithm.leetcode.Algorithms._301_400._327_CountOfRangeSum;

/**
 * Created by jialei.zou on 2019/4/23 .
 */
public class CountOfRangeSum {

    /**
     * 题目还是希望复杂度在o(n2)以下，没什么思路，需要看下ref
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }
        for (int i = 0; i<nums.length; i++){
            //注意用long，不要用int
            long sum = 0;
            for (int j = i; j<nums.length; j++){
                sum = sum+nums[j];
                if(sum>=lower && sum<=upper){
                    result++;
                }
            }
        }
        return result;
    }


    public int countRangeSumref1(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i){
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {return 0;}
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) {k++;}
            while (j < end && sums[j] - sums[i] <= upper) {j++;}
            while (t < end && sums[t] < sums[i]) {cache[r++] = sums[t++];}
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }

    public static void main(String[] args) {
        CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
        System.out.println(countOfRangeSum.countRangeSum(new int[]{-2,5,-1}, -2, 2));
        Thread thread;
    }
}
