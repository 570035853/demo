package algorithm.leetcode.Algorithms._201_300._274_HIndex;

/**
 * Created by jialei.zou on 2019/3/22 .
 ref:
 https://leetcode.com/problems/h-index/
 Given an array of citations (each citation is a non-negative integer) of a researcher,
 write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her
 N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [3,0,6,1,5]
 Output: 3
 Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.
 Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndex {

    public int hIndex(int[] citations) {
        return 0;
    }

    /**
     * 1. 桶排序
     * 2. 一个增长，一个减少，两者交叉的时候就是count >= i的条件判断
     * ref:
     * https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
     */
    public int refHIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
