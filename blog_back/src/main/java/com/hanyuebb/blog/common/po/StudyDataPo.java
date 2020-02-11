package com.hanyuebb.blog.common.po;

import com.hanyuebb.blog.common.result.ResultPage;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbArticleKind;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:StudyDataPo
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/6 12:37
 * @auther:zh
 */
@Data
public class StudyDataPo implements Serializable {
    private static final long serialVersionUID = 1L;

    //学习笔记及其分页信息
    private ResultPage<TbArticle> studyPage;

    //热门文章
    private List<TbArticle> hots = new ArrayList<>(0);

    //文章分类
    private List<KindPo> kinds = new ArrayList<>(0);

    //项目服务路径
    private String serverPath;
}
