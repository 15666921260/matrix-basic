package com.matrix.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author liuweizhong
 * @since 2024-02-05
 */
@EnableAsync // 启动异步任务
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class  MatrixAdminApplication {

    private static final Logger logger = LoggerFactory.getLogger(MatrixAdminApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MatrixAdminApplication.class, args);
        logger.info("--------<========= System startup successful! ========>---------");
    }

}
