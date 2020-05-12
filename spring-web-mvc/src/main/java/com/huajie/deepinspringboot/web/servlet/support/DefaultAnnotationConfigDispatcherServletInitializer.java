package com.huajie.deepinspringboot.web.servlet.support;

import com.huajie.deepinspringboot.web.config.DispatchServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 */
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {// web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {// DispatchServlet
        return new Class[]{DispatchServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
