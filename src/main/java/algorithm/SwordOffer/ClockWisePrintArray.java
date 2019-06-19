package algorithm.SwordOffer;

import common.ArraysUtils;

/**
 * Created by jialei.zou on 2019/6/19 .
 */
public class ClockWisePrintArray {

    /**
     * 1. 注意不一定是n*n，可能是n*m
     * 2. 可以理解为逐行消去，四个参数控制int upR=0, downR=r-1, leftC=0, rightC = c-1;
     * @param nums
     * @return
     */
    public int[] getClockWiseResult(int[][] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int r=nums.length, c=nums[0].length, cur=0;
        int[] result = new int[r*c];
        int upR=0, downR=r-1, leftC=0, rightC = c-1;
        while (true){
            if(leftC>rightC || upR>downR){
                break;
            }
            for (int i=leftC; i<=rightC; i++){
                result[cur++] = nums[upR][i];
            }
            upR++;

            if(leftC>rightC || upR>downR){
                break;
            }
            for (int i=upR; i<=downR; i++){
                result[cur++] = nums[i][rightC];
            }
            rightC--;

            if(leftC>rightC || upR>downR){
                break;
            }
            for (int i = rightC; i>= leftC; i--){
                result[cur++] = nums[downR][i];
            }
            downR--;

            if(leftC>rightC || upR>downR){
                break;
            }
            for (int i=downR; i>=upR; i--){
                result[cur++] = nums[i][leftC];
            }
            leftC++;
        }
        return result;
    }

    public static void main(String[] args) {
        ClockWisePrintArray clockWisePrintArray = new ClockWisePrintArray();
        ArraysUtils.printIntArray(clockWisePrintArray.getClockWiseResult(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10,11,12},
                {13,14,15,16}
        }));
        ArraysUtils.printIntArray(clockWisePrintArray.getClockWiseResult(new int[][]{
                {1, 2, 3, 4},
        }));
        ArraysUtils.printIntArray(clockWisePrintArray.getClockWiseResult(new int[][]{
                {1, 3, 4},
                {5, 6, 8},
                {9, 11,12},
                {13,15,16}
        }));

        ArraysUtils.printIntArray(clockWisePrintArray.getClockWiseResult(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10,11,12},
        }));
        ArraysUtils.printIntArray(clockWisePrintArray.getClockWiseResult(new int[][]{
                {1},
        }));
    }
}
