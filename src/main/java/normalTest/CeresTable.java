package normalTest;

/**
 * Created by jialei.zou on 2018/10/18 .
 */
public class CeresTable {

    public static void main(String[] args) {
        String userId = "FCA7258B-61FF-4195-B7DB-FBBD1A3E2A75";
        int database = (userId.hashCode()>>>5)&1;
        int table = userId.hashCode() & 15;
        System.out.println("database: ceres_"+database);
        System.out.println("table: user_balance_detail_"+table);

        int value = -5 & 15;
        System.out.println("_17_skiplist value:"+value);

        int i=0;
        while (true){
            i++;
        }
    }
}
