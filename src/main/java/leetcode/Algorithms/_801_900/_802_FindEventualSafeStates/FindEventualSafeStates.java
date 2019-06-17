package leetcode.Algorithms._801_900._802_FindEventualSafeStates;


import java.util.*;

/**
 * Created by jialei.zou on 2019/5/5 .
 * ref:
 * https://leetcode-cn.com/problems/find-eventual-safe-states/
 题目有图: 图在同目录下

 在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边),
 我们停止。

 现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K,
 无论选择从哪里开始行走, 我们走了不到 K 步后必能停止在一个终点。

 哪些节点最终是安全的？ 结果返回一个有序的数组。

 该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数.
 图以以下的形式给出: graph[i] 是节点 j 的一个列表，满足 (i, j) 是图的一条有向边。

 示例：
 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 输出：[2,4,5,6]
 这里是上图的示意图。

 Illustration of graph

 提示：

 graph 节点数不超过 10000.
 图的边数不会超过 32000.
 每个 graph[i] 被排序为不同的整数列表， 在区间 [0, graph.length - 1] 中选取。


 比较经典的题目了

 *
 */
public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new LinkedList<>();
        if(graph == null || graph.length<1){
            return result;
        }
        for (int i=0; i<graph.length; i++){
            Set<Integer> canReachList = new HashSet<>();
            if(!dfsAdjust(canReachList, i, graph)){
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 是否会形成环
     * @param canReachList
     * @param cur
     * @param graph
     * @return
     */
    private boolean dfs(Set<Integer> canReachList, int cur, int[][] graph){
        int[] toList = graph[cur];
        for (int item: toList){
            if(canReachList.contains(cur)){
                return true;
            }
            canReachList.add(cur);
            if(dfs(canReachList, item, graph)){
                return true;
            }
        }
        return false;
    }


    /**
     * 如下方式如果不考虑运行时间，理论上是可行的，会一条路走到头，考虑到时间的话，就会超时了，
     * 所以要用ref2中的dfs方式：走过的路就不要在重复了
     * @param canReachList
     * @param cur
     * @param graph
     * @return
     */
    private boolean dfsAdjust(Set<Integer> canReachList, int cur, int[][] graph){
        int[] toList = graph[cur];
        for (int item: toList){
            if(canReachList.contains(cur)){
                return true;
            }
            canReachList.add(cur);
            if(dfsAdjust(canReachList, item, graph)){
                return true;
            }
            canReachList.remove(cur);
        }
        return false;
    }


    /**
     * 此题图：每一个节点都维护这两个set，一个set是自己指向其他人的节点graph，
     * 另外一个是指向这个节点的
     *
     * 题目的思路是，先把没有指向外面的节点找到，这些节点肯定是终点，后续把指向这些终点的边都删除掉，
     * 如果删掉之后，这些节点也就变成了终点，循环往复，剩下的都是走不出去的
     *
     * https://leetcode.com/articles/find-eventual-safe-states/
     * @param G
     * @return
     */
    public List<Integer> eventualSafeNodesRef1(int[][] G) {
        int N = G.length;
        boolean[] safe = new boolean[N];

        //指向其他节点
        List<Set<Integer>> graph = new ArrayList<>();
        //其他节点指向
        List<Set<Integer>> rgraph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            graph.add(new HashSet());
            rgraph.add(new HashSet());
        }

        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < N; ++i) {
            if (G[i].length == 0){
                queue.offer(i);
            }
            for (int j: G[i]) {
                graph.get(i).add(j);
                rgraph.get(j).add(i);
            }
        }

        while (!queue.isEmpty()) {
            int j = queue.poll();
            safe[j] = true;
            for (int i: rgraph.get(j)) {
                graph.get(i).remove(j);
                if (graph.get(i).isEmpty()){
                    queue.offer(i);
                }
            }
        }

        List<Integer> ans = new ArrayList();
        for (int i = 0; i < N; ++i) {
            if (safe[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    /**
     *
     * https://leetcode.com/articles/find-eventual-safe-states/
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodesRef2(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i){
            if (dfs(i, color, graph)){
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * 该方法是判断是否是终点类型的数据
     *
     * 自己写如下方式
     *  dfs(Set<Integer> canReachList, int cur, int[][] graph)
     * 问题在：
     * 并没有区分开终点和非终点类型的数据，这也就是color为啥要有三个状态的原因（不同的节点都指向最终节点就会出错）
     *
     * 总体思路就是
     * 如果被访问的节点是非终点数据，那么肯定是非终点数据
     * 初始化为非终点数据，递归查看其能到达的所有点，如果有非终点数据，则返回false，并保持非终点数据的标志
     * 找了能到达的所有数据，发现依旧为非终点数据，则该节点为终点类型的数据，返回true
     *
     * 关于Colors
     * 0是初始值
     * 所有到达不了终点的节点，都标记为GRAY，并返回false
     * 如果到达了终点，就标记为BLACK 2
     *
     *

     还有另外一个ref
     https://www.cnblogs.com/daoluanxiaozi/archive/2012/05/18/2507212.html
     WHITE 未访问顶点
     GRAY 一条深度搜索路径上的顶点，即被发现时
     BLACK 此顶点的邻接顶点被全部访问完之后——结束访问次顶点
     * @param node
     * @param color
     * @param graph
     * @return
     */
    // colors: WHITE 0, GRAY 1, BLACK 2;
    // 0：是初始化，  1：过程中的用1表示，最终确定有环的也是用1表示，  2：最终节点
    //
    // 判断是否是终点类型的数据
    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0){
            return color[node] == 2;
        }

        color[node] = 1;
        for (int nei: graph[node]) {
            if (color[node] == 2){
                continue;
            }
            if (color[nei] == 1 || !dfs(nei, color, graph)){
                return false;
            }
            /**
            上述步骤可以写为：
             if (color[nei] == 1){
                  return false;
             }
             if(color[nei] == 0){
                 if(!dfs(nei, color, graph)){
                    return false;
                  }
             }
             */
        }

        color[node] = 2;
        return true;
    }


    public static void main(String[] args) {
        FindEventualSafeStates safeStates = new FindEventualSafeStates();
        System.out.println(safeStates.eventualSafeNodes(new int[][]{
                {1,2},{2,3},{5},{0},{5},{},{}
        })); //2, 4, 5, 6

        System.out.println(safeStates.eventualSafeNodes(new int[][]{
                {1,2,3,4},{1,2},{3,4},{0,4},{}
        }));


        System.out.println(safeStates.eventualSafeNodes(new int[][]{
                {},{0,2,3,4},{3},{4},{}
        }));  // [0,1,2,3,4]   我的错误输出是  0 2 3 4

        HashMap map = new HashMap();

    }



}
