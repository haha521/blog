package com.hanyuebb.blog.common.po;

import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbLeavingMsg;
import com.hanyuebb.blog.domain.TbOperateLog;
import com.hanyuebb.blog.domain.TbOuterLink;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:HomeDate
 * Package:com.hanyuebb.blog.common.po
 * Description:
 *
 * @date:2020/2/5 16:23
 * @auther:zh
 */

@Data
public class HomeDatePo implements Serializable {

    private static final long serialVersionUID = 1L;

    //学习笔记
    private List<TbArticle> studys = new ArrayList<>(0);

    //心情随笔
    private List<TbArticle> essays = new ArrayList<>(0);

    //留言
    private List<TbLeavingMsg> msgs = new ArrayList<>(0);

    //友情链接
    private List<TbOuterLink> shipLinks = new ArrayList<>(0);

    //项目服务路径
    private String serverPath;

}
