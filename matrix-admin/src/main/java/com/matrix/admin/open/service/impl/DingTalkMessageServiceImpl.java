package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.GetConfigValue;
import com.matrix.admin.open.service.IDingTalkMessageService;
import com.matrix.common.constant.DingTalkTextType;
import com.matrix.common.utils.DingTalkRobotMessageUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author liuweizhong
 * @since 2025-07-28 11:16
 */
@Service
public class DingTalkMessageServiceImpl implements IDingTalkMessageService {
    @Resource
    private GetConfigValue configValue;

    @Override
    public String sendMessage(String message) {
        DingTalkRobotMessageUtils.send(configValue.getSecret(), message, configValue.getCustomRobotToken(), Collections.emptyList(), DingTalkTextType.TEXT);
        return "success";
    }
}
