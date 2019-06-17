package leetcode.Algorithms._801_900._815_BusRoutes;

import java.util.*;

/**
 * Created by jialei.zou on 2019/6/17 .
 ref:
 https://leetcode.com/problems/bus-routes/

 We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever.
 For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

 We start at bus stop S (initially not on a bus), and we want to go to bus stop T.
 Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

 Example:
 Input:
 routes = [[1, 2, 7], [3, 6, 7]]
 S = 1
 T = 6
 Output: 2
 Explanation:
 The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 Note:

 1 <= routes.length <= 500.
 1 <= routes[i].length <= 500.
 0 <= routes[i][j] < 10 ^ 6.

 */
public class BusRoutes {

    /**
     * 总体的思路还是要循环遍历下，使用BFS的方式
     * 使用hashmap 让每个到达点关联到可以做哪个车，之后从每个车开始，BFS的方式进行遍历，找到终点就返回
     * @param routes
     * @param S
     * @param T
     * @return
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(routes == null || routes.length == 0){
            return -1;
        }
        //漏了如下这一点，题目有点过分。。。哈哈
        if(S==T){
            return 0;
        }
        //初始化每一个停靠点 关联的公交车
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i<routes.length; i++){
            int[] list = routes[i];
            for (int j=0; j<list.length; j++){
                if(map.containsKey(list[j])){
                    map.get(list[j]).add(i);
                }else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(list[j], set);
                }
            }
        }

        if(!map.containsKey(S)){
            return -1;
        }
        //从第一个停靠点，遍历关联能到达的所有位置和能上的所有车，之后向外扩展
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(map.get(S));
        boolean visited[] = new boolean[routes.length];
        while (!queue.isEmpty()){
            int size = queue.size();
            result++;
            for (int i = 0; i<size; i++){
                Integer item = queue.poll();
                if(visited[item] == false){
                    visited[item] = true;
                    int[] canReach = routes[item];
                    for (int j=0; j<canReach.length; j++){
                        if (canReach[j] == T){
                            return result;
                        }else {
                            if(map.containsKey(canReach[j])){
                                queue.addAll(map.get(canReach[j]));
                            }
                        }
                    }
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        BusRoutes busRoutes = new BusRoutes();
        System.out.println(busRoutes.numBusesToDestination(new int[][]{
                {1, 2, 7},
                {3, 6, 7}
        }, 1, 6));
    }
}
