package regularExpressionTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zoujialei on 17/10/27.
 */
public class RegularExpressionTest {

    public static void main(String[] args) {
        String mobile = "13119880909";
        System.out.println("isMobile:" + isMobile(mobile));
        String mobile86 = "8613119880909";
        System.out.println("isMobile:" + isMobile(mobile86));
        String notMobile = "1456346";
        System.out.println("isMobile:" + isMobile(notMobile));
    }

    private static boolean isMobile(String mobile){
        Pattern p = Pattern.compile("^(086|86|)1[34578]\\d{9}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }
}
