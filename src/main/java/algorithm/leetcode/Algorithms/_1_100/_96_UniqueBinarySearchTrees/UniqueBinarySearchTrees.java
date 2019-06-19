package algorithm.leetcode.Algorithms._1_100._96_UniqueBinarySearchTrees;

/**
 * Created by jialei.zou on 2018/12/22 .
 * ref: https://leetcode.com/problems/unique-binary-search-trees/
 *
 Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

 Example:

 Input: 3
 Output: 5
 Explanation:
 Given n = 3, there are a total of 5 unique BST's:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTrees {

    /**
     * 能了解到这是一个递归问题，可以for遍历1-n，然后分作左右子树，相乘，但未找到规律和终止条件
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return 0;
    }

    public static int ref1NumTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    /**
     * 如下是看了ref1之后自己写的，之前想到了思路需要补充以下内容才能写出代码
     * 1. 需要考虑n=0的情况，因为左边或者右边没有节点，就是这样的情况，而且每个边界为根的时候，都需要面对这种情况，所以n=0，return 1
     * 2. 确定了0，1这种情况后，n可以由0至于n-1推导出来，之前的思维太发散了，没有按照这种去想。
     *
     * 写出的代码有如下问题：
     * 1.在提交的时候，会提醒：超时，不如ref1里面，已经保存下来了各个值，就不用重复运算了
     * 针对上述问题改进后的代码如下：
     * 见：updateRecursive
     * @param n
     * @return
     */
    public static int recursive(int n){
        if(n==1 || n== 0){
            return 1;
        }
        int result = 0;
        for (int i=0; i<n;i++){
            result += recursive(i)*recursive(n-1-i);
        }
        return result;
    }

    public static int updateRecursive(int n, int[] numTrees){
        if(n==1 || n== 0){
            numTrees[0]=1;
            return 1;
        }
        int result = 0;
        for (int i=0; i<n;i++){
            numTrees[i] =numTrees[i]>0?numTrees[i]:updateRecursive(i, numTrees);
            numTrees[n-1-i] =numTrees[n-1-i]>0?numTrees[n-1-i]:updateRecursive(n-1-i, numTrees);
            result += numTrees[i]*numTrees[n-1-i];
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(ref1NumTrees(3));
//        System.out.println(recursive(3));
        long step1 = System.currentTimeMillis();
        System.out.println(recursive(19));
        long step2 = System.currentTimeMillis();
        System.out.println(updateRecursive(19, new int[19]));
        long step3 = System.currentTimeMillis();
        System.out.println("recursive cost:"+(step2-step1));
        System.out.println("recursive cost:"+(step3-step2));


    }
}
