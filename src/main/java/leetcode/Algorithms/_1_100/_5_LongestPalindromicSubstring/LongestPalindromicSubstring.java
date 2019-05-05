package leetcode.Algorithms._1_100._5_LongestPalindromicSubstring;

/**
 * Created by jialei.zou on 2019/2/28 .
 ref:
 https://leetcode.com/problems/longest-palindromic-substring/

 Given a string s, find the longest palindromic substring in s.
 You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        return null;
    }

    /**
     * 看这个问题的时候，有的一个关注点
     * 1. 关注奇数和偶数的判断 aba奇数情况和abba
     * 2. 关注如何记录最大位置
     *
     * 思路很棒，从中心向两边扩展，又区分了aba奇数情况和abba这种偶数情况(统一的校验逻辑L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R))
     * @param s
     * @return
     */
    public String refLongestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * ref:
     * https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
     * 关注点：
     * 1. DP的初始化：也叫做base，初始化可以确定的值是(0,0),(1,1),(2,2) 以及(0,1)(1,2)(2,3)(3,4)
     * 2. DP的向上增长：没找到如何向上增长
     *
     * 总结：
     * 1. 因为dp[i][j]依赖dp[i + 1][j - 1]，所以应该先确认i大和j小的值，所以两次for的循环如下
     * 2. j - i < 3是因为j-i=0是本身无需关注，j-i=1是相邻2个，j-i=2间隔1个，这几个的判断条件都是s.charAt(i) == s.charAt(j) 所以有
     *    s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])
     * @param s
     * @return
     */
    public static String refDP(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }




    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {

        System.out.println(refDP("abcda"));
    }
}
