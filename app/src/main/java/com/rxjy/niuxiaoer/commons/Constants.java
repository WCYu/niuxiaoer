package com.rxjy.niuxiaoer.commons;

/**
 * Created by AAA on 2017/7/25.
 */

public class Constants {
    public static String YINDAOYE = "yindaoye";
    public static String CARD_NO = "card_no"; // 卡号
    public static String YAOQINGMA = "yaoqingma"; // 邀请码
    public static String TOKEN = "token";
    public static String IS_LOGIN = "is_login";
    public static final String IS_FIRST_LOGIN = "is_first_login";
    public static final String clientname = "clientname";
    public static final String clientstatus = "clientstatus";

    public static String REGISTERPHONE="registerphone";
    public static String CODELOGINPHONE="codeloginphone";
    public static String DAOJISHI="daojishi";
    public static String CODE_LOGIN_DAOJISHI="code_login_daojishi";


    //发送广播的标识
    public static final String ACTION_INFORMATION_MINE = "com.rxjy.niuxiaoer.information.mine";

    //接收广播的Key
    public static final String KEY_STATE = "key_state";

    //向修改信息界面传递KeyValue
    public static final String ACTION_TO_UPD_USER_INFO_KEY_VALUE = "action_to_upd_user_info_key_value";
    //向修改信息界面传递Key
    public static final String ACTION_TO_UPD_USER_INFO_KEY = "action_to_upd_user_info_key";
    //向修改信息界面传递Value
    public static final String ACTION_TO_UPD_USER_INFO_VALUE = "action_to_upd_user_info_value";
    //向修改信息界面传递Style
    public static final String ACTION_TO_UPD_USER_INFO_STYLE = "action_to_upd_user_info_style";


    //向余额界面传递现金信息
    public static final String ACTION_TO_BALANCE_BALANCE_INFO = "action_to_balance_balance_info";
    //向新闻详情界面传递id
    public static final String ACTION_TO_NEWS_DETAIL_NEWS_ID = "action_to_news_detail_news_id";
    //向支款界面传递余额信息
    public static final String ACTION_TO_WITHDRAW_DEPOSIT_INFO = "action_to_withdraw_deposit_info";
    //向客户详情传递操作状态
    public static final String ACTION_TO_MSG_E_CLIENT_INFO_PAGE_STATE = "action_to_msg_e_client_info_page_state";
    //向客户详情传递客户ID
    public static final String ACTION_TO_MSG_E_CLIENT_INFO_CUSTOM_ID = "action_to_msg_e_client_info_custom_id";
    //向客户详情传递分公司ID
    public static final String ACTION_TO_MSG_E_CLIENT_INFO_FILIALE_ID = "action_to_msg_e_client_info_filiale_id";
    //向获取客户详细信息页面传递ID
    public static final String ACTION_TO_MSGECLIENTINFO_KEHUBASE_ID = "action_to_msgeclientinfo_kehubase_id";
    //向获取客户详细信息页面传递status
    public static final String ACTION_TO_MSGECLIENTINFO_STATE = "action_to_msgeclientinfo_state";
    //向活动详情传递活动地址
    public static final String ACTION_TO_ACTIVITY_DETAIL_URL = "action_to_activity_detail_url";
    //向活动详情传递活动名称
    public static final String ACTION_TO_ACTIVITY_DETAIL_NAME = "action_to_activity_detail_name";
    //向消息详情中传递ID
    public static final String ACTION_TO_MSG_DETAIL_ID = "action_to_msg_detail_id";

    public static final int ACTION_TO_HOMEFRAGMENT_REQUESTCODE = 101;
    public static final int ACTION_TO_HOMEFRAGMENT_RESULTCODE = 101;
    public static final int ACTION_TO_HOMEFRAGMENT_REQUESTCODE2 = 102;
    public static final int ACTION_TO_HOMEFRAGMENT_RESULTCODE2 = 102;
    public static final String ACTION_TO_HOMEFRAGMENT_BODYINFO = "action_to_homefragment_bodyinfo";
    public static final String ACTION_TO_HOMEFRAGMENT_POS = "action_to_homefragment_pos";


    //---------------------------------网络状态标识-------------------------------------------------
    /**
     * Unknown network class
     */
    public static final int NETWORK_CLASS_UNKNOWN = 0;

    /**
     * wifi net work
     */
    public static final int NETWORK_WIFI = 1;

    /**
     * "2G" networks
     */
    public static final int NETWORK_CLASS_2_G = 2;

    /**
     * "3G" networks
     */
    public static final int NETWORK_CLASS_3_G = 3;

    /**
     * "4G" networks
     */
    public static final int NETWORK_CLASS_4_G = 4;
}
