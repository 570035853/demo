package algorithm.sort;

import java.util.*;

/**
 * Created by jialei.zou on 2019/2/21 .
 ref:
 https://leetcode.com/problems/merge-intervals/
 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
public class MergeIntervals {

    /**
     * 看了ref之后自己手写的，这个题目属于特性题目，练习编程
     * 思考点：
     * 1. 下面用的这种想法类似于括号的关闭，左侧括号的开启，必须有相应的右侧括号关闭，所以有条件判断：start[i+1]>end[i]
     *    很牛的想法
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        if(intervals == null || intervals.size()<1){
            return result;
        }
        int start[] = new int[intervals.size()];
        int end[] = new int[intervals.size()];
        for (int i = 0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0, j=0; i<intervals.size(); i++){
            if(i==intervals.size()-1 || start[i+1]>end[i]){
                result.add(new Interval(start[j], end[i]));
                j = i+1;
            }
        }
        return result;
    }

    /**
     *  思考点：
     *  1. 常规想到的方法就是如下这种，先排序左侧
     *  注意点：
     *  1. Comparator接口的使用
     * @param intervals
     * @return
     */
    public List<Interval> refMerge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }


    public static void main(String[] args) {
        Interval a = new Interval(1, 4);
        Interval b = new Interval(0, 4);
        List<Interval> source = new ArrayList<>();
        source.add(a);
        source.add(b);
        List<Interval> result = merge(source);
        System.out.println();

    }

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}
