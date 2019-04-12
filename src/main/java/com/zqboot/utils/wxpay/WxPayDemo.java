package com.zqboot.utils.wxpay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhouquan on 2018/9/14.
 */
@Component
@ConfigurationProperties(prefix = "pay.wxpay")
public class WxPayDemo {

    /** 公众账号ID */
    private String appID;

    /** 商户号 */
    private String mchID;

    /** API 密钥 */
    private String key;

    public String getAppID() {
        return appID;
    }

    public String getMchID() {
        return mchID;
    }

    public String getKey() {
        return key;
    }
}
