package com.matrix.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liuweizhong
 * @since 2024-02-05
 */
@SpringBootApplication
@MapperScan("com.matrix.admin.**.mappers")
public class  MatrixAdminApplication {

    private static final Logger logger = LoggerFactory.getLogger(MatrixAdminApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MatrixAdminApplication.class, args);
        printlnProjectInfo(context);
    }

    /**
     * 打印项目信息
     *
     * @param context 用于获取springboot配置
     */
    private static void printlnProjectInfo(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String swaggerPath = environment.getProperty("springdoc.swagger-ui.path");
        logger.info("--------<=========系统启动完成========>---------\n" +
                "swagger路径:http://127.0.0.1:"+ serverPort + contextPath + swaggerPath);
    }

}
