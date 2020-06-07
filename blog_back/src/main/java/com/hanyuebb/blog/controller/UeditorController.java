package com.hanyuebb.blog.controller;

import com.alibaba.fastjson.JSONException;
import com.hanyuebb.blog.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * ClassName:UeditorController
 * Package:com.hanyuebb.blog.controller
 * Description:
 *
 * @date:2020/2/1 20:00
 * @auther:zh
 */
@RestController
@CrossOrigin
@RequestMapping("/ueditor")
public class UeditorController {

    @RequestMapping("/img")
    public String exec( HttpServletRequest request) throws UnsupportedEncodingException, JSONException {
        request.setCharacterEncoding("utf-8");
        //String rootPath = request.getSession().getServletContext().getRealPath("/");
        String rootPath = "/usr/local/docker/tomcat/apache-tomcat-7.0.70/webapps/ROOT/upload";
        //System.out.println(rootPath);
        return new ActionEnter( request, rootPath ).exec();
    }
}