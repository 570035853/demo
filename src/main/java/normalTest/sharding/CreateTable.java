package normalTest.sharding;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CreateTable {



    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String table = "wm_ugc_comment_";
//        for (int i = 0; i<100; i++){
//            String sql =
//                    "CREATE TABLE `"+table+i+"_"+"` (\n" +
//                    "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
//                    "  `wm_poi_id` bigint(20) NOT NULL COMMENT '门店id',\n" +
//                    "  `comment_id` bigint(20) NOT NULL COMMENT '评价id',\n" +
//                    "  `user_id` bigint(20) DEFAULT '0' COMMENT '用户id',\n" +
//                    "  `valid` tinyint(1) DEFAULT '1' COMMENT '有效性 0. 删除 1.有效',\n" +
//                    "  `ctime` int(11) DEFAULT '0' COMMENT '创建时间',\n" +
//                    "  `utime` int(11) DEFAULT '0' COMMENT '更新时间',\n" +
//                    "  PRIMARY KEY (`id`),\n" +
//                    "  UNIQUE KEY `uniq_comment_id_user_id` (`comment_id`,`user_id`)\n" +
//                    ") ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPRESSED COMMENT='评价有用表';\n\n";
//            stringBuilder.append(sql);
//        }

//        String insert = "insert into waimai.wm_user_favorite(user_id, wm_poi_id, utime, valid) value(2, {poiId}, {utime}, 1);";
//        String spuInsert = "insert into waimai.user_favorite_spu_2(user_id, poi_id,spu_id, ctype,valid, ctime, utime) value(2,{poiId},{spuId},1,1,{ctime},{utime});";
//        String subInsert = "insert into ugc.poi_subscribe_info_2(biz_id, user_id, poi_id, sub_status, push_status, source, ctime, utime) value(1,2,{poiId},1,1,1,{ctime},{utime});";
        for (int i = 0; i<100; i++){
            System.out.println("alter table "+table+i+" add column anonymous tinyint(1) default 0 comment '1-匿名 0-非匿名';");
        }

//        System.out.println(stringBuilder.toString());
        File file = new File("/Users/zoujialei/Documents/项目开发/商品宽表建设/createTable.sql");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringBuilder.toString());
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
