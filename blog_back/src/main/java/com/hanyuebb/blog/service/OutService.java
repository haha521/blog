package com.hanyuebb.blog.service;

import com.hanyuebb.blog.common.basedomain.BaseDomain;
import com.hanyuebb.blog.common.baseservice.BaseService;
import com.hanyuebb.blog.domain.TbOuterLink;

import java.util.List;

/**
 * ClassName:OutService
 * Package:com.hanyuebb.blog.service
 * Description:
 *
 * @date:2020/1/30 22:51
 * @auther:zh
 */
public interface OutService<T extends BaseDomain> extends BaseService<T> {

    List<TbOuterLink> selectOutLink();
}
