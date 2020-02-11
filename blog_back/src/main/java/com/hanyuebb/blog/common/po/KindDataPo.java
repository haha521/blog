package com.hanyuebb.blog.common.po;

import com.hanyuebb.blog.common.result.ResultPage;
import com.hanyuebb.blog.domain.TbArticleKind;
import lombok.Data;

import java.util.List;

/**
 * ClassName:KindData
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/8 18:42
 * @auther:zh
 */
@Data
public class KindDataPo {
    private ResultPage<TbArticleKind> page;

    private List<String> modules;

    private String queryValue;
}
