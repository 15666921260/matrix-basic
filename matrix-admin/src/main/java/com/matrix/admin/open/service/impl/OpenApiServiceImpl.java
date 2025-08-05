package com.matrix.admin.open.service.impl;

import cn.hutool.json.JSONUtil;
import com.matrix.admin.open.service.FilterLogicService;
import com.matrix.admin.open.service.GetConfigValue;
import com.matrix.admin.open.service.OpenApiService;
import com.matrix.common.pojo.History;
import com.matrix.common.utils.HistorySettingsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Slf4j
@Service
public class OpenApiServiceImpl implements OpenApiService {

    @Resource
    private GetConfigValue getConfigValue;

    @Resource
    private FilterLogicService filterLogicService;

    @Override
    public String test(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        History history = new History(dateTime, Collections.singletonList("test"), "test");
        return JSONUtil.toJsonStr(history);
    }

    @Override
    public String testThreadPool() {
        List<String> allUsers = getConfigValue.getAllUsers();
        log.info("所有人员为:{}", allUsers);
        List<History> allHistory = HistorySettingsUtils.getAllHistory(getConfigValue.getHistoryPath());
        log.info("读取的数据为: {}", allHistory);
        return "success";
    }
}
