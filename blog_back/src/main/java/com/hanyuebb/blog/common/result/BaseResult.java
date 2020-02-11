package com.hanyuebb.blog.common.result;

/**
 * ClassName:BaseResult
 * Package:com.hanyuebb.myblog.common.result
 * Description:
 *
 * @date:2020/1/17 11:25
 * @auther:zh
 */
public class BaseResult<T> {
    private int code;
    private String msg;
    private T data;// 数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
