package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbArticleKind;
import com.hanyuebb.blog.domain.TbLeavingMsg;
import com.hanyuebb.blog.exmapper.ExTbArticleKindMapper;
import com.hanyuebb.blog.exmapper.ExTbArticleMapper;
import com.hanyuebb.blog.exmapper.ExTbLeavingMsgMapper;
import com.hanyuebb.blog.mapper.TbArticleMapper;
import com.hanyuebb.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * ClassName:ArticleService
 * Package:com.hanyuebb.blog.service
 * Description:
 *
 * @date:2020/1/30 22:47
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl extends BaseServiceImpl<TbArticle, TbArticleMapper> implements ArticleService<TbArticle> {
    @Autowired
    ExTbArticleMapper exTbArticleMapper;

    @Autowired
    ExTbLeavingMsgMapper exTbLeavingMsgMapper;

    @Autowired
    ExTbArticleKindMapper exTbArticleKindMapper;

    @Override
    @Transactional(readOnly = true)
    public Map<String,List> selectStudyAndEssay() {
        List<TbArticle> studeys = exTbArticleMapper.selectStudy("学习笔记模块");

        List<TbArticle> essays = exTbArticleMapper.selectEassy("心情随笔模块");
        Map<String,List> map = new HashMap<>();
        map.put("studys",studeys);
        map.put("essays",essays);
        return map;
    }

    @Override
    @Transactional(readOnly = true)
    public List selectHotsArticle(String module) {
        return exTbArticleMapper.selectHotsArticle(module);
    }


    @Transactional(readOnly = true)
    public Map<String, Date> maxAndMinTime(){
        Map<String,Date> map = new HashMap<>();
        map.put("max", exTbArticleMapper.selectMaxTime());
        map.put("min", exTbArticleMapper.selectMinTime());
        return map;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TbArticle> selectByYearAndMonth(Integer year, Integer month) {
        return exTbArticleMapper.selectByYearAndMonth(year,month);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteArtAndMsgById(Integer articleId) {
        TbArticle tbArticle = exTbArticleMapper.selectByPrimaryKey(articleId);
        Map<String,String> map = new HashMap<>();
        map.put("module",tbArticle.getModule());
        map.put("type",tbArticle.getType());
        map.put("classify",tbArticle.getClassify());
        exTbArticleKindMapper.sumSubOne(map);
        exTbArticleMapper.deleteByPrimaryKey(articleId);
        TbLeavingMsg tbLeavingMsg = new TbLeavingMsg();
        tbLeavingMsg.setArticleId(articleId);
        exTbLeavingMsgMapper.delete(tbLeavingMsg);
        return 1;
    }

    @Override
    @Transactional(readOnly = false)
    public Integer insertAndAddKindSum(TbArticle tbArticle) {
        Map<String,String> map = new HashMap<>();
        map.put("module",tbArticle.getModule());
        map.put("type",tbArticle.getType());
        map.put("classify",tbArticle.getClassify());
        exTbArticleKindMapper.sumAddOne(map);
        exTbArticleMapper.insert(tbArticle);
        return 1;
    }

    /**
     * 修改文章类型之后需要修改类型中的sum
     * @param tbArticle
     * @return
     */

    @Override
    @Transactional(readOnly = false)
    public Integer updateAndUpdateKindSumById(TbArticle tbArticle) {
        TbArticle tbArticle1 = exTbArticleMapper.selectByPrimaryKey(tbArticle.getArticleId());
        Map<String,String> map = new HashMap<>();
        map.put("module",tbArticle1.getModule());
        map.put("type",tbArticle1.getType());
        map.put("classify",tbArticle1.getClassify());
        exTbArticleKindMapper.sumSubOne(map);
        Map<String,String> map1 = new HashMap<>();
        map1.put("module",tbArticle.getModule());
        map1.put("type",tbArticle.getType());
        map1.put("classify",tbArticle.getClassify());
        exTbArticleKindMapper.sumAddOne(map1);
        exTbArticleMapper.insert(tbArticle);
        return 1;
    }
}
