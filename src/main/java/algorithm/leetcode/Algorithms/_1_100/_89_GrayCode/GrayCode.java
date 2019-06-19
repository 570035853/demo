package algorithm.leetcode.Algorithms._1_100._89_GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/1/12 .
 ref: https://leetcode.com/problems/gray-code/
 The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 Example 1:

 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2

 For a given n, a gray code sequence may not be uniquely defined.
 For example, [0,2,3,1] is also a valid gray code sequence.

 00 - 0
 10 - 2
 11 - 3
 01 - 1
 Example 2:

 Input: 0
 Output: [0]
 Explanation: We define the gray code sequence to begin with 0.
 A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 Therefore, for n = 0 the gray code sequence is [0].
 */
public class GrayCode {

    /**
     * 手写能写出来，思路是高位先固定，之后进行地位的变更，但代码没想出来
     * 还没有自己写出来，应该算是没有找到正确的思路
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        return null;
    }

    /**
     * 1. pow(2, n)  2的n次方
     * 2. 作者思路还是由小向大推理的
     * 每次变更都逆向着来，进位，然后逆向相加之前的list里面元素
     * 000  输出：0
     * i=1 size=1
     * 001  输出：1
     * i=2 size=2
     * 011  输出：3
     * 010  输出：2
     * i=3 size=4
     * 110
     * 111
     * 101
     * 100
     *
     * @param n
     * @return
     */
    public List<Integer> refGrayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 1; i < Math.pow(2, n); i*=2){
            for(int j = list.size()-1; j>=0; j--){
                list.add(i + list.get(j));
            }
        }
        return list;
    }
}
