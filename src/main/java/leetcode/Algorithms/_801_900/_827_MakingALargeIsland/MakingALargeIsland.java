package leetcode.Algorithms._801_900._827_MakingALargeIsland;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by jialei.zou on 2019/6/13 .
 en:
 https://leetcode.com/problems/making-a-large-island/
 cn:
 https://leetcode-cn.com/problems/making-a-large-island/

 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。

 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）

 示例 1:

 输入: [[1, 0], [0, 1]]
 输出: 3
 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 示例 2:

 输入: [[1, 1], [1, 0]]
 输出: 4
 解释: 将一格0变成1，岛屿的面积扩大为 4。
 示例 3:

 输入: [[1, 1], [1, 1]]
 输出: 4
 解释: 没有0可以让我们变成1，面积依然为 4。
 说明:

 1 <= grid.length = grid[0].length <= 50
 0 <= grid[i][j] <= 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/making-a-large-island
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MakingALargeIsland {

    /**
     * 直接看的ref:
     * https://leetcode.com/problems/making-a-large-island/discuss/127256/DFS-JAVA-AC-CONCISE-SOLUTION
     * 最笨的方法，自己基本也想到了
     * 时间复杂度n3
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        int max = -1, m = grid.length, n = grid[0].length;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    max = Math.max(max,dfs(i,j,grid,new boolean[m][n]));
                    if(max == m*n) {return max;}
                    grid[i][j] = 0;
                }
            }
        }
        return max != -1?max:m*n;
    }
    private int dfs(int i, int j, int[][] grid,boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0||visited[i][j]) {return 0;}
        visited[i][j] = true;
        int result = 1+dfs(i-1,j,grid,visited)+dfs(i+1,j,grid,visited)+dfs(i,j+1,grid,visited)+dfs(i,j-1,grid,visited);
        return result;
    }

    /**********************ref2*********************/

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int[][] grid;
    int N;

    /**
     * 买看懂，继续看 todo
     * @param grid
     * @return
     */
    public int largestIslandRef2(int[][] grid) {
        this.grid = grid;
        N = grid.length;

        int index = 2;
        int[] area = new int[N*N + 2];
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c){
                if (grid[r][c] == 1){
                    area[index] = dfs(r, c, index++);
                }
            }
        }

        int ans = 0;
        for (int x: area) {
            ans = Math.max(ans, x);
        }
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c){
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet();
                    for (Integer move : neighbors(r, c)){
                        if (grid[move / N][move % N] > 1){
                            seen.add(grid[move / N][move % N]);
                        }
                    }

                    int bns = 1;
                    for (int i : seen) {
                        bns += area[i];
                    }
                    ans = Math.max(ans, bns);
                }
            }
        }
        return ans;
    }

    public int dfs(int r, int c, int index) {
        int ans = 1;
        grid[r][c] = index;
        for (Integer move: neighbors(r, c)) {
            if (grid[move / N][move % N] == 1) {
                grid[move / N][move % N] = index;
                ans += dfs(move / N, move % N, index);
            }
        }

        return ans;
    }

    public List<Integer> neighbors(int r, int c) {
        List<Integer> ans = new ArrayList();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N){
                ans.add(nr * N + nc);
            }
        }

        return ans;
    }


}
