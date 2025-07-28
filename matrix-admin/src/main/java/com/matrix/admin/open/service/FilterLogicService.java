package com.matrix.admin.open.service;

import java.util.List;
import java.util.Map;

/**
 * 人员筛查逻辑
 * @author liuweizhong
 * @since 2025-07-28 15:21
 */
public interface FilterLogicService {

    /**
     * 获取当前周的值日信息
     * @return 返回的是人名
     */
    List<String> getOnDutyUsers();

    /**
     * 每个值日人员对应的值日内容
     * @param dutyUsers 值日人员列表
     * @return key 值日人员 value 值日内容列表
     */
    Map<String, List<String>> getDutyContent(List<String> dutyUsers);
}
