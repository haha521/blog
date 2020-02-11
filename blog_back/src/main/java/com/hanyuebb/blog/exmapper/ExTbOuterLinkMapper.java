package com.hanyuebb.blog.exmapper;

import com.hanyuebb.blog.domain.TbOuterLink;
import com.hanyuebb.blog.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExTbOuterLinkMapper extends MyMapper<TbOuterLink> {

    List<TbOuterLink> selectOutLink();
}