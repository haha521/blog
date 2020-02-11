package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbRole;
import com.hanyuebb.blog.mapper.TbRoleMapper;
import com.hanyuebb.blog.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:RoleServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:59
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class RoleServiceImpl extends BaseServiceImpl<TbRole, TbRoleMapper> implements RoleService<TbRole> {
}
