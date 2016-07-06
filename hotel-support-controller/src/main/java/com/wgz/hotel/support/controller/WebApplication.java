package com.wgz.hotel.support.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.wgz.hotel.support.common.filter.AccessFilter;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.wgz.hotel.support.common.*", "com.huya.cdn.support.controller.*" })
public class WebApplication extends SpringBootServletInitializer {
    //@Autowired
    //private AccessFilter accessFilter;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
/*
    @Bean
    public FilterRegistrationBean accessFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(accessFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/ctrl/");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }
    */
}
