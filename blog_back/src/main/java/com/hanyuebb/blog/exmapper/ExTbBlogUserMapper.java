package com.hanyuebb.blog.exmapper;

import com.hanyuebb.blog.domain.TbBlogUser;
import com.hanyuebb.blog.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExTbBlogUserMapper extends MyMapper<TbBlogUser> {
}