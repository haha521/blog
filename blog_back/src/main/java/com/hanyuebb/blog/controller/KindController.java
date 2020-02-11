package com.hanyuebb.blog.controller;

import com.github.pagehelper.PageInfo;
import com.hanyuebb.blog.common.po.KindDataPo;
import com.hanyuebb.blog.common.po.MtcPo;
import com.hanyuebb.blog.common.result.BaseResult;
import com.hanyuebb.blog.common.result.BaseResultBulider;
import com.hanyuebb.blog.common.result.ResultCode;
import com.hanyuebb.blog.common.result.ResultPage;
import com.hanyuebb.blog.common.vo.PageQueryVo;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbArticleKind;
import com.hanyuebb.blog.service.ArticleService;
import com.hanyuebb.blog.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName:KindController
 * Package:com.hanyuebb.blog.controller
 * Description:
 *
 * @date:2020/1/30 22:10
 * @auther:zh
 */
@RestController
@RequestMapping("/kind")
public class KindController {

    @Autowired
    KindService kindService;

    @Autowired
    ArticleService articleService;

    //获取文章所属模块
    @RequestMapping(value = "/module",method = RequestMethod.GET)
    public BaseResult module(){
        List<TbArticleKind> list = kindService.select(null);
        MtcPo mtcPo = new MtcPo();
        for (TbArticleKind kind:list
             ) {
            mtcPo.getModules().add(kind.getModule());
        }
        return BaseResultBulider.success(mtcPo, ResultCode.SUCCESS);
    }

    //按照模块获取文章类型及文章分类
    @RequestMapping(value = "/type/{module}",method = RequestMethod.GET)
    public BaseResult type(@PathVariable String module){
        TbArticleKind tbArticleKind = new TbArticleKind();
        tbArticleKind.setModule(module);
        List<TbArticleKind> list = kindService.select(tbArticleKind);
        MtcPo mtcPo = new MtcPo();
        for (TbArticleKind kind:list
             ) {
            mtcPo.getTypes().add(kind.getType());
            mtcPo.getClassifys().add(kind.getClassify());
        }
        return BaseResultBulider.success(mtcPo,ResultCode.SUCCESS);
    }
    //按照模块和类型查找分类
    @RequestMapping(value = "/classify/{module}/{type}",method = RequestMethod.GET)
    public BaseResult classify(@PathVariable String module,@PathVariable String type){
        TbArticleKind tbArticleKind = new TbArticleKind();
        tbArticleKind.setModule(module);
        tbArticleKind.setType(type);
        MtcPo mtcPo = new MtcPo();
        List<TbArticleKind> list = kindService.select(tbArticleKind);
        for (TbArticleKind kind:list
             ) {
            mtcPo.getClassifys().add(kind.getClassify());
        }
        return BaseResultBulider.success(mtcPo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public BaseResult list(@RequestBody PageQueryVo pageQueryVo){
        KindDataPo kindDataPo = new KindDataPo();
        ResultPage resultPage = new ResultPage();
        TbArticleKind tbArticleKind = new TbArticleKind();
        PageInfo pageInfo = kindService.page(pageQueryVo.getPageNo(),pageQueryVo.getPageSize(),tbArticleKind);
        List<TbArticleKind> list = pageInfo.getList();
        resultPage.setData(list);
        resultPage.setPageNo(pageQueryVo.getPageNo());
        resultPage.setPageSize(pageQueryVo.getPageSize());
        resultPage.setTotalCount(pageInfo.getTotal());
        List<String> modules = new ArrayList<>();
        modules.add("学习笔记模块");
        modules.add("心情随笔模块");
        kindDataPo.setModules(modules);
        kindDataPo.setPage(resultPage);
        kindDataPo.setQueryValue(pageQueryVo.getQueryValue());
        return BaseResultBulider.success(kindDataPo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    public BaseResult add(@RequestBody TbArticleKind tbArticleKind){
        //System.out.println(tbArticleKind.getArtKindsId());
        if(tbArticleKind.getArtKindsId()==null){
            tbArticleKind.setSum(0);
            tbArticleKind.setInsertTime(new Date());
            tbArticleKind.setUpdateTime(new Date());
            kindService.insert(tbArticleKind);
        }else{
            tbArticleKind.setUpdateTime(new Date());
            TbArticle tbArticle = new TbArticle();
            tbArticle.setClassify(tbArticleKind.getClassify());
            tbArticle.setType(tbArticleKind.getType());
            tbArticle.setModule(tbArticleKind.getModule());
            tbArticleKind.setSum(articleService.selectCount(tbArticle));
            kindService.updateById(tbArticleKind);
        }
        return BaseResultBulider.success(1,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public BaseResult del(@PathVariable Integer id){
        return BaseResultBulider.success(kindService.delKindAndArt(id),ResultCode.SUCCESS);
    }
}
