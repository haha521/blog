package com.hanyuebb.blog.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * ClassName:MyMapper
 * Package:com.hanyuebb.blog.utils
 * Description:
 *
 * @date:2020/1/30 20:21
 * @auther:zh
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}