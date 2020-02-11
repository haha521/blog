package com.hanyuebb.blog.common.po;

import com.hanyuebb.blog.common.result.ResultPage;
import com.hanyuebb.blog.domain.TbArticle;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:EssayDataPo
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/7 15:04
 * @auther:zh
 */
@Data
public class EssayDataPo{
    private static final long serialVersionUID = 1L;

    //学习笔记及其分页信息
    private ResultPage<TbArticle> essayPage;

    //热门文章
    private List<TbArticle> hots = new ArrayList<>(0);

    //文章分类
    private List<KindPo> kinds;

    //项目服务路径
    private String serverPath;
}
