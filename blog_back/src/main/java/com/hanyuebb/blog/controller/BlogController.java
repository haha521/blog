package com.hanyuebb.blog.controller;

import com.github.pagehelper.PageInfo;
import com.hanyuebb.blog.common.po.*;
import com.hanyuebb.blog.common.result.BaseResult;
import com.hanyuebb.blog.common.result.BaseResultBulider;
import com.hanyuebb.blog.common.result.ResultCode;
import com.hanyuebb.blog.common.result.ResultPage;
import com.hanyuebb.blog.common.vo.PageQueryVo;
import com.hanyuebb.blog.domain.TbArticle;
import com.hanyuebb.blog.domain.TbArticleKind;
import com.hanyuebb.blog.domain.TbBlogUser;
import com.hanyuebb.blog.domain.TbLeavingMsg;
import com.hanyuebb.blog.exmapper.ExTbBlogUserMapper;
import com.hanyuebb.blog.service.*;
import com.hanyuebb.blog.utils.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName:SysController
 * Package:com.hanyuebb.blog.controller
 * Description:
 *
 * @date:2020/1/30 22:03
 * @auther:zh
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    ArticleService articleService;

    @Autowired
    MsgService msgService;

    @Autowired
    OutService outService;

    @Autowired
    KindService kindService;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/homeInit",method = RequestMethod.GET)
    public BaseResult homeInit(){
        HomeDatePo homeDatePo = new HomeDatePo();
        Map<String,List> map = articleService.selectStudyAndEssay();
        for (TbArticle t:(List<TbArticle>)map.get("studys")
             ) {
            System.out.println(t.getArticleId());
        }
        homeDatePo.setEssays((List<TbArticle>) map.get("essays"));
        homeDatePo.setStudys((List<TbArticle>) map.get("studys"));
        homeDatePo.setMsgs(msgService.selectMsg());
        homeDatePo.setShipLinks(outService.selectOutLink());
        homeDatePo.setServerPath("http://localhost:8088");
        return BaseResultBulider.success(homeDatePo, ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/studyInit",method = RequestMethod.GET)
    public BaseResult studyInit(){
        StudyDataPo studyDataPo = new StudyDataPo();
        studyDataPo.setHots(articleService.selectHotsArticle("学习笔记模块"));
        List<TbArticleKind> list = kindService.selectType("学习笔记模块");
        List<KindPo> kinds = new ArrayList<>();
        Set<String> set = new HashSet();
        TbArticle tbArticle = new TbArticle();
        for (TbArticleKind kind:list
             ) {
            set.add(kind.getType());
        }
        for (String s:set
             ) {
            KindPo kindPo = new KindPo();
            kindPo.setType(s);
            List<Children> children = kindService.selectClassify(s);
            for (Children c:children
                 ) {
                tbArticle.setType(s);
                tbArticle.setClassify(c.getClassify());
                c.setSum(articleService.selectCount(tbArticle));
            }
            kindPo.setChildren(children);
            kinds.add(kindPo);
        }
        studyDataPo.setKinds(kinds);
        TbArticle tbArticle1 = new TbArticle();
        tbArticle1.setModule("学习笔记模块");
        PageInfo pageInfo = articleService.page(1,4,tbArticle1);
        List list1 = pageInfo.getList();
        ResultPage resultPage = new ResultPage();
        resultPage.setData(list1);
        resultPage.setPageNo(1);
        resultPage.setPageSize(4);
        resultPage.setTotalCount(pageInfo.getTotal());
        studyDataPo.setStudyPage(resultPage);
        studyDataPo.setServerPath("http://localhost:8088");
        return BaseResultBulider.success(studyDataPo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/articlePage",method = RequestMethod.POST)
    public BaseResult articlePage(@RequestBody PageQueryVo pageQueryVo){
        System.out.println(pageQueryVo.toString());
        TbArticle tbArticle = new TbArticle();
        tbArticle.setModule(pageQueryVo.getModule());
        tbArticle.setClassify(pageQueryVo.getClassify());
        tbArticle.setType(pageQueryVo.getType());
        tbArticle.setRuxWords(pageQueryVo.getQueryValue());
        PageInfo pageInfo = articleService.page(pageQueryVo.getPageNo(),4,tbArticle);
        List<TbArticle> list = pageInfo.getList();
        ResultPage resultPage = new ResultPage();
        StudyDataPo studyDataPo = new StudyDataPo();
        resultPage.setData(list);
        resultPage.setTotalCount(pageInfo.getTotal());
        resultPage.setPageNo(pageQueryVo.getPageNo());
        resultPage.setPageSize(4);
        studyDataPo.setStudyPage(resultPage);
        studyDataPo.setServerPath("http://localhost:8088");
        return BaseResultBulider.success(studyDataPo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
    public BaseResult view(@PathVariable Integer id){
        ViewDatePo viewDatePo = new ViewDatePo();
        ResultPage resultPage = new ResultPage();

        List<TbArticle> l1 = articleService.selectHotsArticle("学习笔记模块");
        l1.addAll(articleService.selectHotsArticle("心情随笔模块"));

        viewDatePo.setHots(l1);
        viewDatePo.setArticle((TbArticle) articleService.selectById(id));
        List<LeavingMsgPo> result = new ArrayList<>();
        TbLeavingMsg tbLeavingMsg = new TbLeavingMsg();
        tbLeavingMsg.setArticleId(id);
        PageInfo pageInfo = msgService.page(1,6,tbLeavingMsg);
        List<TbLeavingMsg> list = pageInfo.getList();
        for (TbLeavingMsg msg:list
             ) {
            TbBlogUser tbBlogUser = (TbBlogUser) userService.selectById(msg.getUserId());
            LeavingMsgPo leavingMsgPo = new LeavingMsgPo();
            leavingMsgPo.setUserNickName(tbBlogUser.getUserNickName());
            leavingMsgPo.setArticleId(msg.getArticleId());
            leavingMsgPo.setContent(msg.getContent());
            leavingMsgPo.setUpdateTime(msg.getUpdateTime());
            leavingMsgPo.setInsertTime(msg.getInsertTime());
            leavingMsgPo.setMsgId(msg.getMsgId());
            leavingMsgPo.setUserId(msg.getUserId());
            leavingMsgPo.setMsgOrder(msg.getMsgOrder());
            leavingMsgPo.setStatus(msg.getStatus());
            leavingMsgPo.setType(msg.getType());
            leavingMsgPo.setUpperId(msg.getUpperId());
            result.add(leavingMsgPo);
        }
        resultPage.setData(result);
        resultPage.setTotalCount(pageInfo.getTotal());
        resultPage.setPageNo(1);
        resultPage.setPageSize(6);
        viewDatePo.setMsgPage(resultPage);
        return BaseResultBulider.success(viewDatePo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/essayInit",method = RequestMethod.GET)
    public BaseResult essayInit(){
        EssayDataPo essayDataPo = new EssayDataPo();
        essayDataPo.setHots(articleService.selectHotsArticle("心情随笔模块"));
        TbArticle tbArticle1 = new TbArticle();
        tbArticle1.setModule("心情随笔模块");
        PageInfo pageInfo = articleService.page(1,4,tbArticle1);
        List<TbArticle> list1 = pageInfo.getList();
        List<KindPo> years = new ArrayList<>();

        Map<String,Date> map = articleService.maxAndMinTime();
        //System.out.println(map.get("min"));
        String[] min = new SimpleDateFormat("yyyy-MM-dd").format(map.get("min")).toString().split("-");
        Integer minYear = Integer.parseInt(min[0]);

        String[] max = new SimpleDateFormat("yyyy-MM-dd").format(map.get("max")).toString().split("-");
        Integer maxYear = Integer.parseInt(max[0]);

        for (int i = minYear; i <= maxYear; i++) {
            List<Children> months = new ArrayList<>();
            for (int j = 1; j < 13; j++) {
                List<TbArticle> list = articleService.selectByYearAndMonth(i,j);
                if(list.size()!=0){
                    Children children = new Children();
                    children.setMonth(String.valueOf(j));
                    children.setSum(list.size());
                    months.add(children);
                }
            }

            KindPo kindPo = new KindPo();
            kindPo.setYear(String.valueOf(i));
            kindPo.setChildren(months);
            years.add(kindPo);
        }
        essayDataPo.setKinds(years);
        ResultPage resultPage = new ResultPage();
        resultPage.setData(list1);
        resultPage.setTotalCount(pageInfo.getTotal());
        resultPage.setPageSize(4);
        resultPage.setPageNo(1);
        essayDataPo.setEssayPage(resultPage);
        essayDataPo.setServerPath("http://localhost:8088");
        return BaseResultBulider.success(essayDataPo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/essayPage",method = RequestMethod.POST)
    public BaseResult essayPage(@RequestBody PageQueryVo pageQueryVo){
        TbArticle tbArticle = new TbArticle();
        String[] date = pageQueryVo.getArtDate().split("-");
        System.out.println(pageQueryVo.getArtDate());
        if(!date[0].equals("undefined")&&date[0]!=null){
            tbArticle.setYear(Integer.valueOf(date[0]));
            tbArticle.setMonth(Integer.valueOf(date[1]));
        }
        tbArticle.setModule("心情随笔模块");
        PageInfo pageInfo = articleService.page(pageQueryVo.getPageNo(),4,tbArticle);
        List<TbArticle> list = pageInfo.getList();
        ResultPage resultPage = new ResultPage<>();
        resultPage.setData(list);
        resultPage.setPageNo(pageQueryVo.getPageNo());
        resultPage.setPageSize(4);
        resultPage.setTotalCount(pageInfo.getTotal());
        EssayDataPo essayDataPo = new EssayDataPo();
        essayDataPo.setEssayPage(resultPage);
        essayDataPo.setServerPath("http://localhost:8088");
        return BaseResultBulider.success(essayDataPo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/boardInit",method = RequestMethod.GET)
    public BaseResult boardInit(){
        ResultPage resultPage = new ResultPage();

        TbLeavingMsg tbLeavingMsg = new TbLeavingMsg();
        tbLeavingMsg.setType("01");
        PageInfo pageInfo = msgService.page(1,6,tbLeavingMsg);
        List<TbLeavingMsg> list = pageInfo.getList();
        List<LeavingMsgPo> date = new ArrayList<>();
        for (TbLeavingMsg t:list
             ) {
            LeavingMsgPo leavingMsgPo = new LeavingMsgPo();
            leavingMsgPo.setUpperId(t.getUpperId());
            leavingMsgPo.setType(t.getType());
            leavingMsgPo.setStatus(t.getStatus());
            leavingMsgPo.setMsgOrder(t.getMsgOrder());
            leavingMsgPo.setUserId(t.getUserId());
            leavingMsgPo.setInsertTime(t.getInsertTime());
            leavingMsgPo.setUpdateTime(t.getUpdateTime());
            leavingMsgPo.setMsgId(t.getMsgId());
            leavingMsgPo.setContent(t.getContent());
            leavingMsgPo.setArticleId(t.getArticleId());
            TbBlogUser tbBlogUser = (TbBlogUser) userService.selectById(t.getUserId());
            leavingMsgPo.setUserNickName(tbBlogUser.getUserNickName());
            date.add(leavingMsgPo);
        }
        resultPage.setData(date);

        resultPage.setTotalCount(pageInfo.getTotal());
        resultPage.setPageSize(6);
        resultPage.setPageNo(1);

        MsgDatePo msgDatePo = new MsgDatePo();
        msgDatePo.setMsgPage(resultPage);

        return BaseResultBulider.success(msgDatePo,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/leaveMsg",method = RequestMethod.POST)
    public BaseResult leaveMsg(@RequestBody TbLeavingMsg tbLeavingMsg){
        tbLeavingMsg.setInsertTime(new Date());
        tbLeavingMsg.setUpdateTime(new Date());
        Integer result = msgService.insert(tbLeavingMsg);
        return BaseResultBulider.success(result,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/artMsgPage",method = RequestMethod.POST)
    public BaseResult artMsgPage(@RequestBody PageQueryVo pageQueryVo){
        ViewDatePo viewDatePo = new ViewDatePo();
        ResultPage resultPage = new ResultPage();

        List<LeavingMsgPo> result = new ArrayList<>();

        TbLeavingMsg tbLeavingMsg = new TbLeavingMsg();
        tbLeavingMsg.setArticleId(pageQueryVo.getArticleId());
        tbLeavingMsg.setType(pageQueryVo.getType());
        PageInfo pageInfo = msgService.page(pageQueryVo.getPageNo(),6,tbLeavingMsg);
        List<TbLeavingMsg> list = pageInfo.getList();
        for (TbLeavingMsg msg:list
        ) {
            TbBlogUser tbBlogUser = (TbBlogUser) userService.selectById(msg.getUserId());
            LeavingMsgPo leavingMsgPo = new LeavingMsgPo();
            leavingMsgPo.setUserNickName(tbBlogUser.getUserNickName());
            leavingMsgPo.setArticleId(msg.getArticleId());
            leavingMsgPo.setContent(msg.getContent());
            leavingMsgPo.setUpdateTime(msg.getUpdateTime());
            leavingMsgPo.setInsertTime(msg.getInsertTime());
            leavingMsgPo.setMsgId(msg.getMsgId());
            leavingMsgPo.setUserId(msg.getUserId());
            leavingMsgPo.setMsgOrder(msg.getMsgOrder());
            leavingMsgPo.setStatus(msg.getStatus());
            leavingMsgPo.setType(msg.getType());
            leavingMsgPo.setUpperId(msg.getUpperId());
            result.add(leavingMsgPo);
        }
        resultPage.setData(result);
        resultPage.setTotalCount(pageInfo.getTotal());
        resultPage.setPageNo(pageInfo.getPageNum());
        resultPage.setPageSize(6);
        viewDatePo.setMsgPage(resultPage);
        return BaseResultBulider.success(viewDatePo,ResultCode.SUCCESS);
    }

    @Autowired
    private ExTbBlogUserMapper exTbBlogUserMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult login(@RequestBody TbBlogUser tbBlogUser){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(Md5Util.md5String(tbBlogUser.getPassword(), ByteSource.Util.bytes(tbBlogUser.getUserName())));
        UsernamePasswordToken token = new UsernamePasswordToken(tbBlogUser.getUserName(),tbBlogUser.getPassword());
        TbBlogUser tbBlogUser1 = new TbBlogUser();
        tbBlogUser1.setUserName(tbBlogUser.getUserName());
        TbBlogUser tbBlogUser2 = exTbBlogUserMapper.selectOne(tbBlogUser1);
        if(tbBlogUser2.getUserType().equals("2")){
            subject.login(token);
            return BaseResultBulider.success(tbBlogUser2, ResultCode.SUCCESS);
        }else {
            return BaseResultBulider.faile(ResultCode.USER_LOGIN_ERROR);
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public BaseResult register(@RequestBody TbBlogUser tbBlogUser){
        TbBlogUser tbBlogUser1 = new TbBlogUser();
        tbBlogUser.setPassword(Md5Util.md5String(tbBlogUser.getPassword(), ByteSource.Util.bytes(tbBlogUser.getUserName())));
        tbBlogUser.setUserType("2");
        tbBlogUser.setInsertTime(new Date());
        tbBlogUser.setUpdateTime(new Date());
        tbBlogUser.setBirtd(new Date());
        tbBlogUser1.setUserName(tbBlogUser.getUserName());
        if (userService.selectCount(tbBlogUser1)==0){
            return BaseResultBulider.success(userService.insert(tbBlogUser),ResultCode.SUCCESS);
        }else {
            return BaseResultBulider.faile(ResultCode.DATA_ALREADY_EXISTED);
        }
    }

    @RequestMapping(value = "/unauth",method = RequestMethod.GET)
    public BaseResult unauth(){
        return BaseResultBulider.faile(ResultCode.PERMISSION_NO_ACCESS);
    }
}
