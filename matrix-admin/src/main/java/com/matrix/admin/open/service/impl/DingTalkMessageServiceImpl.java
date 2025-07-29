package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.FilterLogicService;
import com.matrix.admin.open.service.GetConfigValue;
import com.matrix.admin.open.service.IDingTalkMessageService;
import com.matrix.common.constant.DingTalkTextType;
import com.matrix.common.utils.DingTalkRobotMessageUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author liuweizhong
 * @since 2025-07-28 11:16
 */
@Service
public class DingTalkMessageServiceImpl implements IDingTalkMessageService {
    @Resource
    private GetConfigValue configValue;
    @Resource
    private FilterLogicService filterLogicService;

    @Override
    public void sendMessage(String message) {
        DingTalkRobotMessageUtils.send(configValue.getSecret(), message, configValue.getCustomRobotToken(), Collections.emptyList(), DingTalkTextType.TEXT);
    }

    @Override
    public String buildMessage() {
        // 获取值日人员
        List<String> onDutyUsers = filterLogicService.getOnDutyUsers();
        // 构建值日表
        Map<String, List<String>> dutyContent = filterLogicService.getDutyContent(onDutyUsers);
        StringBuilder str = new StringBuilder("本周值日人员:\n");
        for (String key : dutyContent.keySet()) {
            String collect = String.join(",", dutyContent.get(key));
            str.append(key).append("(").append(collect).append(")\n");
        }
        return str.toString();
    }
}
