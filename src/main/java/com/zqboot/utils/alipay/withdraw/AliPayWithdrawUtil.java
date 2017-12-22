package com.zqboot.utils.alipay.withdraw;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.zqboot.utils.alipay.configandutil.AlipayConfig;
import com.zqboot.utils.alipay.configandutil.WithdrawSubmit;

import java.util.Date;

/**
 * Created by zhouquan on 2017/8/1.
 * 支付宝提现
 */
public class AliPayWithdrawUtil {

    /**
     * 支付宝提现
     * 文档链接：https://docs.open.alipay.com/309/106235/
     *
     * @param withdrawSubmit
     * @return
     * @throws AlipayApiException
     */
    public boolean doWithdraw(WithdrawSubmit withdrawSubmit) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.APP_ID, AlipayConfig.ALIPAY_PRIVATE_KEY,
                "json", "utf-8", AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        request.setBizContent(withdrawSubmit.toString());
        AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws AlipayApiException {
        WithdrawSubmit withdrawSubmit = new WithdrawSubmit();
        withdrawSubmit.setAmount(1.0);
        withdrawSubmit.setOut_biz_no(new Date().getTime() + "");
        withdrawSubmit.setPayee_account("wangdachui@qq.com");
        withdrawSubmit.setPayee_real_name("王大锤");
        withdrawSubmit.setPayer_show_name("某某公司");
        withdrawSubmit.setRemark("测试转账");
    }

}
