package leetcode.Algorithms._401_500._403_FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jialei.zou on 2019/6/15 .
 ref:
 https://leetcode.com/problems/frog-jump/
 A frog is crossing a river. The river is divided into x units and at each unit
 there may or may not exist a stone. The frog can jump on a stone, but it must not
 jump into the water.

 Given a list of stones' positions (in units) in sorted ascending order, determine
 if the frog is able to cross the river by landing on the last stone. Initially,
 the frog is on the first stone and assume the first jump must be 1 unit.

 If the frog's last jump was k units, then its next jump must be either k - 1, k,
 or k + 1 units. Note that the frog can only jump in the forward direction.

 Note:

 The number of stones is ≥ 2 and is < 1,100.
 Each stone's position will be a non-negative integer < 231.
 The first stone's position is always 0.
 Example 1:

 [0,1,3,5,6,8,12,17]

 There are a total of 8 stones.
 The first stone at the 0th unit, second stone at the 1st unit,
 third stone at the 3rd unit, and so on...
 The last stone at the 17th unit.

 Return true. The frog can jump to the last stone by jumping
 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 2 units to the 4th stone, then 3 units to the 6th stone,
 4 units to the 7th stone, and 5 units to the 8th stone.
 Example 2:

 [0,1,2,3,4,8,9,11]

 Return false. There is no way to jump to the last stone as
 the gap between the 5th and 6th stone is too large.

 */
public class FrogJump {

    /**
     * 第100题目
     * 自己的思路总结下，在看下其他人的思路
     * 自己的思路：
     * 顺序遍历每一个节点，之后该节点可能能到达后续的几个节点，到达的每个节点都累加其后续可以跳几部（set累加），
     * 让每个节点都保持有一个set，并循环遍历下去，确定可以到达后续哪个节点，用map方式的进行o(1)的定位
     *
     * 其他人的思路和我的一样，真棒 哈哈哈  不过ref里面，初始化没有放入-1，直接放入的new hashmap，更好
     * https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations
     *
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        if(stones == null){
            return false;
        }
        if(stones.length == 1){
            return true;
        }
        HashMap<Integer, Set<Integer>> map = new HashMap();
        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(1);
        map.put(0, firstSet);
        //初始化map，用户确定可以到达该位置
        for (int i = 1; i < stones.length; i++ ){
            Set<Integer> itemSet = new HashSet<>();
            itemSet.add(-1);
            map.put(stones[i], itemSet);
        }
        int target = stones[stones.length-1];
        for (int i = 0; i<stones.length-1; i++){
            Set<Integer> items = map.get(stones[i]);
            for (Integer item: items){
                if(item>0){
                    if((item + stones[i]) == target){
                        return true;
                    }
                    if(map.containsKey(item + stones[i])){
                        Set<Integer> nextSet = map.get(item + stones[i]);
                        nextSet.add(item);
                        nextSet.add(item+1);
                        nextSet.add(item-1);
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(frogJump.canCross(new int[]{0,1,2,3,4,8,9,11}));

    }
}
