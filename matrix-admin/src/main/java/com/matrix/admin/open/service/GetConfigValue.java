package com.matrix.admin.open.service;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2025-07-28 15:05
 */
public interface GetConfigValue {

    String getCustomRobotToken();

    String getSecret();

    String getHistoryPath();

    Integer getDutyNumber();

    /**
     * 获取全部人员名单
     * @return 获取全部人员名单
     */
    List<String> getAllUsers();

    String getUsers();

    List<String> maxItemList();

    List<String> minItemList();

}
