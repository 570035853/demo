package lambdaTest;

import lombok.Data;

/**
 * @author zoujialei02
 * @date 2020/3/24
 */
@Data
public class Comment {
    long id;
    String comment;

    public Comment(long id, String comment){
        this.id = id;
        this.comment = comment;
    }
}
