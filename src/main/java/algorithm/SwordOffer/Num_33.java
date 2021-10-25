package algorithm.SwordOffer;

/**
 * Created by jialei.zou on 2019/6/29 .
 */
public class Num_33 {

    public boolean verify(int nums[], int from, int to){
        if(from>=to){
            return true;
        }

        int i = from;
        for (; i<to-1; i++){
            if(nums[i]>nums[to-1]){
                break;
            }
        }

        for (int j=i; j<to-1; j++ ){
            if(nums[j]<nums[to-1]){
                return false;
            }
        }
        return verify(nums, from, i-1)&&verify(nums, i, to-1);
    }

    public static void main(String[] args) {
        Num_33 num_33 = new Num_33();
        System.out.println(num_33.verify(new int[]{5, 7, 6, 9, 11, 10, 8}, 0, 7));
        System.out.println(num_33.verify(new int[]{7,4,6,5}, 0, 4));

    }
}
