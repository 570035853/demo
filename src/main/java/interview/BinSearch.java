package interview;

/**
 * Created by zoujialei on 2018/6/23.
 * 参考网址：https://blog.csdn.net/lovesummerforever/article/details/24588989
 */
public class BinSearch {

    public static void main(String[] args) {
        int array[] = {1, 2, 6, 10, 15, 22, 77, 101, 109, 123};

//        System.out.println(binSearch(array, 6));
//        System.out.println(binSearch(array, 7));

        int arrayMin1[] = {3, 4, 5, 1, 2};
        int arrayMin2[] = {1, 0, 1, 1, 1};
        int arrayMin3[] = {1, 1, 1, 0, 1};

        int arrayMind7[] ={3, 5, 6 ,8 ,9,10};
        int arrayMind8[] ={6};


//        System.out.println(getMin(arrayMin1));
//        System.out.println(getMin(arrayMin2));
//        System.out.println(getMin(arrayMin3));
        System.out.println(findLastSmallerItem(arrayMind7, 7));
        System.out.println(findLastSmallerItem(arrayMind8, 7));


    }

    /**
     * 最普通的二分查找
     * @param array
     * @param key
     * @return
     */
    private static int binSearch(int array[], int key){
        int start = 0;
        int end = array.length -1;

        while (start <= end){
            int mid = (end + start)/2;
            if(array[mid] == key){
                return mid;
            }
            if(array[mid]<key){
                start = mid +1;
            }
            if(array[mid]>key){
                end = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 诸如 3 4 5 1 2 之前是有序的，后续经历了旋转，找到1所在的位置
     * 考虑特殊情况  1 3 4 5 6 7 1 1 1
     * @param array
     * @return
     */
    private static int getMin(int array[]){
        int start = 0;
        int end = array.length -1;
        while (start<=end && array[start]>=array[end]){
            int mid = (start + end)/2;
            if(array[start]<array[mid]){
                start = mid +1;
            }
            if(array[start]>array[mid]){
                end = mid -1;
            }
            if((array[start] == array[end]) && (array[start] == array[mid]) ){
                return getMin(array, start, end);
            }

        }
        return start;
    }

    /**
     * start = mid = end
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int getMin(int array[], int start, int end){
        int pos = start;
        for (int i= start + 1; start<= end; i++){
            if(array[pos]>array[i]){
                pos = i;
                break;
            }
        }
        return pos;
    }


    /**
     * 寻找最后一个小于某个数值
     * 例如  3 5 6 8 9 10  目标值 7 最后一个小于该值的数是6
     * ref: https://time.geekbang.org/column/article/42733
     * 总结：
     * 1. 二分查找的while条件判断是low<=high，<=，是为了让mid访问到最后一次比较后的位置
     *    =是为了保证如下情况 2 3,需要查找3  开始low是2, high是3, 下一次之后low和high都是3，要进来这一次
     * 2. 二分查找比较的都是mid和target的值
     * 3. <向右移动，所以<=做判断是找到最有右边的，反之>向左移动，>=做判断是找到最左边的
     * 4. 对于只有一个元素的情况，需要做边界判断，否则array[mid+1]这种条件可能会越界，所以需要增加条件mid == array.length-1
     */
    private static int findLastSmallerItem(int array[],int target){
        int low = 0;
        int high = array.length -1;
        while (low<=high){
            int mid = low +((high-low)>>1);
            if(array[mid]> target){
                high = mid-1;
            }else {
                if(mid == array.length-1 || array[mid+1]>target){
                    return array[mid];
                }else {
                    low = mid +1;
                }
            }
        }
        return -1;
    }




}
