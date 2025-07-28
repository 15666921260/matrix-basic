package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.GetConfigValue;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

}
