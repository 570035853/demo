package algorithm.SwordOffer;

import java.util.Stack;

/**
 * Created by jialei.zou on 2019/6/29 .
 */
public class Num_31 {

    /**
     * 关键点：
     * 1. 第一次进入的时候，如果不相等就想栈里面放，直到找到相等的
     * 2. 如果栈顶元素等于目标元素，则逐个出栈
     * @param source
     * @param target
     * @return
     */
    public boolean isPopInOrder(int[] source, int[] target){
        if(source == null || target == null){
            return false;
        }
        if(source.length != target.length){
            return false;
        }

        int i=0, j=0, len = source.length;
        Stack<Integer> stack = new Stack<>();
        while (i<len && j<len){

            while (source[i] != target[j]){
                stack.push(source[i++]);
            }
            i++;
            j++;
            while (!stack.isEmpty() && j<len && stack.peek() == target[j]){
                stack.pop();
                j++;
            }
        }


        return i==len && j==len;

    }

    public static void main(String[] args) {
        Num_31 num_31 = new Num_31();
        System.out.println(num_31.isPopInOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(num_31.isPopInOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,1,2}));

    }
}
