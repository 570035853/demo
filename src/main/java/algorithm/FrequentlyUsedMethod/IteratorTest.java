package algorithm.FrequentlyUsedMethod;

import java.util.*;
import java.util.List;

/**
 * Created by jialei.zou on 2019/6/19 .
 */
public class IteratorTest {

    /**
     * iterator 实际也是一种设计模式，隐藏集合的实现方式，通过对外提供三个方法来完成集合元素的遍历和删除，三个方法分别是
     * boolean hasNext();
     * Object next();
     * void remove();
     * @param args
     */
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(6);
        set.add(15);
        IteratorTest test = new IteratorTest();
        test.removeBigValue1(10, set);
        test.printSet(set);

        set.add(16);
        test.printSet(set);
        test.removeBigValue2(10, set);
        test.printSet(set);



    }

    private void printSet(Set<Integer> set){
        for (Integer item: set){
            System.out.printf(item+",");
        }
        System.out.println();
    }

    /**
     * fail-fast和使用iterator删除的正确方式
     */
    public void demo(){
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        /**
         * 1. 如果遍历过程中list有被iterator以外的操作改变，则抛出异常，
         * 实现是通过遍历开始的时候记录expectedModCount = modCount，之后每次遍历对比一下该数值
         */
        Iterator iterator = list.iterator();


        /*
        while (iterator.hasNext()){
            int  next = (Integer)iterator.next();
            if(next==2){
                //如下变动，遍历过程抛出异常
                list.add(4);
            }else {
                System.out.printf(next+"");
            }
        }
        */

        while (iterator.hasNext()){
            //2. 如果没有下面这句，删除会报异常，因为标志位lastRet还是-1
            iterator.next();
            iterator.remove();
        }
        System.out.println(list.size());
    }

    /**
     * 3. 如下方式的删除没有问题
     * @param value
     * @param set
     */
    private void removeBigValue1(int value, Set<Integer> set){
        for (Integer item: set){
            if(item>value){
                set.remove(item);
            }
        }
    }

    /**
     * 4. 如下方式的删除没有问题
     * @param value
     * @param set
     */
    private void removeBigValue2(int value, Set<Integer> set){
        Iterator<Integer> iterator =set.iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            if(next>value){
                iterator.remove();
            }
        }
    }
}
