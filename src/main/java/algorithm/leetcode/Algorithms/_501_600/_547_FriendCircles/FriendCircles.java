package algorithm.leetcode.Algorithms._501_600._547_FriendCircles;

import java.util.*;

/**
 * Created by jialei.zou on 2019/3/21 .
 ref:
 https://leetcode.com/problems/friend-circles/

 There are N students in a class. Some of them are friends, while some are not.
 Their friendship is transitive in nature. For example, if A is a direct friend of B,
 and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend
 circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class.
 If M[i][j] = 1, then the ith and jth students are direct friends with each other,
 otherwise not. And you have to output the total number of friend circles among all the students.

 Example 1:
 Input:
 [
 [1,1,0],
 [1,1,0],
 [0,0,1]
 ]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.
 Example 2:
 Input:
 [
 [1,1,0],
 [1,1,1],
 [0,1,1]
 ]
 Output: 1
 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 Note:
 N is in range [1,200].
 M[i][i] = 1 for all students.
 If M[i][j] = 1, then M[j][i] = 1.


 */
public class FriendCircles {

    /**
     * 看了基本的消去方法后，想到的如下方法，看下ref
     * 消去方法是一个挨着一个的朋友圈消去
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int result = 0;
        int length = M.length;
        int[] visited = new int[length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<length; i++){
            if(visited[i] == 0){
                queue.offer(i);
                while (!queue.isEmpty()){
                    int k = queue.poll();
                    visited[k] = 1;
                    for (int j = 0; j<length; j++){
                        if(M[k][j] == 1 && visited[j]==0){
                            queue.add(j);
                        }
                    }
                }
                result +=1;
            }
        }
        return result;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    /**
     * ref方法的亮点
     * 1. 将DFS抽出来了，更清晰
     * 其他思考：
     * 关于时间复杂度的思考，换一种思维方式，需要遍历n*n的关系所以是n2
     * @param M
     * @return
     */
    public int refFindCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        FriendCircles friendCircles = new FriendCircles();
        int[][] expect1 = new int[][]{
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };
        int[][] expect2 = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(friendCircles.findCircleNum(expect1));
        System.out.println(friendCircles.findCircleNum(expect2));

    }
}
