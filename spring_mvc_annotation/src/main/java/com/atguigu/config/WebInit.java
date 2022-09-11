package com.atguigu.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * 代替 web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //设置一个配置类代替Spring的配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //设置一个配置类代替SpringMVC的配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //设置SpringMVC的前端控制器DispatcherServlet的url-pattern（需要处理的一个请求路径）
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //设置当前的过滤器
    @Override
    protected Filter[] getServletFilters() {
        //创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        characterEncodingFilter.setForceEncoding(true);
        //创建处理请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[] {characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
