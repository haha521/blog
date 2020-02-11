package com.hanyuebb.blog.service;

import com.hanyuebb.blog.common.basedomain.BaseDomain;
import com.hanyuebb.blog.common.baseservice.BaseService;
import com.hanyuebb.blog.domain.TbArticle;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ArticleService
 * Package:com.hanyuebb.blog.service
 * Description:
 *
 * @date:2020/1/30 22:47
 * @auther:zh
 */
public interface ArticleService<T extends BaseDomain> extends BaseService<T> {

    /**
     * 查询最新的三条数据心情随笔和学习笔记
     */
    Map<String,List> selectStudyAndEssay();

    List selectHotsArticle(String module);

    Map<String, Date> maxAndMinTime();

    /**
     * 按照年月查询数据
     */

    List<TbArticle> selectByYearAndMonth(Integer year,Integer month);


    int deleteArtAndMsgById(Integer articleId);

    Integer insertAndAddKindSum(TbArticle tbArticle);

    Integer updateAndUpdateKindSumById(TbArticle tbArticle);
}
