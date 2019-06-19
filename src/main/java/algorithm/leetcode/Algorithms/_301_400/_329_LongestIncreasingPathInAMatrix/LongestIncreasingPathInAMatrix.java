package algorithm.leetcode.Algorithms._301_400._329_LongestIncreasingPathInAMatrix;

/**
 * Created by jialei.zou on 2019/6/13 .
 en:
 https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 cn:
 https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 给定一个整数矩阵，找出最长递增路径的长度。

 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

 示例 1:

 输入: nums =
 [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 输出: 4
 解释: 最长递增路径为 [1, 2, 6, 9]。
 示例 2:

 输入: nums =
 [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 输出: 4
 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。


 */
public class LongestIncreasingPathInAMatrix {

    /**
     * 没想出来，直接看的ref：
     The idea is simple and intuitive:
     1. For each cell, try it's left, right, up and down for smaller number.
     2. If it's smaller, means we are on the right track and we should keep going.
     If larger, stop and return.
     3. Treat each cell as a start cell. Calculate and memorize the longest distance for this cell,
     so we don't need to calculate it again in the future.
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = findSmallAround(i, j, matrix, cache, Integer.MAX_VALUE);
                max = Math.max(length, max);
            }
        }
        return max;
    }
    private int findSmallAround(int i, int j, int[][] matrix, int[][] cache, int pre) {
        // if out of bond OR current cell value larger than previous cell value.
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= pre) {
            return 0;
        }
        // if calculated before, no need to do it again
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(findSmallAround(i - 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i + 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i, j - 1, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i, j + 1, matrix, cache, cur), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }


    /******************************************/

    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPathRef2(int[][] matrix) {
        if(matrix.length == 0) {return 0;}
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) {return cache[i][j];}
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            //下面这个地方matrix[x][y] <= matrix[i][j]  里面是>=可以，是<=也可以
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {continue;}
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }


    public int longestIncreasingPathLearn(int[][] matrix) {
        if(matrix.length == 0) {return 0;}
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfsAdjust(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    /**
     * 用1表示已经访问过了，而且也是最小的递增单位
     * @param matrix
     * @param i
     * @param j
     * @param m
     * @param n
     * @param cache
     * @return
     */
    public int dfsAdjust(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) {return cache[i][j];}
        int max = 1;
        if(i+1<m && matrix[i+1][j]>matrix[i][j]){
            max = Math.max(max, dfsAdjust(matrix, i+1, j, m, n, cache)+1);
        }
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]){
            max = Math.max(max, dfsAdjust(matrix, i-1, j, m, n, cache)+1);
        }
        if(j+1<n && matrix[i][j+1]>matrix[i][j]){
            max = Math.max(max, dfsAdjust(matrix, i, j+1, m, n, cache)+1);
        }
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]){
            max = Math.max(max, dfsAdjust(matrix, i, j-1, m, n, cache)+1);
        }

        cache[i][j] = max;
        return max;
    }


    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix matrix = new LongestIncreasingPathInAMatrix();
        System.out.println(matrix.longestIncreasingPathRef2(new int[][]{
                {3,4,5},
                {2,2,6},
                {2,2,1}
        }));

    }
}
