package normalTest;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) throws ParseException{
        Date to = DateUtils.parseDate("20190913152252", new String[]{"yyyyMMddHHmmss"});
        Date from = DateUtils.parseDate("20190911213100", new String[]{"yyyyMMddHHmmss"});

        long delta = to.getTime()/1000-from.getTime()/1000;
        System.out.println(from.getTime()/1000);
        System.out.println(to.getTime()/1000);
        System.out.println(delta);
        System.out.println(delta/14);

    }
}
