package com.matrix.admin.open.controller;

import com.matrix.admin.open.service.IDingTalkMessageService;
import com.matrix.common.vo.basic.response.BaseResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuweizhong
 * @since 2025-07-28 11:15
 */
@RestController
@RequestMapping("/dingtalk/message")
public class DingTalkMessageController {
    @Resource
    private IDingTalkMessageService dingTalkMessageService;

    /**
     * 测试钉钉信息发送接口
     */
    @GetMapping("/send")
    @Scheduled(cron = "0 0 16 ? * 5", zone = "Asia/Shanghai")
//    @Scheduled(cron = "0 17 11 ? * 2", zone = "Asia/Shanghai")
    public BaseResponse<String> sendMessage() {
        String message = dingTalkMessageService.buildMessage();
        dingTalkMessageService.sendMessage(message);
        return BaseResponse.success(message);
    }

    @GetMapping("/build")
    public BaseResponse<String> buildMessage() {
        return BaseResponse.success(dingTalkMessageService.buildMessage());
    }

}
