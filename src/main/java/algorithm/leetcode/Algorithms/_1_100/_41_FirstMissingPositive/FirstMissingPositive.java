package algorithm.leetcode.Algorithms._1_100._41_FirstMissingPositive;

/**
 * Created by jialei.zou on 2019/2/13 .
 ref:
 https://leetcode.com/problems/first-missing-positive/
 Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:
 Input: [1,2,0]
 Output: 3

 Example 2:
 Input: [3,4,-1,1]
 Output: 2

 Example 3:
 Input: [7,8,9,11,12]
 Output: 1
 Note:

 Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    /**
     * 想到的是new 一个com[length+1]的数组[1,2,3,4,5...,length+1]
     * 如果nums存在com中的数据，则将com[]中相应位置数字置为0
     * for一次com，然后输出第一个不为0的数字
     * 存在的问题是，并非constant extra space
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        int com[] = new int[nums.length+1];
        for (int i=0;i<com.length;i++){
            com[i] = i+1;
        }
        for (int i = 0; i<nums.length; i++){
            if(nums[i]>0 && nums[i]<= nums.length){
                com[nums[i]-1] =0;
            }
        }
        for (int i=0; i<com.length; i++){
            if(com[i]>0){
                return com[i];
            }
        }
        return -1;
    }


    /**

     Numbers greater then n can be ignored because the missing integer must be in the range 1..n+1

     If each cell in the array were to contain positive integers only,
     we can use the negative of the stored number as a flag to mark something
     (in this case the flag indicates this index was found in some cell of the array)
     * @param nums
     * @return
     */
    public int refFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..n+1

        /**
         * 参照一个对照数组[1, 2, 3, 4, 5, 6,.., n]
         * 如果nums[num]在1-n的方位内，nums[num]转为负数，表明对应位置数字出现在数组中过
         * Math.abs(nums[i])将原值还原，诸如[2, 4, 1, 15, 15]的数组转换为[-2, -4, 1, 5, 5], 最终参照数组中的3没有出现过，
         * 故最终结果为3
         *
         */
        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }

        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));

    }

}
