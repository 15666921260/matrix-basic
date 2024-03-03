package com.liu.matrixadmin.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * sa-token 权限配置类
 * @author liuweizhong
 * @since 2024-02-11
 */
@Configuration    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class SaTokenConfigure implements WebMvcConfigurer {

    /**
     * 注册 [Sa-Token 全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                // 指定 [拦截路由] 与 [放行路由]
                .addInclude("/**")
                // 认证函数: 每次请求执行
                .setAuth(obj -> {
                    SaRouter.match("/**")    // 拦截的 path 列表，可以写多个
                            // 开放登录接口
                            .notMatch("/user/login")
                            // 开放 swagger
                            .notMatch("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**")
                            // 开放自定义接口
                            .notMatch("/openApi/**")
                            .check(r -> StpUtil.checkLogin());        // 要执行的校验动作，可以写完整的 lambda 表达式
                })
                // 前置函数：在每次认证函数之前执行
                .setBeforeAuth(obj -> {
                    SaHolder.getResponse()
                            // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
                            // .setHeader("X-Frame-Options", "SAMEORIGIN")
                            // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
                            .setHeader("X-XSS-Protection", "1; mode=block")
                            // 禁用浏览器内容嗅探
                            .setHeader("X-Content-Type-Options", "nosniff")
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*");
                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .free(r -> System.out.println("--------OPTIONS预检请求，不做处理"))
                            .back();
                })
                // 异常处理函数：每次认证函数发生异常时执行此函数
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                });
    }

}
