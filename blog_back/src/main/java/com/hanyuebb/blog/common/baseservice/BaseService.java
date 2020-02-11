package com.hanyuebb.blog.common.baseservice;

import com.github.pagehelper.PageInfo;
import com.hanyuebb.blog.common.basedomain.BaseDomain;

import java.util.List;

/**
 * ClassName:BaseService
 * Package:com.hanyuebb.blog.common.baseservice
 * Description:
 *
 * @date:2020/1/30 21:43
 * @auther:zh
 */
public interface BaseService<T extends BaseDomain> {

    /**
     * 根据主键查询，得到实体类
     */
    T selectById(Object o);

    /**
     * 根据主键删除
     */
    int deleteById(Object o);

    /**
     * 根据主键更新,传入实体属性为空不更新
     */
    int updateById(T t);

    /**
     * 添加
     */
    int insert(T t);

    /**
     * 查询数量
     */
    int selectCount(T t);

    /**
     * 条件查询，得到实体类
     */
    List<T> select(T t);

    /**
     * 分页查询
     */
    PageInfo<T> page(int pageNum, int pageSize, T t);
}
