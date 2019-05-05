package algorithm.array2D;

/**
 * Created by jialei.zou on 2019/2/12 .
 ref: https://leetcode.com/problems/surrounded-regions/

 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 Explanation:

 Surrounded regions shouldn’t be on the border,
 which means that any 'O' on the border of the board are not flipped to 'X'.
 Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 Two cells are connected if they are adjacent cells connected horizontally or vertically.


自己画的如下：
 X X X X X
 X O O X X
 X X O X X
 X O O X X
 X O X X X
 */
public class SurroundedRegions {

    /**
     * 思路是从边界对O进行连线，能最终连接到边界的，就不替换，其他的进行替换，代码没有想好怎么写
     * 看了ref之后，觉得有如下地方没有想清楚如何用程序来实现：
     *
     * 1. 自己大脑的海量计算过程，实际也保证了不会重复走走过的路线，而对于参考的ref，
     *   用的是替换O为*来完成个该限制，不变的是，上线左右都会走一遍
     * 2. 从最外围的边界，逐个元素出发，依次向着四个方向前进，递归实现
     * 3. board[0].length 是指有多少列，board.length多少行
     * 4. DFS是深度优先遍历，BFS是广度优先遍历
     * 看ref：
     https://leetcode.com/problems/surrounded-regions/discuss/41633/Java-DFS-%2B-boundary-cell-turning-solution-simple-and-clean-code-commented.
     * 3月4日在纸上写了一遍
     * @param board
     */
    public void solve(char[][] board) {

    }

    /**
     * board[0].length 是指有多少列
     * board.length 多少行
     *
     * @param board
     */
    public void refSolve(char[][] board) {
        if (board.length == 0 || board[0].length == 0){
            return;
        }
        if (board.length < 2 || board[0].length < 2){
            return;
        }
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            //最左侧列
            if (board[i][0] == 'O'){
                boundaryDFS(board, i, 0);
            }
            //最右侧列
            if (board[i][n-1] == 'O'){
                boundaryDFS(board, i, n-1);
            }
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O'){
                boundaryDFS(board, 0, j);
            }
            if (board[m-1][j] == 'O'){
                boundaryDFS(board, m-1, j);
            }
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    //深度优先算法（Depth-First-Search）,

    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1){
            return;
        }
        //todo 验证下条件判断不需要，if (board[i][j] == 'O')，因为外围保证了进来就满足该条件，直接可以进行星设置
        if (board[i][j] == 'O'){
            board[i][j] = '*';
        }
        if (i > 1 && board[i-1][j] == 'O'){
            boundaryDFS(board, i-1, j);
        }
        if (i < board.length - 2 && board[i+1][j] == 'O'){
            boundaryDFS(board, i+1, j);
        }
        if (j > 1 && board[i][j-1] == 'O'){
            boundaryDFS(board, i, j-1);
        }
        if (j < board[i].length - 2 && board[i][j+1] == 'O' ){
            boundaryDFS(board, i, j+1);
        }
    }
}
