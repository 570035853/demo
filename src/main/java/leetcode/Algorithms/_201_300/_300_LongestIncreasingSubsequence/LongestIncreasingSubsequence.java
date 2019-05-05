package leetcode.Algorithms._201_300._300_LongestIncreasingSubsequence;

/**
 * Created by jialei.zou on 2019/3/24 .
 ref:
 https://leetcode.com/problems/longest-increasing-subsequence/


 Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Note:

 There may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.
 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    /**
     * 如下方式提交通过
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        if(nums == null || nums.length <1){
            return result;
        }
        //todo 下面这句之前没补充，会在如下情况报错：输入[0],输出会为0，因为无法进入循环
        result = 1;
        int dp[] = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            dp[i] = 1;
        }
        for (int i = 1; i< nums.length; i++){
            for (int j = 0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }

    /**
     * 如下的想法还是比较微妙的
     * 如果对于输入[4, 9, 15, 8, 7, 21]
     * 在dp里面依次是
     * [4]
     * [4 9]
     * [4 9 15]
     * [4 8 15]
     * [4 7 15]
     * [4 7 15 21]
     * 最终结果是4
     * @param nums
     * @return
     */
    public int learnRefLengthOfLIS(int[] nums){
        int result = 0;
        if(nums == null || nums.length <1){
            return result;
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int curLargestIndex = 0;
        for (int i = 1; i<nums.length; i++){
            int pos = binSearch(nums[i], 0, curLargestIndex, dp);
            dp[pos] = nums[i];
            if(pos == curLargestIndex +1){
                curLargestIndex +=1;
            }
        }
        return curLargestIndex+1;
    }

    /**
     * 找到dp里面第一个大于value值的位置，没有则返回end+1
     * @param value
     * @param start
     * @param end
     * @param dp
     * @return
     */
    private int binSearch(int value, int start, int end, int[] dp){
        //注意： 此表示没有找到比目标值大的，则返回下一个需要存放的位置，测试后调整，原本不存在返回-1，但是允许输入[-2, -1]
        int pos = end + 1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(dp[mid] < value){
                start = mid + 1;
            }else {
                if(mid == 0 || dp[mid-1]<value){
                    return mid;
                }else {
                    end = mid -1;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
//        System.out.println(test.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(test.learnRefLengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(test.learnRefLengthOfLIS(new int[]{1, 2, 3}));
        System.out.println(test.learnRefLengthOfLIS(new int[]{-2, -1}));
    }



}
