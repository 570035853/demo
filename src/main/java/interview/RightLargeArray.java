package interview;

public class RightLargeArray {

    public static void main(String[] args) {
        int[] array = new int[]{8, 17, 3, 5, 5, 2, 4};
        array = rightLarge(array);
        for(int i =0 ;i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    /**
     * 关键点是：用array[0]保存最大值，用array[length-1]保存i值
     * @param array
     * @return
     */
    public static int[] rightLarge(int[] array){
        if(array == null){
            return null;
        }
        if(array.length == 1){
            array[0] = -1;
            return array;
        }
        int length = array.length;
        array[0] = array[length -1];
        for (int i = length -2; i>0; i--){
            array[length-1] = array[i];
            array[i] = array[0];
            if(array[0]<array[length-1]){
                array[0] = array[length -1];
            }
        }

        array[length-1] = -1;
        return array;

    }
}
