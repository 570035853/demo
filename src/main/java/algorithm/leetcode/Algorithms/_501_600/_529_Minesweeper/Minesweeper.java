package algorithm.leetcode.Algorithms._501_600._529_Minesweeper;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jialei.zou on 2019/6/14 .
 en:
 https://leetcode.com/problems/minesweeper/
 cn:
 https://leetcode-cn.com/problems/minesweeper/

 看原网址，有图的

 让我们一起来玩扫雷游戏！

 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，
 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
 'X' 则表示一个已挖出的地雷。

 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 如果在此次点击中，若无更多方块可被揭露，则返回面板。
  

 示例 1：

 输入:

 [['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

 Click : [3,0]

 输出:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 解释:

 示例 2：

 输入:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Click : [1,2]

 输出:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 解释:

  

 注意：

 输入矩阵的宽和高的范围为 [1,50]。
 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minesweeper
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Minesweeper {


    /**
     * 问题在于，没看懂为什么地雷上面那个E没有做变化，所以还是不理解题意
     * 看了答案的if，应该是如下要求
     * 1. 对于B类型的，需要持续递归下去，其他类型的就没有必要递归下去了
     * 2. 对于地雷，发现后，重置就直接返回了
     */

    /**
     * DFS的方式如下
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
        }
        else { // Empty
            // Get number of mines first.
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                        continue;
                    }
                    if (board[r][c] == 'M' || board[r][c] == 'X') {
                        count++;
                    }
                }
            }

            if (count > 0) { // If it is not a 'B', stop further DFS.
                board[row][col] = (char)(count + '0');
            }
            else { // Continue DFS to adjacent cells.
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                            continue;
                        }
                        if (board[r][c] == 'E') {
                            updateBoard(board, new int[] {r, c});
                        }
                    }
                }
            }
        }

        return board;
    }


    /**
     * BFS的方式如下
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoardBFS(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            if (board[row][col] == 'M') { // Mine
                board[row][col] = 'X';
            }
            else { // Empty
                // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                            continue;
                        }
                        if (board[r][c] == 'M' || board[r][c] == 'X') {
                            count++;
                        }
                    }
                }

                if (count > 0) { // If it is not a 'B', stop further BFS.
                    board[row][col] = (char)(count + '0');
                }
                else { // Continue BFS to adjacent cells.
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                                continue;
                            }
                            if (board[r][c] == 'E') {
                                queue.add(new int[] {r, c});
                                board[r][c] = 'B'; // Avoid to be added again.
                            }
                        }
                    }
                }
            }
        }

        return board;
    }
}
