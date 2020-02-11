package com.hanyuebb.blog.controller;

import com.github.pagehelper.PageInfo;
import com.hanyuebb.blog.common.result.BaseResult;
import com.hanyuebb.blog.common.result.BaseResultBulider;
import com.hanyuebb.blog.common.result.ResultCode;
import com.hanyuebb.blog.common.vo.PageQueryVo;
import com.hanyuebb.blog.domain.TbBlogUser;
import com.hanyuebb.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:UserController
 * Package:com.hanyuebb.blog.controller
 * Description:
 *
 * @date:2020/1/30 22:02
 * @auther:zh
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public BaseResult selectById(@PathVariable Integer id){
//        return BaseResultBulider.success(userService.selectById(id),ResultCode.SUCCESS);
//    }

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public BaseResult userList(@RequestBody PageQueryVo pageQueryVo){
        PageInfo pageInfo = userService.page(pageQueryVo.getPageNo(),pageQueryVo.getPageSize(),null);
        List<TbBlogUser> list = pageInfo.getList();
        return BaseResultBulider.success(list,ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/del/{userId}",method = RequestMethod.DELETE)
    public BaseResult del(@PathVariable Integer userId){
        TbBlogUser tbBlogUser = (TbBlogUser) userService.selectById(userId);
        if(tbBlogUser.getUserType().equals("1")){
            return BaseResultBulider.faile(ResultCode.PERMISSION_NO_ACCESS);
        }else {
            return BaseResultBulider.success(userService.deleteById(userId),ResultCode.SUCCESS);
        }
    }
}
