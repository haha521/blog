package com.hanyuebb.blog.common.po;

import com.hanyuebb.blog.common.result.ResultPage;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbLeavingMsg;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.util.List;

/**
 * ClassName:ViewDate
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/6 16:54
 * @auther:zh
 */
@Data
public class ViewDatePo {
    private static final long serialVersionUID = 1L;

    //展示文章
    private TbArticle article;

    //留言信息
    private ResultPage<ResultPage> msgPage;

    //推荐阅读
    private List<TbArticle> hots;
}
