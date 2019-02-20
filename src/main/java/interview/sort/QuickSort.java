package interview.sort;

import java.util.Random;

public class QuickSort {

    private Random random = new Random();

    /**
     * pos用于标记要找到的位置
     * @param array
     * @param start
     * @param end
     * @return
     */
    public int partition(int[]array, int start, int end){
        int pos = start;
        for (int i = start; start<end; start++){
            if(array[i] < array[end]){
                pos ++;
                if((pos-1)!= i){
                    swap(array, i, pos);
                }
            }
        }
        swap(array, pos, end);
        return pos;
    }

    private void swap(int[] array, int i, int j){
        int tem = array[j];
        array[i] = array[j];
        array[j] = tem;
    }
}
