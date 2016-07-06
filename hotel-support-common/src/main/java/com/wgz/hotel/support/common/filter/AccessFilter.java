package com.wgz.hotel.support.common.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@PropertySources(value = { @PropertySource("classpath:application.properties") })
public class AccessFilter implements Filter {
    

    private static final Logger LOG = LoggerFactory.getLogger(AccessFilter.class);


    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterchain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");


        filterchain.doFilter(servletRequest, servletResponse);

    }

    public void init(FilterConfig arg0) throws ServletException {

    }

    private String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = s.getBytes();

            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
