package regularExpressionTest;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jialei.zou on 2018/9/28 .
 * ref: https://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html
 * ide无法进入console
 * 补充 进入regularExpressionTest 目录编译文件 javac RegexTestHarness.class
 * 运行 的时候要退回到java目录  使用java regularExpressionTest.RegexTestHarness运行
 *
 */
public class RegexTestHarness {
    public static void main(String[] args){
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {

            Pattern pattern =
                    Pattern.compile(console.readLine("%nEnter your regex: "));

            Matcher matcher =
                    pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");
            }
        }
    }
}
