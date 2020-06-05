package com.ciao.webfluxmysqldemo.constant;

public interface CommonConstants {
    /**
     * 成功标记
     */
    Integer SUCCESS = 0;
    String SUCCESS_MSG = "success";
    /**
     * 失败标记
     */
    Integer FAIL = 1;
    String FAIL_MSG = "fail";

    Integer MENU = 0;
    Integer BUTTON = 1;

    String DEFAULT_PASSWORD = "123456";

    Integer DEL_FLAG_NORMAL = 0;

    Integer COMPANY = 1;
    Integer AGENT = 2;
    Integer OFFICE = 3;
    Integer Merchant = 4;
    String UPPER_BUSINESS_DICT_TYPE = "upperBusiness";
    Integer UPPER_BUSINESS_DICT_SORT = 3;

    // 商户结算卡审核状态通过
    Integer MER_SETTLEMENT_CHECK_S = 1;
    // 商户结算卡审核状态失败
    Integer MER_SETTLEMENT_CHECK_F = 2;
    // 商户结算卡审核状态未审核
    Integer MER_SETTLEMENT_UNCHECK = 0;

    String EZY_SYS_MER_ID = "M888888888888";






}
