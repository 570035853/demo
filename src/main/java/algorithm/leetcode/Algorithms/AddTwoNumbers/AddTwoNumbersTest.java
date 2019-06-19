package algorithm.leetcode.Algorithms.AddTwoNumbers;

/**
 * Created by jialei.zou on 2018/11/15 .
 * ref: https://leetcode.com/problems/add-two-numbers/solution/
 */
public class AddTwoNumbersTest {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode list243 = addTwoNumbers.getNodeList(new int[]{2, 4, 3});
        ListNode list564 = addTwoNumbers.getNodeList(new int[]{5, 6, 4});
        addTwoNumbers.print(list243);
        addTwoNumbers.print(list564);
        ListNode result = addTwoNumbers.myEditAddTwoNumbers(list243, list564);
        addTwoNumbers.print(result);
    }


}
