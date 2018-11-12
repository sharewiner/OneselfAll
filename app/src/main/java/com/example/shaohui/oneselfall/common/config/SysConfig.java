package com.example.shaohui.oneselfall.common.config;

/**
 * 系统设置定数
 */
public class SysConfig {

    /**
     * 错误代码
     */
    public static final String ERROR_CODE_SUCCESS = "00000";
    /**
     * 错误代码
     */
    public static final String ERROR_CODE_FAILE = "10007";
    /**
     * 商家APP下载地址
     */
    public static final String BUSSINESS_APP_DOWNLOAD_URL = "http://download.xftzchina.com:8000/download_bussinessapp/";
    /**
     * 推送广播
     */
    public static final String PUSH_MESSAGE_ACTION = "com.xunku.qinlaozhifu.common.receiver";

    /**
     * 支付宝
     */
    // 商户PID
    public static final String PARTNER = "2088421640535316";
    // 商户收款账号
    public static final String SELLER = "1416285807@qq.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANuCTaXhGsyeJ8qTw19EWofzQ9u2x1jx5WCOttHLWZDShQVTTlqJX/QKgZbUIO96ujIdgLv4okj7UJLxlN1Z9MV/BFQu57yjsudOunraah+Ad6cIxrgIIzPcSWCvtYsPnTEBVimh10pFpdeaTRb8gmIaH/u6TmO00swtoit3V29PAgMBAAECgYAelwkVHcqrSzsGWxM1+oOXQIprWwxq08MAcsL9d5YyvXO2K0bXDR/nFXO7vjIczYCXLU9cYqjS/Nrcr3fsZPXcMeSha+DzZ2o3GeYseHz8JHP0LuyPCOV3tR1QxZJBoi/jdTxeKuE0xm4SnprA/UCnsa71AsyOG/FM/o4mnPBtaQJBAPAz7U5Dq7gjZ/4uzJokJ9JT0KaZ3t/mNDAzW69pBu+FjhmS774TLaIFy95AElN7F/oF2zRczshO0fADsYwyZoUCQQDp8fknJ4xFWh0Cau5WbrSs/PESWjPLTdP075fh+CrdXaNEJ7QCrESQfBwV0jjhYRJkTzJio0STSKrVyoHK4XjDAkEAr/xbkUvjNDY8qu5+2TBEPMVLycRSlpiDBA2czxeUDUk8o2AUZp6GgH7eryciRieZmYVQ5TxaBEg7aC5MlvsWQQJAMBVZ3mBUhlSVLdAImJ88Z2m9qsX7a0fdzrQIBZvaQ5FhYzq91ubNWN0JcLq6kig/fXqBoqBoEdWXt0VeE/LvvQJAOObdjIDEJdawhffKeYb1W6Nn8EnuBF71gaPUNJts1qIteoiTQ97KMJmpoWSdBojvB3jH8jtx4lQ5BzuPDhYYag==";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    public static final int SDK_PAY_FLAG = 1;
    public static final int SDK_CHECK_FLAG = 2;

    // 服务器异步通知页面路径
    // public static final String ALIPAY_NOTIFY_URL =
    // "http://notify.msp.hk/notify.htm";
    // 设置未付款交易的超时时间
    public static final String ALIPAY_OUTTIME = "15d";

    /**
     * 微信
     */
    // appid
    // 请同时修改 androidmanifest.xml里面，.PayActivity里的属性<data
    // android:scheme="wxb4ba3c02aa476ea1"/>为新设置的appid
    public static final String APP_ID = "wx4d5fa990e9695e89";
    // 商户号
    public static final String MCH_ID = "1381618102";
    // API密钥，在商户平台设置
    public static final String API_KEY = "dkOPfhuhsij272j2ui4u6h8i9hhuashd";
    // 服务器异步通知页面路径
    public static final String WXPAY_NOTIFY_URL = "wwww.baidu.com";
}
