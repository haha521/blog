package com.hanyuebb.blog.common.baseservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanyuebb.blog.common.basedomain.BaseDomain;
import com.hanyuebb.blog.common.baseservice.BaseService;
import com.hanyuebb.blog.utils.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:BaseServiceImpl
 * Package:com.hanyuebb.blog.common.baseservice.impl
 * Description:
 *
 * @date:2020/1/30 21:44
 * @auther:zh
 */
@Transactional(readOnly = true)
public class BaseServiceImpl<T extends BaseDomain,D extends MyMapper<T>> implements BaseService<T> {

    @Autowired
    private D dao;


    @Override
    @Transactional(readOnly = true)
    public T selectById(Object o) {
        return dao.selectByPrimaryKey(o);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteById(Object o) {
        return dao.deleteByPrimaryKey(o);
    }

    @Override
    @Transactional(readOnly = false)
    public int updateById(T t) {
        return dao.updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int insert(T t) {
        return dao.insert(t);
    }

    @Override
    @Transactional(readOnly = true)
    public int selectCount(T t) {
        return dao.selectCount(t);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> select(T t) {
        return dao.select(t);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo page(int pageNum, int pageSize, T t) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum,pageSize);
        PageInfo<T> pageInfo = new PageInfo<T>(dao.select(t));
        return pageInfo;
    }
}
