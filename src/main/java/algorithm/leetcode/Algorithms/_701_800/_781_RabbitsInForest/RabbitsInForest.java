package algorithm.leetcode.Algorithms._701_800._781_RabbitsInForest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jialei.zou on 2019/6/26 .

 ref:
 https://leetcode.com/problems/rabbits-in-forest/

 In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them)
 tell you how many other rabbits have the same color as them. Those answers are placed in an array.

 Return the minimum number of rabbits that could be in the forest.

 Examples:
 Input: answers = [1, 1, 2]
 Output: 5
 Explanation:
 The two rabbits that answered "1" could both be the same color, say red.
 The rabbit than answered "2" can't be red or the answers would be inconsistent.
 Say the rabbit that answered "2" was blue.
 Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

 Input: answers = [10, 10, 10]
 Output: 11

 Input: answers = []
 Output: 0
 Note:

 answers will have length at most 1000.
 Each answers[i] will be an integer in the range [0, 999].

 *
 */
public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        int result = 0;
        if(answers == null || answers.length ==0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<answers.length; i++){
            if(map.containsKey(answers[i])){
                map.put(answers[i], map.get(answers[i])+1);
            }else {
                map.put(answers[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> item: map.entrySet()){
            int num = (item.getValue()/(item.getKey()+1))*(item.getKey()+1);
            if(item.getValue()%(item.getKey()+1)>0){
                num = num+ item.getKey()+1;
            }
            result = result+num;
        }
        return result;
    }

    public static void main(String[] args) {
        RabbitsInForest rabbitsInForest = new RabbitsInForest();
        System.out.println(rabbitsInForest.numRabbits(new int[]{10, 10, 10}));
        System.out.println(rabbitsInForest.numRabbits(new int[]{1, 1, 2}));

    }
}
