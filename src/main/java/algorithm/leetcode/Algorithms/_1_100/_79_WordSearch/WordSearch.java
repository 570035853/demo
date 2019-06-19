package algorithm.leetcode.Algorithms._1_100._79_WordSearch;

/**
 * Created by jialei.zou on 2019/1/10 .
 * ref: https://leetcode.com/problems/word-search/
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.

 用到了递归
 */
public class WordSearch {

    /**
     * 自己想的思路是，既然不能遍历一遍读过的，要把那些已经遍历的记录下来，同时，要把所在位置的前后左右都找一遍，
     * 应该会用到递归+存储空间，如何组合写代码没想出来，看些ref
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        return false;
    }


    /**
     * ref的思路为：
     * 1. 起点：二位数组中任何一个元素，关注两次for，两次for里面y是二位数组的length、x的length是y的length
     * 2. 如何进行遍历：递归的方式，遍历前后左右，知道遍历完目标数组，或者xy到边界
     * 3. 如果保证不遍历已经遍历过的：异或运算，256的二进制是1 0000 0000 char在java中占有2个字节，字母是一个字节，
     *     所以和256异或一次后就不再是字母（第9位发生了变化），异或2次，第9位就变回来了
     *     所以异或256这个的确是天才想法
     * @param board
     * @param word
     * @return
     */
    public boolean refExist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (refExist(board, y, x, w, 0)) {
                    return true;
                 }
            }
        }
        return false;
    }

    private boolean refExist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (y<0 || x<0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (board[y][x] != word[i]) {
            return false;
        }
        board[y][x] ^= 256;
        boolean exist = refExist(board, y, x+1, word, i+1)
                || refExist(board, y, x-1, word, i+1)
                || refExist(board, y+1, x, word, i+1)
                || refExist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }


    /**
     * 1. ref2思维和ref1的区别就是，ref2的思维更常规一些，利用了一个boolean[][] visited保存了访问了哪些结点
     * 2. 和ref1不同的是，没有将字符串转为数组char，直接用的charAt(index)方法
     */
    static boolean[][] visited;
    public boolean ref2Exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a);
        a ^= 256;
        System.out.println(a);
    }

}
