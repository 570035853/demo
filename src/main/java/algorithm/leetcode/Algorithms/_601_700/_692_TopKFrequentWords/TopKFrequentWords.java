package algorithm.leetcode.Algorithms._601_700._692_TopKFrequentWords;

import java.util.*;

/**
 * Created by jialei.zou on 2019/4/24 .
 ref: https://leetcode.com/problems/top-k-frequent-words/
 Given a non-empty list of words, return the k most frequent elements.

 Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 then the word with the lower alphabetical order comes first.

 Example 1:
 Input: ["i", "love", "algorithm.leetcode", "i", "love", "coding"], k = 2
 Output: ["i", "love"]
 Explanation: "i" and "love" are the two most frequent words.
 Note that "i" comes before "love" due to a lower alphabetical order.
 Example 2:
 Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 Output: ["the", "is", "sunny", "day"]
 Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 with the number of occurrence being 4, 3, 2 and 1 respectively.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Input words contain only lowercase letters.
 Follow up:
 Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {

    /**
     * 自己的思路是，思路是先遍历一遍，放入到map中，遍历map：key为元素，value是值
     * 随后进行遍历map，对其中每个元素进行插入排序，具体为：
     *     先用二分查找找数字大小位置，开始和结束位置，
     *     对相等数字的，二分查找找到相应位置，找到后插入到数组的相应位置
     * 最后遍历输出前k个元素
     *
     * 上述思路的问题是：使用空间比较多
     *
     * 看ref
     * PriorityQueueDemo
     * LambdaDemo
     * lambda的相关知识可见：《lambda相关说明》
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        return null;
    }

    public List<String> topKFrequentRef1(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }

    public List<String> topKFrequentRef2(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) {ans.add(heap.poll());}
        Collections.reverse(ans);
        return ans;
    }

}
