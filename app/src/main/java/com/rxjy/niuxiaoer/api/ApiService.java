package com.rxjy.niuxiaoer.api;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/9.
 */
public interface ApiService {


    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("actionapi/apphome/Login")
    Observable<String> getToken(
            @Field("cardNo") String cardNo,
            @Field("password") String password,
            @Field("postId") int postID
    );

    /**
     * 验证码登录
     */
    @FormUrlEncoded
    @POST("actionapi/apphome/Login")
    Observable<String> getTokenByCode(
            @Field("cardNo") String cardNo,
            @Field("vCode") String vCode,
            @Field("postId") int postID
    );

    /**
     * 获取注册验证码
     */
    @FormUrlEncoded
    @POST("AppAgent/SendVerifyCode")
    Observable<String> getVerificationCode(
            @Field("phone") String phoneNum
    );

    /**
     * 获取登录验证码
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/GetVcodeLanding")
    Observable<String> getVCodeLogin(
            @Field("phone") String phoneNum
    );

    /**
     * 获取忘记密码验证码
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/GetVcodeUpdatePwd")
    Observable<String> getVCodeForgetPassword(
            @Field("phone") String phoneNum
    );

    /**
     * 忘记密码修改密码
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/UpdatePassword_Vcode")
    Observable<String> updatePasswordByForget(
            @Field("phone") String phoneNum,
            @Field("newPassword") String newPassword,
            @Field("vCode") String vCode
    );

    /**
     * 修改密码
     */
    @GET("actionapi/apphome/UpdatePassword")
    Observable<String> updatePassword(
            @Query("cardNo") String cardNo,
            @Query("password") String password,
            @Query("newPassword") String newPassword,
            @Query("token") String token
    );

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/AddUser")
    Observable<String> getRegister(
            @Field("v_code") String code,
            @Field("a_account") String phoneNum,
            @Field("a_password") String password,
            @Field("depart_id") int areaID,
            @Field("post_name") String postName,
            @Field("post_id") int postID,
            @Field("sw_invitation_code") String invitationCode
    );

    /**
     * 获取用户信息
     */
    @GET("actionapi/apphome/GetUserMessage")
    Observable<String> getLoginUserInfo(
            @Query("cardNo") String cardNo,
            @Query("token") String token
    );

    /**
     * 新闻列表
     */
    @Multipart
    @POST("a/sap/sapArticle/getAppArticleList")
    Observable<String> getNewsList(
            @Part("cardNo") String cardNo,
            @Part("page") int pageIndex,
            @Part("rows") int pageSize
    );

    /**
     * 添加并提交量房
     */
    @Multipart
    @POST("HuiYuan/AddCustomer")
    Observable<String> UpAndSubmit(
            @Part("XingMing") String XingMing,
            @Part("ShouJiHaoYi") String ShouJiHaoYi,
            @Part("MianJi") String MianJi,
            @Part("LeiXingYi") String LeiXingYi,
            @Part("LeiXingEr") String LeiXingEr,
            @Part("GongSiMingCheng") String GongSiMingCheng,
            @Part("LiangFangDiZhi") String LiangFangDiZhi,
            @Part("KaHao") String KaHao,
            @Part("FangYuan") String FangYuan,
            @Part("BeiZhu") String BeiZhu,
            @Part("Package_type") String Package_type,
            @Part("ZhuangTai") String ZhuangTai,
            @Part("FenGongSiID") int FenGongSiID
    );


    /**
     * 获取客户信息列表
     */

    @GET("HuiYuan/GetOrderList")
    Observable<String> GetClientMsgList(
            @Query("card_no") String cardNo,
            @Query("state") String state,
            @Query("serviceType") String serviceType,
            @Query("keyName") String key
    );

    /**
     * 获取套餐和客户类型相关信息
     */
    @GET("AppAgent/CustomerProperty")
    Observable<String> getTc(
            @Query("type") String type
    );
//------------------------------------------------------------------------------------

    /**
     * 获取钱包信息
     */
    @GET("HuiYuan/GetMemBerMoney")
    Observable<String> getWalletInfo(
            @Query("MemberCard") String cardNo
    );

    /**
     * 获取收支明细数据接口
     */
    @GET("HuiYuan/ShouZhiMingXiList")
    Observable<String> getWalletRecord(
            @Query("KaHao") String cardNo,
            @Query("PageIndex") int pageIndex,
            @Query("PageSize") int pageSize
    );

    /**
     * 获取是否有支付密码
     */
    @GET("HuiYuan/IsSetPassword")
    Observable<String> getIsHavePwd(
            @Query("cardNo") String cardNo
    );

