package algorithm.leetcode.Algorithms._1_100._4_MedianOfTwoSortedArrays;

/**
 * Created by jialei.zou on 2018/12/11 .
 * 题目要求是算法复杂度是o(log(m+n)),我的实现没有达到，但是题目难度较大，暂时没看，后面看
 * ref:https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

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


    /**
     * 看ref的讲解思路比较好：
     * https://leetcode.com/articles/median-of-two-sorted-arrays/
     * 如左侧图片所示，该问题的解决思路是将两个数据分为了两部分，其他的关键点又
     * 1. i和j所在位置的数字属于右侧部分
     * 2. 如果两个数组之和是奇数，左侧部分的数量比右侧部分多一个，所以取返回值，直接取左侧部分的最大就可以；
     * 3. 当i=0时，说明小的数组全部都属于右侧部分，当i=m的时候，说明小的数组全部属于左侧部分，详细可见图
     * 4. 按照二分数组查找即可
     *
     *
     *
     *   详细的阐述可见ref
     * @param A
     * @param B
     * @return
     */
    public double refFindMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public double practice(int[] A, int[] B) {
        return 0.0;
    }

    public static void main(String[] args) {

        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println(median.refFindMedianSortedArrays(new int[]{1}, new int[]{7}));

        System.out.println(median.refFindMedianSortedArrays(new int[]{1,2}, new int[]{7,8,9,10,11}));

    }
}
