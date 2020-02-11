package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbUploadFile;
import com.hanyuebb.blog.mapper.TbUploadFileMapper;
import com.hanyuebb.blog.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:UploadServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:59
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class UploadServiceImpl extends BaseServiceImpl<TbUploadFile, TbUploadFileMapper> implements UploadService<TbUploadFile> {
}
