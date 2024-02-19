package com.liu.matrixadmin;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuweizhong
 * @since 2024-02-05
 */
@SpringBootApplication
@MapperScan("com.liu.matrixadmin.**.mappers")
public class  MatrixAdminApplication {

    private static final Logger logger = LoggerFactory.getLogger(MatrixAdminApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MatrixAdminApplication.class, args);
        logger.info("--------<=========系统启动完成========>---------\nswagger路径:http://127.0.0.1:9010/liu/swagger-ui.html");
    }

}
