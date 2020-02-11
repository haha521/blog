package com.hanyuebb.blog.service.impl;

import com.hanyuebb.blog.common.baseservice.impl.BaseServiceImpl;
import com.hanyuebb.blog.common.po.Children;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbArticleKind;
import com.hanyuebb.blog.exmapper.ExTbArticleKindMapper;
import com.hanyuebb.blog.exmapper.ExTbArticleMapper;
import com.hanyuebb.blog.mapper.TbArticleKindMapper;
import com.hanyuebb.blog.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ClassName:KindServiceImpl
 * Package:com.hanyuebb.blog.service.impl
 * Description:
 *
 * @date:2020/1/30 22:57
 * @auther:zh
 */
@Service
@Transactional(readOnly = true)
public class KindServiceImpl extends BaseServiceImpl<TbArticleKind, TbArticleKindMapper> implements KindService<TbArticleKind> {


    @Autowired
    ExTbArticleKindMapper exTbArticleKindMapper;

    @Autowired
    ExTbArticleMapper exTbArticleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TbArticleKind> selectType(String module) {
        return exTbArticleKindMapper.selectType(module);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Children> selectClassify(String type) {
        return exTbArticleKindMapper.selectClassify(type);
    }

    @Override
    @Transactional(readOnly = false)
    public Integer delKindAndArt(Integer id) {
        TbArticleKind tbArticleKind = exTbArticleKindMapper.selectByPrimaryKey(id);
        TbArticle tbArticle = new TbArticle();
        tbArticle.setModule(tbArticleKind.getModule());
        tbArticle.setType(tbArticleKind.getType());
        tbArticle.setClassify(tbArticleKind.getClassify());
        exTbArticleMapper.delete(tbArticle);
        exTbArticleKindMapper.deleteByPrimaryKey(id);
        return 1;
    }
}
