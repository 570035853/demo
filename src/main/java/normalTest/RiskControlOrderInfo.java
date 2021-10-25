package normalTest;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zoujialei02
 * @date 2019/12/31
 */
@Data
@NoArgsConstructor
public class RiskControlOrderInfo {
    private long order_id; // 订单号
    private long order_id_view; //订单展示id
    private long submit_timestamp; // 订单提单时间 unix时间（具体到秒）
    private long poi_id; // 订单商家id
    private long poi_city_id; // 订单商家所在城市id
    private int order_source; // 渠道类型 外卖安卓、外卖ios、团安卓等等
    private int shipping_service; // 快送、加盟配送、纯众包、自配送等
    private String uuid; // uuid

    public RiskControlOrderInfo(long order_id, long poi_id){
        this.order_id = order_id;
        this.poi_id = poi_id;
    }
}