    /**
     * 新增或修改银行卡信息
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/UpdateMyBankInfo")
    Observable<String> subAddOrUpd(
            @Field("token") String token,
            @Field("cardNo") String cardNo,
            @Field("bankCard") String bankCard,
            @Field("bankName") String bankName,
            @Field("bankUserName") String bankUserName
    );

    /**
     * 提现密码
     */
    @Multipart
    @POST("HuiYuan/MemberWithdrawals")
    Observable<String> getWithdrawals(
            @Part("MemberCard") String cardNo,
            @Part("WithDrawalsMoney") double price,
            @Part("MemberBankCard") String cardNum,
            @Part("MemberBankName") String bankName,
            @Part("MemberName") String memberCard,
            @Part("PayPassword") String pwd
    );

    /**
     * 设置支付密码
     */
    @Multipart
    @POST("HuiYuan/SetPassword")
    Observable<String> setBankCardPwd(
            @Part("cardNo") String cardNo,
            @Part("payPassword") String pwd
    );
//--------------------------------------------------------获取订单详情

    /**
     * 获取客户信息详情
     */
    @GET("HuiYuan/GetCustomerInfo")
    Observable<String> getMsgeOrdersDetail(
            @Query("customerID") int customerID
    );

    /**
     * 获取客户类型数据
     */
    @GET("HuiYuan/GetCusTomerType")
    Observable<String> getClientType();

    /**
     * 修改客户信息接口
     */
    @Multipart
    @POST("/HuiYuan/UpdateCustomer")
    Observable<String> saveOrdersDetail(
            @Part("KeHuBaseID") int customID,
            @Part("XingMing") String XingMing,
            @Part("ShouJiHaoYi") String ShouJiHaoYi,
            @Part("MianJi") String MianJi,
            @Part("LeiXingYi") String LeiXingYi,
            @Part("LeiXingEr") String LeiXingEr,
            @Part("GongSiMingCheng") String GongSiMingCheng,
            @Part("LiangFangDiZhi") String LiangFangDiZhi,
            @Part("KaHao") String KaHao,
            @Part("FangYuan") String FangYuan,
            @Part("BeiZhu") String BeiZhu,
            @Part("Package_type") String Package_type,
            @Part("ZhuangTai") String ZhuangTai,
            @Part("FenGongSiID") int FenGongSiID
    );

    /**
     * 新增客户信息接口
     */
    @Multipart
    @POST("HuiYuan/AddCustomer")
    Observable<String> subOrdersDetail(
            @Part("KeHuBaseID") int customerID,
            @Part("KaHao") String cardNo,
            @Part("type") int type,
            @Part("ZhuangTai") int state,
            @Part("FenGongSiID") int filialeID,
            @Part("XingMing") String clientName,
            @Part("ShouJiHaoYi") String phoneNum,
            @Part("GongSiMingCheng") String companyName,
            @Part("ZhuangXiuYuSuan") double priceUnit,
            @Part("MianJi") double acreage,
            @Part("BanGongDiDian") String businessAddress,
            @Part("LiangFangDiZhi") String measureAddress,
            @Part("YuJiZhuangXiuShiJian") int ornamentTime,
            @Part("Duration") int timeProject,
            @Part("ZuQiKaiShi") String startTime,
            @Part("ZuQiJieShu") String endTime,
            @Part("YuJiLiangFang") String measureTime,
            @Part("LeiXingYi") int clientDemandOne,
            @Part("LeiXingEr") int clientDemandTwo,
            @Part("FangYuan") int resourceState,
            @Part("YuJiZhuangXiu") int houseState,
            @Part("ShenFenID") int administration,
            @Part("Decoration_demand") int desDemand,
            @Part("ChengJiaoLeiXing") int transactionType,
            @Part("ZhuZhongDianID") int limeLight
    );

    /**
     * 修改用户信息
     */
    @FormUrlEncoded
    @POST("actionapi/AppHome/UpdateMyInfo")
    Observable<String> updateUserInfo(
            @Field("token") String token,
            @Field("cardNo") String cardNo,
            @Field("key") String key,
            @Field("value") String value
    );

    /**
     * 上传头像
     */
    @Multipart
    @POST("actionapi/AppHome/UpdateImages")
    Observable<String> upHeaderPicture(
            @Part("token") String token,
            @Part("cardNo") String cardNo,
            @Part("type") String type,
            @Part MultipartBody.Part file
    );

    /**
     * Tab获取未读状态接口
     */
    @GET("HuiYuan/RedDian")
    Observable<String> getTabState(
            @Query("Card") String card
    );

    /**
     * Tab获取未读状态接口
     */
    @GET("HuiYuan/XinXiRedDian")
    Observable<String> getMineState(
            @Query("Card") String card
    );

