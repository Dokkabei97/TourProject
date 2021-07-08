package com.t4er.config;

import com.t4er.interceptor.AdminInterceptor;
import com.t4er.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/members/join", "/login", "/logout", "/css/**", "/js/**", "/image/**");

        registry.addInterceptor(new AdminInterceptor())
                .order(2)
                .addPathPatterns("/admin/**");
//                .excludePathPatterns("/", "/members/join", "/login", "/logout", "/css/**", "/js/**", "/image/**");
    }
}
