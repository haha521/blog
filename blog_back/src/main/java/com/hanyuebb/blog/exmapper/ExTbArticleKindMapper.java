package com.hanyuebb.blog.exmapper;

import com.hanyuebb.blog.common.po.Children;
import com.hanyuebb.blog.domain.TbArticleKind;
import com.hanyuebb.blog.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExTbArticleKindMapper extends MyMapper<TbArticleKind> {

    List<TbArticleKind> selectType(String module);

    List<Children> selectClassify(String type);

    void sumAddOne(Map<String,String> map);

    void sumSubOne(Map<String,String> map);
}