package algorithm.leetcode.Algorithms.twoSum;

/**
 * Created by jialei.zou on 2018/11/15 .
 */
public class TwoTestTest {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        printResult(new int[]{});
        int[] nums = new int[]{2, 4, 5 ,6 ,7};
        int[] myResult = twoSum.myTwoSum(nums, 9);
        int[] bruteForce = twoSum.twoSumBruteForce(nums, 13);
        int[] twoPathhashResult = twoSum.twoPathHashTable(nums, 14);
        int[] onePathhashResult = twoSum.onePathHashTable(nums, 14);
        printResult(myResult);
        printResult(bruteForce);
        printResult(twoPathhashResult);
        printResult(onePathhashResult);

    }

    public static void printResult(int[] result){
        System.out.println("print result:");
        for (int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
