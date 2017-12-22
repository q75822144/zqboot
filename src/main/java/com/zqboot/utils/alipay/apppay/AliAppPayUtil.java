package com.zqboot.utils.alipay.apppay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.zqboot.utils.ThirdPartConfigUtil;
import com.zqboot.utils.alipay.configandutil.AlipayConfig;

import java.util.Map;

/**
 * Created by zhouquan on 2017/12/22.
 */
public class AliAppPayUtil {

    /**
     * 发起app支付
     * 文档地址：https://docs.open.alipay.com/54/106370
     *
     * @param orderNumber（订单号）
     * @param money（支付金额）
     * @return
     */
    public static String doAppPay(String orderNumber, double money) throws AlipayApiException {
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                AlipayConfig.APP_ID, AlipayConfig.ALIPAY_PRIVATE_KEY, "json", "utf-8", AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("GOJI");
        model.setSubject("GOJI");
        model.setOutTradeNo(orderNumber);
        model.setTimeoutExpress("30m");
        model.setTotalAmount(money + "");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl(ThirdPartConfigUtil.getRegByName("domain_name") + "aliAppPayCallBack");
        //这里和普通的接口调用不同，使用的是sdkExecute
        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        //System.out.println("^_^"+response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
        return response.getBody();

    }

    public static boolean rsaCheckV1(Map<String,String> map) throws AlipayApiException {
        return AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, "utf-8", "RSA2");
    }

}
