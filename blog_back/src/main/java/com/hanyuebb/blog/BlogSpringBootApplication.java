package com.hanyuebb.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName:BlogSpringBootApplication
 * Package:com.hanyuebb.blog
 * Description:
 *
 * @date:2020/1/30 20:30
 * @auther:zh
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.hanyuebb.blog.mapper")
public class BlogSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogSpringBootApplication.class,args);
    }
}
