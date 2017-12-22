package com.zqboot.utils.alipay.apppay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhouquan on 2017/12/22.
 */
@Controller
public class AliAppPayApiController {

    @RequestMapping(value = "/aliAppPayCallBack")
    public void aliPayCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        PrintWriter out = response.getWriter();
//        response.setContentType("text/html;charset=utf-8");
        // 获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"),
            // "utf-8");
            params.put(name, valueStr);
        }
        // 切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        // boolean AlipaySignature.rsaCheckV1(Map<String, String> params,
        // String publicKey, String charset, String sign_type)
        if (AliAppPayUtil.rsaCheckV1(params)) {
            //校验成功，业务逻辑
        } else {
            throw new Exception("支付宝参数校验失败");
        }
    }
}
