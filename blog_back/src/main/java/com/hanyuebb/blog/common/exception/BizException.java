package com.hanyuebb.blog.common.exception;

import com.hanyuebb.blog.common.result.ResultCode;

/**
 * ClassName:BizException
 * Package:com.hanyuebb.blog.common.result
 * Description:
 *
 * @date:2020/1/30 20:53
 * @auther:zh
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private ResultCode resultCode;

    public BizException(ResultCode resultCode){
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}