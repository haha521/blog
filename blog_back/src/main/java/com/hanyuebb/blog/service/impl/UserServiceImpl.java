package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbBlogUser;
import com.hanyuebb.blog.mapper.TbBlogUserMapper;
import com.hanyuebb.blog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:UserServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 23:00
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<TbBlogUser, TbBlogUserMapper> implements UserService<TbBlogUser> {
}
