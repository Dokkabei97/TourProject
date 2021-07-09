package com.t4er.config;

import com.t4er.config.login.LoginArgumentResolver;
import com.t4er.config.interceptor.AdminInterceptor;
import com.t4er.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginArgumentResolver());
    }

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
