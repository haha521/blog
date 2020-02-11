package com.hanyuebb.blog.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:PageQueryVo
 * Package:com.hanyuebb.blog.common.vo
 * Description:
 *
 * @date:2020/1/31 20:36
 * @auther:zh
 */
@Data
public class PageQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageNo;

    private Integer pageSize;

    //搜索条件
    private String queryValue;

    //所属类型
    private String type;

    //具体类型
    private String classify;

    //文章模块
    private String module;

    //文章id
    private Integer articleId;

    // 文章状态
    private String artState;

    // 文章时间
    private String artDate;

}