    /**
     * 删除客户接口
     */
    @GET("HuiYuan/DelUnion")
    Observable<String> delClientInfo(
            @Query("DanHao") String clientID
    );

    /**
     * 获取盟友列表
     */
    @GET("HuiYuan/MengYouList")
    Observable<String> getAllyList(
            @Query("Card") String card
    );

    /**
     * 加入联盟接口
     */
    @Multipart
    @POST("HuiYuan/AddUnion")
    Observable<String> joinUnion(
            @Part("Card") String card,
            @Part("ShCard") String superiorCard
    );

    /**
     * 验证邀请码
     */
    @Multipart
    @POST("HuiYuan/VerifyInvitation")
    Observable<String> getYaoQingMa(
            @Part("Card") String card
    );

    /**
     * 分公司下拉框
     */
    @GET("HuiYuan/GetFenGongSi")
    Observable<String> getFenGongSi(
    );

    /**
     * 注册时同步隶属关系，赋予分公司
     */
    @Multipart
    @POST("HuiYuan/GetMemberInfo")
    Observable<String> getMemberInfo(
            @Part("card") String card,
            @Part("card") String phone,
            @Part("card") String shcard

    );

    /**
     * 获取详细列表
     */
    @GET("HuiYuan/XinXiList")
    Observable<String> getMsgList(
            @Query("Card") String cardNo
    );

    /**
     * 获取活动列表失败
     */
    @GET("HuiYuan/HuoDongList")
    Observable<String> getActivityList(

    );

    /**
     * 获取消息详情
     */
    @GET("HuiYuan/XinXiXiangXi")
    Observable<String> getMsgDetail(
            @Query("XinID") int xinID
    );

    //---------------------------new

    /**
     * 新首页数据
     */
    @GET("HuiYuan/AppLiShuList")
    Observable<String> getNewShouyeData(
            @Query("Card") String Card,
            @Query("Key") String Key
    );
    /**
     * 新 新增客户获取单号
     */
    @GET("HuiYuan/CreateDanHao")
    Observable<String> getNewDanHao(
            @Query("Card") String Card
    );

    /**
     *
     * 价格列表，存储App中
     */
    @GET("HuiYuan/ZiDuanPrice")
    Observable<String> getNewZiDuanPrice(
    );

    /**
     * 添加客户第一步
     */
    //获取数据
    @GET("HuiYuan/XunJiaJiBen")
    Observable<String> getjiben(
            @Query("DanHao") String DanHao
    );

    //获取行业下拉框数据
    @GET("HuiYuan/XunJiaHangYeSelect")
    Observable<String> getjibenXialakuang(
    );



    //上传数据（新）
    @GET("HuiYuan/XunJiaJiBenAdd")
    Observable<String> upjibenNew(
            @Query("DanHao") String DanHao,
            @Query("GongSiMingCheng") String GongSiMingCheng,
            @Query("BanGongDiDian") String BanGongDiDian,
            @Query("LeiXingYi") int LeiXingYi,
            @Query("PingGuPrice") double PingGuPrice,
            @Query("Phone") String Phone,
            @Query("XingMing") String XingMing,
            @Query("SparePhone") String SparePhone
    );

    //上传数据
    @GET("HuiYuan/XunJiaJiBenUpdate")
    Observable<String> upjiben(
            @Query("DanHao") String DanHao,
            @Query("GongSiMingCheng") String GongSiMingCheng,
            @Query("BanGongDiDian") String BanGongDiDian,
            @Query("LeiXingYi") int LeiXingYi,
            @Query("PingGuPrice") double PingGuPrice
    );

    /**
     * 添加客户第二步
     */
    //获取数据
    @GET("HuiYuan/XunJiaKeHu")
    Observable<String> getxunjia(
            @Query("DanHao") String DanHao
    );

    //获取行业下拉框数据
    @GET("HuiYuan/XunJiaNianLingSelect")
    Observable<String> getxunjiaXialakuang(
    );

    @GET("HuiYuan/XunJiaShenFenSelect")
    Observable<String> getxunjiaShenfenXialakuang(
    );

    @GET("HuiYuan/XunJiaZhuZhongSelect")
    Observable<String> getxunjiaZhuzhongXialakuang(
    );

    //上传数据
    @GET("HuiYuan/XunJiaKeHuUpdate")
    Observable<String> upxunjia(
            @Query("DanHao") String DanHao,
            @Query("ShenFenID") int ShenFenID,
            @Query("NianLingID") int NianLingID,
            @Query("XingMing") String XingMing,
            @Query("WeiXin") String WeiXin,
            @Query("ZhuZhongDianID") int ZhuZhongDianID,
            @Query("PingGuPrice") double PingGuPrice
    );

