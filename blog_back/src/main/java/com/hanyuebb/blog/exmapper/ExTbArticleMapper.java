package com.hanyuebb.blog.exmapper;

import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.utils.MyMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExTbArticleMapper extends MyMapper<TbArticle> {

    List<TbArticle> selectStudy(String module);

    List<TbArticle> selectEassy(String module);

    /**
     * 查询热门文章，也就是浏览人数前五条数据
     */
    List<TbArticle> selectHotsArticle(String module);

    Date selectMaxTime();

    Date selectMinTime();

    List<TbArticle> selectByYearAndMonth(Integer year,Integer month);
}