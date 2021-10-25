package normalTest.file;

import java.io.IOException;
import java.util.List;

/**
 * @author zoujialei02
 * @date 2020/6/27
 */
public class LabelRef {

    /**
     *
     CREATE TABLE `wm_poi_comment_label_ref` (
     `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
     `wm_poi_id` bigint(20) unsigned NOT NULL COMMENT '商家id',
     `comment_id` bigint(20) unsigned NOT NULL COMMENT '评论id',
     `label_id` int(11) unsigned NOT NULL COMMENT '标签id',
     `label_name` varchar(255) NOT NULL COMMENT '标签名称',
     `match_content` varchar(255) NOT NULL DEFAULT '' COMMENT '匹配文字',
     `start_pos` int(11) unsigned DEFAULT '0' COMMENT '匹配的内容在评论中的起始位置',
     `end_pos` int(11) unsigned DEFAULT '0' COMMENT '匹配的内容在评论中的结束位置',
     `dt` varchar(50) NOT NULL DEFAULT '' COMMENT '时间',
     `status` tinyint(1) DEFAULT '0' COMMENT '数据状态1-有效 0-无效',
     `ctime` int(11) DEFAULT '0' COMMENT '创建时间',
     `utime` int(11) DEFAULT '0' COMMENT '更新时间',
     PRIMARY KEY (`id`),
     KEY `idx_poi_label_id` (`wm_poi_id`,`label_id`),
     KEY `idx_comment_id` (`comment_id`),
     KEY `idx_ctime` (`ctime`)
     ) ENGINE=InnoDB AUTO_INCREMENT=490246134 DEFAULT CHARSET=utf8mb4
     * @param args
     * @throws IOException
     */


    public static void main(String[] args) throws IOException {
        List<String> labelRef = FileUtils.getString("/Users/zoujialei/Documents/项目开发/api逻辑下沉/poiid_2700973.csv");
        for (int i=1; i<labelRef.size(); i++){
            String values[] = labelRef.get(i).split(",");
            long wm_poi_id = Long.valueOf(values[1]);
            long comment_id = Long.valueOf(values[2]);
            long label_id = Long.valueOf(values[3]);
            String label_name = values[4];
            String match_content = values[5];
            long start_pos = Long.valueOf(values[6]);
            long end_pos = Long.valueOf(values[7]);
            String dt = values[8];
            int status = Integer.valueOf(values[9]);
            long ctime = Long.valueOf(values[10]);
            long utime = Long.valueOf(values[11]);

            String sql = "insert into wm_poi_comment_label_ref(wm_poi_id,comment_id,label_id,label_name,match_content,start_pos,end_pos,dt,status,ctime,utime) " +
                    "values("+wm_poi_id+","+comment_id+","+label_id+",'"+label_name+"','"+match_content+"',"+start_pos+","+end_pos+",'"+dt+"',"+status+","+ctime+","+utime+");";
            System.out.println(sql);

        }
    }
}
