package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.FilterLogicService;
import com.matrix.admin.open.service.GetConfigValue;
import com.matrix.admin.open.service.IDingTalkMessageService;
import com.matrix.common.constant.DingTalkTextType;
import com.matrix.common.utils.DingTalkRobotMessageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
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
        StringBuilder str = new StringBuilder("## \uD83E\uDDF9 办公室每周卫生打扫通知\n" +
                "\n" +
                "各位同事：\n" +
                "\n" +
                "为营造整洁、舒适的办公环境，保障大家的工作效率与健康，现将本周卫生打扫安排通知如下，请各区域负责人员认真执行：\n" +
                "\n" +
                "## \uD83D\uDCC5 打扫时间\n" +
                "\n" +
                "**每周一 17:30-18:00（下班前半小时）**\n\n" +
                "本周值日人员:\n");
        for (String key : dutyContent.keySet()) {
            String collect = String.join(", ", dutyContent.get(key));
            str.append(key).append(": ").append(collect).append("\n");
        }
        LocalDate now = LocalDate.now();
        str.append("\n").append("**").append(now.getYear()).append("年").append(now.getMonthValue()).append("月").append(now.getDayOfMonth()).append("日").append("**");
        return str.toString();
    }
}
