package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbPerm;
import com.hanyuebb.blog.mapper.TbPermMapper;
import com.hanyuebb.blog.service.PermService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:PermServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:58
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class PermServiceImpl extends BaseServiceImpl<TbPerm, TbPermMapper> implements PermService<TbPerm> {
}
