package algorithm.leetcode.Algorithms._601_700._695_MaxAreaOfIsland;

import java.util.*;

/**
 * Created by jialei.zou on 2019/3/17 .
 ref:
 https://leetcode.com/problems/max-area-of-island/


 Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

 Example 1:

 [
 [0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]
 ]
 Given the above grid, return 6. Note the answer is not 11, because the island must
 be connected 4-directionally.
 Example 2:

 [[0,0,0,0,0,0,0,0]]
 Given the above grid, return 0.
 Note: The length of each dimension in the given grid does not exceed 50.

 */
public class MaxAreaOfIsland {

    /**
     * Runtime: 296 ms, faster than 5.00% of Java online submissions for Max Area of Island.
       Memory Usage: 60.3 MB, less than 5.01% of Java online submissions for Max Area of Island.

        想到的方式的问题是效率太低，查看其它人的解题方法
     1. ref里面，分别有DFS和BFS，DFS和BFS非常重要的一点就是就是visited的控制，遍历过的就不再遍历，这个也和人的思考过程是一样的

     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                findAndReplace(grid, i, j);
                max = Math.max(max, countAndRedo(grid));
            }
        }
        return max;
    }

    private void findAndReplace(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(grid[i][j] == 1){
            grid[i][j] = -1;
        } else {
            return;
        }
        if(i>0){
            findAndReplace(grid, i-1, j);
        }
        if(i<m-1){
            findAndReplace(grid, i+1, j);
        }
        if(j>0){
            findAndReplace(grid, i, j-1);
        }
        if(j<n-1){
            findAndReplace(grid, i, j+1);
        }
    }

    private int countAndRedo(int[][] grid){
        int sum = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(grid[i][j]==-1){
                    sum+=1;
                    grid[i][j]=1;
                }
            }
        }
        return sum;
    }


    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0){
            return 0;
        }
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                + area(r, c-1) + area(r, c+1));
    }

    public int refDFSMaxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }


    public int refDFSAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        //用于控制上线左右的遍历
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int ans = 0;
        for (int r0 = 0; r0 < grid.length; r0++) {
            for (int c0 = 0; c0 < grid[0].length; c0++) {
                if (grid[r0][c0] == 1 && !seen[r0][c0]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[]{r0, c0});
                    seen[r0][c0] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int r = node[0], c = node[1];
                        shape++;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if ((0 <= nr) && (nr < grid.length) &&
                                    (0 <= nc) && (nc < grid[0].length) &&
                                    (grid[nr][nc] == 1) && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }


    /**
     * ref:
     * https://leetcode.com/problems/max-area-of-island/discuss/108533/JavaC%2B%2B-Straightforward-dfs-solution
     * @param grid
     * @return
     */
    public int refBFS2MaxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int[][] dir = {{0,0,1,-1},{1,-1,0,0}};
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                List<Integer> iList = new ArrayList<>(),jList = new ArrayList<>();
                if(grid[i][j] != 1) {
                    continue;
                }
                int count = 1;
                grid[i][j] = 2;
                iList.add(i);jList.add(j);
                //队列控制
                while(!iList.isEmpty()){
                    List<Integer> nextiList = new ArrayList<>(),nextjList = new ArrayList<>();

                    for(int k = 0; k< iList.size();k++){
                        for(int m = 0;m<dir[0].length;m++){
                            int y = iList.get(k) + dir[0][m],x = jList.get(k) + dir[1][m];
                            if(y>=0 && y< grid.length && x >= 0 && x < grid[0].length && grid[y][x] == 1){
                                grid[y][x] = 2;
                                count++;
                                nextiList.add(y);
                                nextjList.add(x);
                            }
                        }
                    }
                    iList = nextiList;
                    jList = nextjList;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }

    /**
     * 如下暂时未经验证
     * @param grid
     * @return
     */
    public int selfLearnRefBFS2MaxAreaOfIsland(int[][] grid){
        int max =0;
        //上下左右顺序
        int r[] = new int[]{0, 0, -1, 1};
        int c[] = new int[]{1, -1, 0, 0};
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1 && visited[i][j]!=1){
                    int curMax = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    while (!queue.isEmpty()){
                        int[] cur = queue.poll();
                        curMax +=1;
                        for (int k = 0; k<4; k++){
                            int curR = cur[0]+r[k];
                            int curC = cur[1]+c[k];
                            if(curR>=0 && curR<grid.length && curC>=0 && curC<grid[0].length
                                    && grid[curR][curC]==1 && visited[curR][curC]!=1){
                                queue.offer(new int[]{curR, curC});
                                visited[curR][curC] = 1;
                            }
                        }
                        max = Math.max(max, curMax);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland island = new MaxAreaOfIsland();
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int result = island.maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
