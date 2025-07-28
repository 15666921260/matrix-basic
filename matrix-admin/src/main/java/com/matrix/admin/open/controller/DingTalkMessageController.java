package com.matrix.admin.open.controller;

import com.matrix.admin.open.service.IDingTalkMessageService;
import com.matrix.common.vo.basic.response.BaseResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public BaseResponse<String> sendMessage(@RequestParam(value = "message") String message) {
        return BaseResponse.success(dingTalkMessageService.sendMessage(message));
    }

}
