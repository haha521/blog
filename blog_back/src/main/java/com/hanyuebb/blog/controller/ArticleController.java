package com.hanyuebb.blog.controller;

import com.github.pagehelper.PageInfo;
import com.hanyuebb.blog.common.result.BaseResult;
import com.hanyuebb.blog.common.result.BaseResultBulider;
import com.hanyuebb.blog.common.result.ResultCode;
import com.hanyuebb.blog.common.vo.PageQueryVo;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbBlogUser;
import com.hanyuebb.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName:ArticleController
 * Package:com.hanyuebb.blog.controller
 * Description:
 *
 * @date:2020/1/30 22:06
 * @auther:zh
 */
@RestController
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult add(@RequestBody TbArticle tbArticle){
        if(tbArticle.getArticleId()==null){
            tbArticle.setLikes(0);
            tbArticle.setInsertTime(new Date());
            tbArticle.setViews(0);
            tbArticle.setCommons(0);
            tbArticle.setUpdateTime(new Date());
            String[] date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
            Integer year = Integer.parseInt(date[0]);
            Integer month = Integer.parseInt(date[1]);
            Integer day = Integer.parseInt(date[2]);
            tbArticle.setYear(year);
            tbArticle.setMonth(month);
            tbArticle.setDay(day);

            Integer result = articleService.insertAndAddKindSum(tbArticle);
        }else {
            //System.out.println(tbArticle.getArticleId());
            tbArticle.setUpdateTime(new Date());
            articleService.updateAndUpdateKindSumById(tbArticle);
        }
        return BaseResultBulider.success("添加或修改成功！", ResultCode.SUCCESS);
    }

    @RequestMapping(value = "{articleId}",method = RequestMethod.GET)
    public BaseResult getArticle(@PathVariable Integer articleId){
        TbArticle tbArticle = (TbArticle) articleService.selectById(articleId);
        return BaseResultBulider.success(tbArticle,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public BaseResult artList(@RequestBody PageQueryVo pageQueryVo){
        System.out.println(pageQueryVo.getPageNo()+"  "+pageQueryVo.getPageSize());
        TbArticle tbArticle = new TbArticle();
        tbArticle.setClassify(pageQueryVo.getClassify());
        tbArticle.setType(pageQueryVo.getType());
        tbArticle.setModule(pageQueryVo.getModule());
        tbArticle.setRuxWords(pageQueryVo.getQueryValue());
        PageInfo pageInfo = articleService.page(pageQueryVo.getPageNo(),pageQueryVo.getPageSize(),tbArticle);
        List<TbArticle> list = pageInfo.getList();
        return BaseResultBulider.success(list,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "{articleId}",method = RequestMethod.DELETE)
    public BaseResult delete(@PathVariable Integer articleId){
        return BaseResultBulider.success(articleService.deleteArtAndMsgById(articleId),ResultCode.SUCCESS);
    }

    /**
     * 修改状态
     */
    @RequestMapping(value = "state/{articleId}/{state}",method = RequestMethod.PUT)
    public BaseResult updateState(@PathVariable Integer articleId,@PathVariable String state){
        TbArticle tbArticle = new TbArticle();
        tbArticle.setArticleId(articleId);
        tbArticle.setArtState(state);
        return BaseResultBulider.success(articleService.updateById(tbArticle),ResultCode.SUCCESS);
    }
}
