package com.hanyuebb.blog.common.exception;

import com.hanyuebb.blog.common.result.BaseResult;
import com.hanyuebb.blog.common.result.BaseResultBulider;
import com.hanyuebb.blog.common.result.ResultCode;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:GlobalExceptionHandler
 * Package:com.hanyuebb.blog.common.result
 * Description:
 *
 * @date:2020/1/30 20:49
 * @auther:zh
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public BaseResult bizExceptionHandler(HttpServletRequest req, BizException e){
        logger.error("发生业务异常！原因是：{}",e.getResultCode().getMsg());
        return BaseResultBulider.faile(e.getResultCode());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public BaseResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return BaseResultBulider.faile(ResultCode.PARAM_IS_BLANK);
    }


    @ExceptionHandler(value = UnknownAccountException.class)
    @ResponseBody
    public BaseResult exceptionHandler(HttpServletRequest req, UnknownAccountException e){
        //logger.error("发生空指针异常！原因是:",e);
        return BaseResultBulider.faile(ResultCode.USER_LOGIN_ERROR);
    }

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    @ResponseBody
    public BaseResult exceptionHandler(HttpServletRequest req, IncorrectCredentialsException e){
        //logger.error("发生空指针异常！原因是:",e);
        return BaseResultBulider.faile(ResultCode.USER_LOGIN_ERROR);
    }

    @ExceptionHandler(value = LockedAccountException.class)
    @ResponseBody
    public BaseResult exceptionHandler(HttpServletRequest req, LockedAccountException e){
        //logger.error("发生空指针异常！原因是:",e);
        return BaseResultBulider.faile(ResultCode.USER_ACCOUNT_FORBIDDEN);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public BaseResult exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return BaseResultBulider.faile(ResultCode.SYSTEM_INNER_ERROR);
    }
}