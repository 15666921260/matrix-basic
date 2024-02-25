package com.liu.matrixadmin.config;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * sa-token 权限配置类
 * @author liuweizhong
 * @since 2024-02-11
 */
@Configuration    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class SaTokenConfigure implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SaTokenConfigure.class);

    /**
     * 注册 Sa-Token 拦截器，打开注解式鉴权功能
     * @param registry
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor(handler -> {
            // 指定一条 match 规则
            SaRouter.match("/**")    // 拦截的 path 列表，可以写多个
                    // 开放登录接口
                    .notMatch("/user/login")
                    // 开放 swagger
                    .notMatch("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**")
                    // 开放自定义接口
                    .notMatch("/openApi/**")
                    .check(r -> StpUtil.checkLogin());        // 要执行的校验动作，可以写完整的 lambda 表达式
        })).addPathPatterns("/**");
    }*/

    /**
     * 注册 [Sa-Token 全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                // 指定 [拦截路由] 与 [放行路由]
                .addInclude("/**")
                .addExclude("/favicon.ico")
                // 开放登录接口
                .addExclude("/user/login")
                // 开放 swagger
                .addExclude("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**")
                // 开放自定义接口
                .addExclude("/openApi/**")
                // 认证函数: 每次请求执行
                .setAuth(obj -> {
                    SaManager.getLog().debug("----- 请求path={}  提交token={}", SaHolder.getRequest().getRequestPath(), StpUtil.getTokenValue());
                    // ...
                })

                // 异常处理函数：每次认证函数发生异常时执行此函数
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                })

                // 前置函数：在每次认证函数之前执行
                .setBeforeAuth(obj -> {
                    SaHolder.getResponse()
                            // ---------- 设置跨域响应头 ----------
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "*")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                    ;

                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .free(r -> System.out.println("--------OPTIONS预检请求，不做处理"))
                            .back();
                });
    }

}
