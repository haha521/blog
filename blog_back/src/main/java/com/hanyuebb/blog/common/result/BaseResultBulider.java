package com.hanyuebb.blog.common.result;

/**
 * ClassName:BaseResultBulider
 * Package:com.hanyuebb.myblog.common.result
 * Description:
 *
 * @date:2020/1/17 11:29
 * @auther:zh
 */
public class BaseResultBulider {
    //成功，不返回具体数据
    public static <T> BaseResult<T> successNoData(ResultCode code){
        BaseResult<T> result = new BaseResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }
    //成功，返回数据
    public static <T> BaseResult<T> success(T t,ResultCode code){
        BaseResult<T> result = new BaseResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        result.setData(t);
        return result;
    }

    //失败，返回失败信息
    public static <T> BaseResult<T> faile(ResultCode code){
        BaseResult<T> result = new BaseResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }
}
