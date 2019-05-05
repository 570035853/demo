package leetcode.Algorithms._101_200._120_Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/3/3 .
 ref:
 https://leetcode.com/problems/triangle/

 Given a triangle, find the minimum path sum from top to bottom.
 Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle

 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:

 Bonus point if you are able to do this using only O(n) extra space,
 where n is the total number of rows in the triangle.


 */
public class Triangle {

    /**
     * 集合方法的使用
     * 1. list.set(index, E)的使用
     * 2. 复制一个list的所有元素到其他list？
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null){
            return 0;
        }
        List<List<Integer>> distance = new LinkedList<>();
        distance.addAll(triangle);
        distance.set(0, triangle.get(0));
        for (int i = 1; i<triangle.size(); i++){
            List<Integer> triangleList = triangle.get(i);
            List<Integer> curList = distance.get(i-1);
            List<Integer> nextList = new LinkedList<>();
            nextList.addAll(triangleList);
            nextList.set(0, curList.get(0)+triangleList.get(0));
            nextList.set(triangleList.size()-1, curList.get(curList.size()-1)+triangleList.get(triangleList.size()-1));
            for (int j=1; j<triangleList.size()-1; j++){
                nextList.set(j, Math.min(curList.get(j-1)+triangleList.get(j), curList.get(j)+triangleList.get(j)));
            }
            distance.set(i,nextList);
        }
        int min = Integer.MAX_VALUE;
        List<Integer> lastLayer = distance.get(distance.size()-1);
        for (Integer item: lastLayer){
            if(item<min){
                min = item;
            }
        }
        return min;
    }

    /**
     * ref好的地方在于思路上，实际只需要保留一层即可，所以存储上new int[triangle.size()+1];就够了
     * 另外，ref的思路是从上向下，从而解决了我之前写的时候还要单独设置index为0及末尾位置的值
     * @param triangle
     * @return
     */
    public int refMinimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> layer1 = Arrays.asList(2);
        List<Integer> layer2 = Arrays.asList(3, 4);
        List<Integer> layer3 = Arrays.asList(6, 5, 7);
        List<Integer> layer4 = Arrays.asList(4, 1, 8, 3);
        triangle.add(layer1);
        triangle.add(layer2);
        triangle.add(layer3);
        triangle.add(layer4);
        System.out.println(minimumTotal(triangle));
    }
}
