package leetcode.Algorithms._1_100._4_MedianOfTwoSortedArrays;

/**
 * Created by jialei.zou on 2018/12/11 .
 * 题目要求是算法复杂度是o(log(m+n)),我的实现没有达到，但是题目难度较大，暂时没看，后面看
 * ref:https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
 */
public class MedianOfTwoSortedArrays {

    /**
     * 自己采取的方式是合并两个有序连表，之后取平均值
     * 1. j++这种直接在一行代码里面用的，和平时习惯不一样，第一次用要注意；
     * 2. /2和/2.0分别得到int值和double值：
     * (merge[totalLength/2]+merge[(totalLength-1)/2])/2.0;
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length+nums2.length;
        int[] merge = new int[totalLength];
        int i=0,j=0,k=0;
        while (i<nums1.length &&j<nums2.length){
            if(nums2[j]>nums1[i]){
                merge[k++] = nums1[i++];
            }else {
                merge[k++] = nums2[j++];
            }
        }
        if(i==(nums1.length)){
            for (;j<nums2.length;){
                merge[k++] = nums2[j++];
            }
        }else {
            for (;i<nums1.length;){
                merge[k++] = nums1[i++];
            }
        }
        return (merge[totalLength/2]+merge[(totalLength-1)/2])/2.0;
    }

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));

    }
}
