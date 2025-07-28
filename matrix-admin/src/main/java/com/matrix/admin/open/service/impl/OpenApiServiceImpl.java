package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.OpenApiService;
import com.matrix.common.pojo.History;
import com.matrix.common.utils.HistorySettingsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Slf4j
@Service
public class OpenApiServiceImpl implements OpenApiService {

    @Value("${history.url}")
    private String filePath;

    @Override
    public String test() {
        History history = new History();
        history.setDate(LocalDateTime.now());
        history.setUsers(Collections.singletonList("刘伟中"));
        HistorySettingsUtils.addHistory(filePath, history);
        log.info("===========进入测试接口！");
        return "success";
    }

    @Override
    public String testThreadPool() {
        List<History> allHistory = HistorySettingsUtils.getAllHistory(filePath);
        log.info("读取的数据为: {}", allHistory);
        return "success";
    }
}
