package com.zqboot.utils.wxpay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by zhouquan on 2018/9/13.
 */
public class SimpleWxPayConfigImpl extends WXPayConfig {
    private InputStream certStream;
    private String appId;
    private String mchId;
    private String mchKey;

    /**
     * @param appId
     * @param mchId
     * @param mchKey（商户密钥）
     * @param certUrl（商户p12密钥文件路径）
     * @throws FileNotFoundException
     */
    public SimpleWxPayConfigImpl(String appId, String mchId, String mchKey, String certUrl) throws FileNotFoundException {
        this.appId = appId;
        this.mchId = mchId;
        this.mchKey = mchKey;
        this.certStream = new FileInputStream(certUrl);
    }

    @Override
    String getAppID() {
        return appId;
    }

    @Override
    String getMchID() {
        return mchId;
    }

    @Override
    String getKey() {
        return mchKey;
    }

    @Override
    InputStream getCertStream() {
        return certStream;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }
}
