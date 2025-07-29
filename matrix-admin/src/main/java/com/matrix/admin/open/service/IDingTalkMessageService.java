package com.matrix.admin.open.service;

/**
 * @author liuweizhong
 * @since 2025-07-28 11:16
 */
public interface IDingTalkMessageService {
    void sendMessage(String message);

    String buildMessage();
}
