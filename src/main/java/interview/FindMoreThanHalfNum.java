package interview;

public class FindMoreThanHalfNum {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 2,2};

        int result = getMoreThanHalfNum(array);
        System.out.println(result);
    }

    private static int getMoreThanHalfNum(int array[]){
        if(array == null || array.length<3){
            return -1;
        }
        int result = array[0];
        int size = 1;
        for(int i = 1; i<array.length ; i++){
            if(result == array[i]){
                size ++;
            }else {
                size --;
            }
            if(size == 0){
                result = array[i];
                size ++;
            }
        }
        return result;
    }
}
