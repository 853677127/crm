package com.dong.cicc.config;

import com.dong.cicc.interceptor.NoLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    // 设置Bean对象，交给IOC容器维护
    @Bean
    public NoLoginInterceptor noLoginInterceptor() {
        return new NoLoginInterceptor();
    }

    /**
     * 设置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置指定拦截器
        registry.addInterceptor(noLoginInterceptor())
                // 设置需要拦截的资源
                .addPathPatterns("/**") // 拦截所有
                // 设置需要放行的资源
                // 登录页面、登录操作、静态资源（js、css、images、lib插件）
                .excludePathPatterns("/index","/user/login","/js/**","/css/**","/images/**","/lib/**");
    }
}
