package com.hanyuebb.blog.controller;

import com.hanyuebb.blog.common.result.BaseResult;
import com.hanyuebb.blog.common.result.BaseResultBulider;
import com.hanyuebb.blog.common.result.ResultCode;
import com.hanyuebb.blog.domain.TbBlogUser;
import com.hanyuebb.blog.exmapper.ExTbBlogUserMapper;
import com.hanyuebb.blog.service.UserService;
import com.hanyuebb.blog.utils.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * ClassName:BackController
 * Package:com.hanyuebb.blog.controller
 * Description:
 *
 * @date:2020/1/30 22:09
 * @auther:zh
 */
@RestController
@RequestMapping("/back")
public class BackController {

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
        if(tbBlogUser2.getUserType().equals("1")){
            subject.login(token);
            return BaseResultBulider.success(tbBlogUser2, ResultCode.SUCCESS);
        }else {
            return BaseResultBulider.faile(ResultCode.USER_LOGIN_ERROR);
        }
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public BaseResult logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseResultBulider.success(1,ResultCode.SUCCESS);
    }
}
