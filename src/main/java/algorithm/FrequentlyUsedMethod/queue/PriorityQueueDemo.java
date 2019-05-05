package algorithm.FrequentlyUsedMethod.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jialei.zou on 2019/5/4 .
 *
 * 用到的地方有：
 * KthLargest
 * TopKFrequentWords
 *
 * 可以自己练习的有：
 * https://www.jianshu.com/p/c577796e537a
 *
 * 总结：
 * PriorityQueue优先级队列实际是维护了一个小顶堆，只能逐个出堆才能完成排序
 *
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue smallHeap = new PriorityQueue();
        smallHeap.add(1);
        smallHeap.add(2);
        smallHeap.add(3);

        while (!smallHeap.isEmpty()){
            System.out.println(smallHeap.poll());
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(02);
            }

            @Override
            public boolean equals(Object obj){
                return true;
            }

        };

        PriorityQueue bigHeap = new PriorityQueue(comparator);
        bigHeap.offer(1);
        bigHeap.offer(2);
        bigHeap.offer(3);

        while (!bigHeap.isEmpty()){
            System.out.println(bigHeap.poll());
        }



    }


}
