package com.matrix.admin.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.matrix.common.constant.SpecialStr;
import com.matrix.common.constant.config.MaHttpHeaders;
import com.matrix.common.enums.system.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * sa-token 权限配置类
 * @author liuweizhong
 * @since 2024-02-11
 */
@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    @Value("#{@environment.getProperty('matrix.not-match').replaceAll('(?m)^\\s*#.*$', '')}")
    private String notMatch;

    /**
     * 注册 [Sa-Token 全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        String notMatchReplace = StringUtils.deleteWhitespace(notMatch.replaceAll("\\n", ""));
        List<String> excludeUrls = Arrays.asList(notMatchReplace.split(SpecialStr.COMMA));
        return new SaServletFilter()
                // 指定 [拦截路由] 与 [放行路由]
                .addInclude(SpecialStr.ROUTE_IGNORED)
                // 认证函数: 每次请求执行
                .setAuth(obj -> {
                    SaRouter.match(SpecialStr.ROUTE_IGNORED)
                            // 自动配置白名单url
                            .notMatch(excludeUrls)
                            .check(r -> StpUtil.checkLogin());        // 要执行的校验动作，可以写完整的 lambda 表达式
                })
                // 前置函数：在每次认证函数之前执行
                .setBeforeAuth(obj -> {
                    SaHolder.getResponse()
                            // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
                            // .setHeader("X-Frame-Options", "SAMEORIGIN")
                            // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
                            .setHeader(MaHttpHeaders.X_XSS_PROTECTION, MaHttpHeaders.X_XSS_PROTECTION_V)
                            // 禁用浏览器内容嗅探
                            .setHeader(MaHttpHeaders.X_CONTENT_TYPE_OPTIONS, MaHttpHeaders.X_CONTENT_TYPE_OPTIONS_V)
                            // 允许指定域访问跨域资源(生产环境时建议指定域名) Access-Control-Allow-Origin
                            .setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, SpecialStr.ASTERISK)
                            // 允许所有请求方式 Access-Control-Allow-Methods
                            .setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, OPTIONS, DELETE")
                            // 有效时间  Access-Control-Max-Age
                            .setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600")
                            // 允许的header参数  Access-Control-Allow-Headers
                            .setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, SpecialStr.ASTERISK);
                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
//                            .free(r -> log.info("--->OPTIONS预检请求，不做处理"))
                            .back();
                })
                // sa-token异常处理函数：每次认证函数发生异常时执行此函数
                .setError(this::exceptionHandler);
    }

    /**
     * 注册 [Sa-Token 权限注解拦截器]
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor()).addPathPatterns(SpecialStr.ROUTE_IGNORED);
    }

    private SaResult exceptionHandler(Throwable e) {
        if (e instanceof NotLoginException notLoginException) {
            String message = "token 无效";
            if (notLoginException.getType().equals(NotLoginException.NOT_TOKEN)) {
                message = "未能读取到有效 token";
            } else if (notLoginException.getType().equals(NotLoginException.INVALID_TOKEN)) {
                message = "登录信息已过期，请重新登录";
            } else if (notLoginException.getType().equals(NotLoginException.BE_REPLACED)) {
                message = "当前账号在其他地方登录，请重新登录";
            } else if (notLoginException.getType().equals(NotLoginException.KICK_OUT)) {
                message = "账号已被踢出，请联系管理员";
            }
            return SaResult.error(e.getMessage()).setCode(HttpStatus.UNAUTHORIZED.getCode()).setMsg(message);
        } else {
            return SaResult.error(e.getMessage());
        }
    }

}
