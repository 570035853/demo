package algorithm.others;



import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/6/20 .
 */
public class MazeStep {

    int minStep;


    public int getMinStopDFS(int[][] maze){
        minStep = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        dfs(maze, visited, 0, 0, 0);
        return 0;
    }



    /**
     * dfs可以保证能最终达到终点，但是没法保证是最短路径，举例如下（所以最短路径就是要用BFS）
     * 按照下，右，上的方式遍历：
     *
     * 最终走的路径是：
     {走, 1, 0, 0, 0},
     {走, 1, 0, 1, 0},
     {走, 1, 1, 1, 0},
     {走, 0, 走,走,走},
     {走, 走,走, 1,走}
     *
     *
     原图：
     {0, 1, 0, 0, 0},
     {0, 1, 0, 1, 0},
     {0, 1, 1, 1, 0},
     {0, 0, 0, 0, 0},
     {0, 0, 0, 1, 0}
     *
     * @param maze
     * @param visited
     * @param i
     * @param j
     * @param step
     */
    private void dfs(int[][] maze, boolean[][] visited, int i, int j, int step){
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || visited[i][j]== true || maze[i][j]==1){
            return;
        }
        if(i==maze.length-1 && j==maze[0].length-1){
            minStep = Math.min(minStep, step);
            return;
        }

        visited[i][j] = true;
        dfs(maze, visited, i+1, j, step+1);
        dfs(maze, visited, i, j+1, step+1);
        dfs(maze, visited, i-1, j, step+1);
        dfs(maze, visited, i, j-1, step+1);
    }


    /**
     * 1. 求最短路径就要用BFS
     * 2. 遍历前后左右，可以使用的写法，定义dx、dy
     * 3. 记录走过的路径方法：关键点是用一个path保存，上一个节点是从哪里过来的
     * @param maze
     * @return
     */
    public int getMinStepBFS(int[][] maze){
        int min = -1;
        if(maze == null || maze.length == 0 || maze[0].length ==0 || maze[0][0]==1){
            return min;
        }
        boolean visited[][] = new boolean[maze.length][maze[0].length];

        int path[][] = new int[maze.length][maze[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        min = 1;

        /**
         * 第二种写法
         */
        int dx[] = new int[]{1,0,-1,0}, dy[]=new int[]{0,1,0,-1};

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ;i<size; i++){
                int[] item = queue.poll();
                int m = item[0], n=item[1];
                if(m==(maze.length-1) && n== (maze[0].length-1) ){
                    printPath(path);
                    return min;
                }

                /**
                 * 遍历访问：第一种写法
                 */
                /*
                //left
                if(n>0 && maze[m][n-1]==0 && !visited[m][n-1]){
                    visited[m][n-1] = true;
                    queue.offer(new int[]{m,n-1});
                }
                //right
                if(n<(maze[0].length-1) && maze[m][n+1]==0 && !visited[m][n+1]){
                    visited[m][n+1] = true;
                    queue.offer(new int[]{m, n+1});
                }
                //up
                if(m>0 && maze[m-1][n]==0 && !visited[m-1][n]){
                    visited[m-1][n] = true;
                    queue.offer(new int[]{m-1, n});
                }
                //down
                if(m<(maze.length-1) && maze[m+1][n]==0 && !visited[m+1][n]){
                    visited[m+1][n] = true;
                    queue.offer(new int[]{m+1, n});
                }*/

                /**
                 * 遍历访问：第二种写法
                 */
                for (int k=0; k<4; k++){
                    int r = m+dx[k];
                    int c = n+dy[k];
                    if(r<0||r>=maze.length || c<0 || c>=maze[0].length||maze[r][c]==1 || visited[r][c]){
                        continue;
                    }
                    visited[r][c] = true;
                    //记录从哪里来的，+1是为了和初始化的0，区分开来
                    path[r][c] = k+1;
                    queue.offer(new int[]{r,c});
                }


            }

            min++;
        }

        printPath(path);

        return -1;

    }

    private void printPath(int path[][]){
        for (int i=0; i<path.length; i++){
            for (int j = 0; j<path[0].length; j++){
                System.out.printf(path[i][j]+",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazeStep mazeStep = new MazeStep();
        int[][] tab = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };
        mazeStep.getMinStopDFS(tab);

        System.out.println("DFS: "+mazeStep.minStep);
        System.out.println("BFS: "+mazeStep.getMinStepBFS(tab));

    }
}
