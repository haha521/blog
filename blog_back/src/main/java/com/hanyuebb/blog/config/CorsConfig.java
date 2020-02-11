package com.hanyuebb.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ClassName:CorsConfig
 * Package:com.hanyuebb.blog.config
 * Description:
 *
 * @date:2020/2/11 17:46
 * @auther:zh
 */
@Configuration
@EnableWebMvc
public class CorsConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
