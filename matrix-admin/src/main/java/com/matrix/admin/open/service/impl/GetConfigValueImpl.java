package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.GetConfigValue;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2025-07-28 15:06
 */
@Getter
@Service
public class GetConfigValueImpl implements GetConfigValue {

    @Value("${dingtalk.custom-robot-token}")
    private String customRobotToken;
    @Value("${dingtalk.secret}")
    private String secret;
    @Value("${user.names}")
    private String users;
    @Value("${user.value}")
    private Integer dutyNumber;
    @Value("${history.url}")
    private String historyPath;
    @Value("${user.max-item}")
    private String maxItems;
    @Value("${user.min-item}")
    private String minItems;

    public List<String> getAllUsers() {
        return List.of(users.split(","));
    }

    @Override
    public List<String> maxItemList() {
        return List.of(maxItems.split(","));
    }

    @Override
    public List<String> minItemList() {
        return List.of(minItems.split(","));
    }
}
