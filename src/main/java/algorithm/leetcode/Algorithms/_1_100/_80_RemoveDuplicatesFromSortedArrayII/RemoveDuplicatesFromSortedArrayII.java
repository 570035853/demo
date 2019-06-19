package algorithm.leetcode.Algorithms._1_100._80_RemoveDuplicatesFromSortedArrayII;

/**
 * Created by jialei.zou on 2018/12/23 .
 * ref：https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 Given a sorted array nums, remove the duplicates in-place such that duplicates appeared
 at most twice and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array
 in-place with O(1) extra memory.

 Example 1:

 Given nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

 It doesn't matter what you leave beyond the returned length.
 Example 2:

 Given nums = [0,0,1,1,1,1,2,3,3],

 Your function should return length = 7, with the first seven elements of nums being
 modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

 It doesn't matter what values are set beyond the returned length.
 Clarification:

 Confused why the returned value is an integer but your answer is an array?

 Note that the input array is passed in by reference, which means modification to
 the input array will be known to the caller as well.

 Internally you can think of this:

 // nums is passed in by reference. (i.e., without making a copy)
 int len = removeDuplicates(nums);

 // any modification to nums in your function would be known by the caller.
 // using the length returned by your function, it prints the first len elements.
 for (int i = 0; i < len; i++) {
 print(nums[i]);
 }
 */
public class RemoveDuplicatesFromSortedArrayII {


    /**
     * 想到的是用第一个元素存储当前遍历的i是什么，第二个元素存储i已经出现的次数，result来记录返回值是多少，
     * 但是这样就有了i和result，形成了0(2)???
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length<=2){
            return nums.length;
        }

        if(nums[1] == nums[0]){
            nums[1] =2;
        }else {
            nums[1] =1;
            nums[0] = nums[1];
        }
        int result =2;
        for (int i=2; i<nums.length ; i++){
            if(nums[0] == nums[i]){
                if((nums[1]+1)<=2){
                    result = result+1;
                    nums[1]= nums[1]+1;
                }
            }else {
                nums[1] =1;
                nums[0] = nums[i];
                result = result+1;
            }

        }
        return result;
    }

    /**
     * 作者（思路很棒，充分利用了排序有序，只能有两个相同的规律）
     * 总体思路是：in-place的方式来原地替换原数组，举例来说如下：
     * {0,10,10,10,10,11,12,13,15,15,15,16}
     * 替换为：
     * {0,10,10,11,12,13,15,15,16}
     * 巧妙点有
     * 1. 利用了for(int n: nums)这种，遍历了数组里面的每一个元素，程序里面不用占用额外的空间
     *    所以相当于两个下表，隐含下表和显示下标i
     * 2. 开始的两个值，直接保留（i<2），隐含下标不断向后走，对于已经保存的，而且重复两次的直接忽略(n>nums[i-2])
     * @param nums
     * @return
     */
    public static int ref1RemoveDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums){
            System.out.print(n+",");
            if (i < 2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(ref1RemoveDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(ref1RemoveDuplicates(new int[]{0,10,10,10,10,11}));

    }
}
