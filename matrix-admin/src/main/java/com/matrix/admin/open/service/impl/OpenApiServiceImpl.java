package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.OpenApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Slf4j
@Service
public class OpenApiServiceImpl implements OpenApiService {
    @Override
    public String test() {
        log.info("===========进入测试接口！");
        return "success";
    }

    @Override
    public String testThreadPool() {

        return null;
    }
}
