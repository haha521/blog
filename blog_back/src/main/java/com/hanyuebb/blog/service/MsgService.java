package com.hanyuebb.blog.service;

import com.hanyuebb.blog.common.basedomain.BaseDomain;
import com.hanyuebb.blog.common.baseservice.BaseService;
import com.hanyuebb.blog.domain.TbLeavingMsg;

import java.util.List;

/**
 * ClassName:MsgService
 * Package:com.hanyuebb.blog.service
 * Description:
 *
 * @date:2020/1/30 22:50
 * @auther:zh
 */
public interface MsgService<T extends BaseDomain> extends BaseService<T> {

    List<TbLeavingMsg> selectMsg();
}
