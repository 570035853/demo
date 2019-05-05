package interview;

/**
 * Created by jialei.zou on 2019/4/29 .
 */
public class FindMiddleLargest {

    /**
     * 一个数组元素先上升后下降，找到中间的最大值
     * @param nums
     * @return
     */
    public int findMiddleLargest(int nums[]){
        if(nums == null || nums.length<3){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while (high-low>=2){
            int mid = low+(high-low)/2;
            if(nums[mid-1]<nums[mid]&& nums[mid]>nums[mid+1]){
                return nums[mid];
            }else if(nums[mid-1]<nums[mid]&& nums[mid]<nums[mid+1]){
                low = mid;
            }else {
                high = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMiddleLargest middleLargest = new FindMiddleLargest();
        System.out.println(middleLargest.findMiddleLargest(new int[]{1,2,1}));
        System.out.println(middleLargest.findMiddleLargest(new int[]{1,2,3}));
        System.out.println(middleLargest.findMiddleLargest(new int[]{1,2,3,2}));
        System.out.println(middleLargest.findMiddleLargest(new int[]{1,2,3,2,1}));
        System.out.println(middleLargest.findMiddleLargest(new int[]{1,2,3,4,5}));
        System.out.println(middleLargest.findMiddleLargest(new int[]{1,2,3,4,5,1}));




    }
}
