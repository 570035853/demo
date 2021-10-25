package lambdaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zoujialei02
 * @date 2020/3/24
 */
public class List2ListDemo {

    public static void main(String[] args) {
        List<Comment> list = new ArrayList<>();
        list.add(new Comment(1, "test1"));
        list.add(new Comment(1, "test2"));
        list.add(new Comment(2, "test3"));
        list.add(new Comment(3, "test4"));

        List<Long> userIds1 = list.stream().map(Comment::getId).collect(Collectors.toList());
        List<Long> uniqueList = userIds1.stream().distinct().collect(Collectors.toList());


    }
}
