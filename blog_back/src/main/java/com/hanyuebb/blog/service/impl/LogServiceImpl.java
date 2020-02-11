package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbOperateLog;
import com.hanyuebb.blog.mapper.TbOperateLogMapper;
import com.hanyuebb.blog.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:LogServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:57
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class LogServiceImpl extends BaseServiceImpl<TbOperateLog, TbOperateLogMapper> implements LogService<TbOperateLog> {
}
