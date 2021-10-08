package com.luv2code.springdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // return our Spring Config class, we are not using xml for bean definition etc
        return new Class[]{DemoConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // map to root path
        return new String[]{"/"};
    }
}
