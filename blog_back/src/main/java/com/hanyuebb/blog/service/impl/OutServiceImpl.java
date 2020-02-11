package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbOuterLink;
import com.hanyuebb.blog.exmapper.ExTbOuterLinkMapper;
import com.hanyuebb.blog.mapper.TbOuterLinkMapper;
import com.hanyuebb.blog.service.OutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:OutServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:58
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class OutServiceImpl extends BaseServiceImpl<TbOuterLink, TbOuterLinkMapper> implements OutService<TbOuterLink> {
    @Autowired
    ExTbOuterLinkMapper exTbOuterLinkMapper;

    @Override
    public List<TbOuterLink> selectOutLink() {
        return exTbOuterLinkMapper.selectOutLink();
    }
}
