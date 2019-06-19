package algorithm.leetcode.Algorithms.PalindromeNumber;

/**
 * Created by jialei.zou on 2018/12/8 .
 * ref：https://leetcode.com/problems/palindrome-number/solution/
 */
public class PalindromeNumber {

    /**
     * Runtime: 189 ms, faster than 10.55% of Java online submissions for Palindrome Number.
     * 可见性能不咋地
     * 1. 文章提到了不能用String，没看到
     * 2. String还有一个方法是String.valueof()
     * @param x
     * @return
     */
    public static boolean myIsPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        char[] arry = (x+"").toCharArray();
        String str = String.valueOf(x);
        int i=0,j=arry.length-1;
        while (i<j){
            if(arry[i]!=arry[j]){
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * 确保翻转的等于自身，但存在溢出的问题，所以可以进行一般翻转 1221这种 比较12和21翻转后的12，当然要规避
     * 1. 12321 mid=3的，舍去；
     * 2. 550这种末尾为0的，不符合循环条件，而且也不是回文
     * @param x
     * @return
     */
    public static boolean refIsPalindrome(int x){
        if(x<0 || x % 10 == 0){
            return false;
        }
        if(x==0){
            return true;
        }
        int revert = 0;
        while (x>revert){
            revert = revert*10 + x%10;
            x=x/10;
        }
        return x==revert || x==revert/10;
    }

    public static void main(String[] args) {
        System.out.println("121:"+myIsPalindrome(121));
        System.out.println("-121:"+myIsPalindrome(-121));
        System.out.println("0:"+myIsPalindrome(0));
        System.out.println("550:"+myIsPalindrome(550));
        System.out.println("899:"+myIsPalindrome(899));
        System.out.println("8990:"+myIsPalindrome(8990));

        System.out.println("there solution:");

        System.out.println("121:"+refIsPalindrome(121));
        System.out.println("-121:"+refIsPalindrome(-121));
        System.out.println("0:"+refIsPalindrome(0));
        System.out.println("550:"+refIsPalindrome(550));
        System.out.println("899:"+refIsPalindrome(899));
        System.out.println("8990:"+refIsPalindrome(8990));
    }
}
