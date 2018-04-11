package com.zqboot.exception;

import com.zqboot.constant.CodeConstants;
import com.zqboot.constant.Constants;
import com.zqboot.utils.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 公共异常拦截
 * Created by zhouquan on 2018/4/4.
 */
@ControllerAdvice
public class CommonExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler
    public void dealException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ResultResponse resp = new ResultResponse();
        if (ex instanceof BusinessException) {
            BusinessException exception = (BusinessException) ex;
            resp.setCode(exception.getCode());
            resp.setMsg(exception.getMsg());
            resp.setResult(false);
            log.error("业务异常，错误信息为：", ex);
        } else {
            resp.setResult(false);
            resp.setMsg(Constants.SYS_ERROR);
            resp.setCode(CodeConstants.SYSTEM_ERROR);
            log.error("系统异常，错误信息为：", ex);
        }
        resp.write(response);
    }
}
