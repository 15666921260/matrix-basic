package com.liu.matrixadmin;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuweizhong
 * @since 2024-02-05
 */
@SpringBootApplication
public class MatrixAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatrixAdminApplication.class, args);
        LoggerFactory.getLogger(MatrixAdminApplication.class).info("--------<=========系统启动完成========>---------");
    }

}
