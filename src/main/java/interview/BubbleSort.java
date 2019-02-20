package interview;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 1, 9, 4,5};
        int[] sortedArray = bubbleSort(arr);
        for (int i = 0; i<sortedArray.length; i++){
            System.out.println(sortedArray[i]);
        }
    }

    public static int[] bubbleSort(int[] array){
        int length = array.length;

        for (int i = 0; i<length-1; i++){
            for(int j = 0; j<length-i-1; j++){
                if(array[j+1]<array[j]){
                    int tem = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tem;
                }
            }
        }
        return array;
    }


}
