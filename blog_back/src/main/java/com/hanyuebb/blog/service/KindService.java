package com.hanyuebb.blog.service;

import com.hanyuebb.blog.common.basedomain.BaseDomain;
import com.hanyuebb.blog.common.baseservice.BaseService;
import com.hanyuebb.blog.common.po.Children;
import com.hanyuebb.blog.domain.TbArticleKind;

import java.util.List;
import java.util.Map;

/**
 * ClassName:KindService
 * Package:com.hanyuebb.blog.service
 * Description:
 *
 * @date:2020/1/30 22:47
 * @auther:zh
 */
public interface KindService<T extends BaseDomain> extends BaseService<T> {
    List<TbArticleKind> selectType(String module);

    List<Children> selectClassify(String type);

    Integer delKindAndArt(Integer id);

}