    /**
     * 添加客户第三步
     */
    //获取数据
    @GET("HuiYuan/XunJiaFangYuan")
    Observable<String> getxunjiaFangyuan(
            @Query("DanHao") String DanHao
    );

    //上传数据
    @GET("HuiYuan/XunJiaFangYuanUpdate")
    Observable<String> upxunjiaFangyuan(
            @Query("DanHao") String DanHao,
            @Query("MianJi") double MianJi,
            @Query("ChengJiaoLeiXing") int ChengJiaoLeiXing,
            @Query("MianZuQi") int MianZuQi,
            @Query("JiaoFangShiJian") String JiaoFangShiJian,
            @Query("YuJiZhuangXiu") int YuJiZhuangXiu,
            @Query("PingGuPrice") double PingGuPrice,
            @Query("FangYuan") int FangYuan
    );

    /**
     * 添加客户第四步
     */
    //获取数据
    @GET("HuiYuan/XunJiaXuQiu")
    Observable<String> getxunjiaXuqiu(
            @Query("DanHao") String DanHao
    );

    //上传数据
    @GET("HuiYuan/XunJiaXuQiuUpdate")
    Observable<String> upxunjiaXuqiu(
            @Query("DanHao") String DanHao,
            @Query("LiangFangDiZhi") String LiangFangDiZhi,
            @Query("ZhuangXiuXuQiu") int ZhuangXiuXuQiu,
            @Query("YuJiLiangFang") String YuJiLiangFang,
            @Query("GongQi") String GongQi,
            @Query("ZhuangXiuYuSuan") double ZhuangXiuYuSuan,
            @Query("PingGuPrice") double PingGuPrice,
            @Query("ZhaoBiao") int ZhaoBiao,
            @Query("YuJiZhuangXiuShiJian") String YuJiZhuangXiuShiJian
    );

    /**
     * 添加客户第五步
     */
    //获取数据
    @GET("HuiYuan/XunJiaLouPan")
    Observable<String> getxunjiaLoupan(
            @Query("DanHao") String DanHao
    );

    //上传数据
    @GET("HuiYuan/XunJiaLouPanUpdate")
    Observable<String> upxunjiaLoupan(
            @Query("DanHao") String DanHao,
            @Query("QiYeGuiMoID") int QiYeGuiMoID,
            @Query("BuildName") String BuildName,
            @Query("LouPanQiZuo") String LouPanQiZuo,
            @Query("PingGuPrice") double PingGuPrice,
            @Query("SubmitType") int SubmitType
    );

    //带入客户姓名
    @GET("HuiYuan/KeHuXingMing")
    Observable<String> getKehuxingming(
            @Query("DanHao") String DanHao
    );

    //保存或者提交
    @GET("HuiYuan/BaoCunOrSubmit")
    Observable<String> UpBaoCunOrSubmit(
            @Query("DanHao") String DanHao,
            @Query("Phone") String Phone,
            @Query("XingMing") String XingMing,
            @Query("SubmitType") int SubmitType
    );

    //项目信息详情页
    @GET("HuiYuan/ItemInfo")
    Observable<String> getProjectInfo(
            @Query("DanHao") String DanHao
    );

    //项目打回详情页
    @GET("HuiYuan/DaHuiInfo")
    Observable<String> getProjectDahuiInfo(
            @Query("DanHao") String DanHao
    );

    //质检报告详情页
    @GET("HuiYuan/ZhiJianBaoGao")
    Observable<String> getZhijianbaogaoInfo(
            @Query("DanHao") String DanHao
    );

    //质检报告合格与否
    @GET("HuiYuan/ZhiJianHeGe")
    Observable<String> getZhijianhegeInfo(
            @Query("DanHao") String DanHao,
            @Query("Type") int Type
    );

    /**
     * 获取设备IP
     */
    @GET
    Observable<String> getIP(
            @Url String url
    );


    /**
     * 上传应用信息
     */
    @FormUrlEncoded
    @POST("actionapi/apphome/AddlandingMessage")
    Observable<String> subAppInfo(
            @Field("card_no") String cardNo,
            @Field("locate_province_now") String province,
            @Field("locate_city_now") String city,
            @Field("a_equipment") String equipment,
            @Field("a_ip") String ip,
            @Field("network_status") String netWorkStatus
    );

    /**
     * 获取银行卡列表
     */
    @GET("actionapi/AppHome/GetBankList")
    Observable<String> getBankListInfo(

    );


    /**
     * 验证客户手机号
     */
    @Multipart
    @POST("AppEmployee/VerificationPhone")
    Observable<String> postCustomerPhone(
            @Part("phone") String phone
    );

}
