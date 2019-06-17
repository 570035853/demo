package algorithm.geek;

/**
 * Created by jialei.zou on 2019/5/4 .
 */
public class Week03 {
    /**
     https://github.com/algorithm001/algorithm/issues/299

     图
     简单：https://leetcode-cn.com/problems/find-the-town-judge/   997
     中等：https://leetcode-cn.com/problems/course-schedule-ii
     困难：https://leetcode-cn.com/problems/minimize-malware-spread-ii/

     堆和排序
     简单：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/ 703
     中等：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/ 373
     困难：https://leetcode-cn.com/problems/find-median-from-data-stream/

     DFS
     简单：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/ 104
     中等：https://leetcode-cn.com/problems/number-of-islands/ 200
     中等：https://leetcode-cn.com/problems/find-eventual-safe-states/ 802
     困难：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/ 329
     困难：https://leetcode-cn.com/problems/making-a-large-island/

     BFS
     简单：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/  429
     中等：https://leetcode-cn.com/problems/minesweeper/ 529 dfs和bfs思路都可以了，后续手写提交
     中等：https://leetcode-cn.com/problems/minimum-height-trees/  310
     困难：https://leetcode-cn.com/problems/bus-routes/  815


     本周703题用的时间比较长，主要之前没有用过堆这种数据结构，也没有用到过java对堆的实现类PriorityQueue，看了王争老师的29讲解
     后，手写了703的堆实现，并总结了相关的知识点如下：
     1. 堆的定义：
     1）完全二叉树(除了最后一层，其他都是满的，左后一层左侧都是满的)
     2）父节点大于等于（或小于等于）子节点的值
     2. 堆使用的数据结构
     因为是完全二叉树，所以使用数组来存储比较合适，推荐从index为1的位置开始，主要是考虑到左侧孩子能通过2*index来定位，右侧孩子就是2*index+1，父节点就是curIndex/2
     3. 堆的add和remove
     add：是先将节点放到数组的最后面，然后从下向上进行和父节点的对比，确认是否有必要进行交换，交换后，继续对比当前节点的父节点，知道条件不满足或者到顶了。
     remove: 删除是删除堆顶元素，直接将末尾元素，移动到堆顶部，然后，从上到下交换到合适的位置。存疑：文章删除堆顶元素部分，作者先左后右，并没有选左右中大的，如果第二层左右互换有问题
     删除的时候，需要找出来左右中的小值（小顶堆）和父亲交互，循环下去
     4. 堆的排序，从堆顶取值，放入数组最后，堆化剩余数据，之后再从堆顶取值，放在倒数第二个的位置，重复，最终排序好
     5. 为什么快排比堆用的更多，即便两者时间复杂度是一样的。快速排序，是局部有序的，堆不是，不能利用CPU缓存，另外交换次数多余快排
     6. 应用场景：求第K个最大的元素，一个堆的大小设置为K，最小堆就能实现上述
     7. java相关的数据结构是PriorityQueue，其默认是小顶堆，通过调整Comparator接口的实现，可以实现大顶堆，这个在工程实际应用里面比较多
     8. 其他牵扯出来的知识点是，在使用PriorityQueue的时候，lambda表达式比较方便，另外，顶级接口会默认补充构建Object里面的方法


     */
}
