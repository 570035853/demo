package normalTest;

/**
 * Created by zoujialei on 2018/2/6.
 */
public class Reminder {
    //提现提醒文案
    //实时提现
    public final static String SUPER_ONLINE_BANKING_SYSTEM_WITHDRAW_REMINDER = "不限时间，不限笔数，免手续费，当日到账";
    //大额提现-免费文案
    public final static String WHOLESALE_WITHDRAW_FREE_REMINDER = "大额提现每日限1笔，提现后预计当日到账，暂免手续费";
    //大额提现-收费文案
    public final static String WHOLESALE_WITHDRAW_NOT_FREE_REMINDER = "普通提现每日限1笔，提现后预计当日到账";
    //大额提现收费标准
    public final static String WHOLESALE_WITHDRAW_FEE_SCALE =
            "5万~10万（含），每笔收取10元手续费\n" +
                    "10万~50万（含），每笔收取15元手续费\n" +
                    "50万~100万（含），每笔收取20元手续费\n" +
                    "100万以上，收取提现金额的万分之0.2为手续费";
    //大额提现（非超级网银）时间提醒
    public final static String NORMAL_WITHDRAW_ALLOW_TIME =
            "可提现时间：工作日09:00—16:30";
}
