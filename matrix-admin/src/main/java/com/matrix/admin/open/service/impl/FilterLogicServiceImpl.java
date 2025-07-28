package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.FilterLogicService;
import com.matrix.admin.open.service.GetConfigValue;
import com.matrix.common.pojo.History;
import com.matrix.common.utils.HistorySettingsUtils;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuweizhong
 * @since 2025-07-28 15:21
 */
@Service
public class FilterLogicServiceImpl implements FilterLogicService {
    @Resource
    private GetConfigValue getConfigValue;

    @Override
    public List<String> getOnDutyUsers() {
        List<String> allUsers = getConfigValue.getAllUsers();
        List<History> allHistory = HistorySettingsUtils.getAllHistory(getConfigValue.getHistoryPath());
        Integer dutyNumber = getConfigValue.getDutyNumber();
        if (CollectionUtils.isEmpty(allHistory)) {
            List<String> dutyUsers = allUsers.subList(0, dutyNumber);

            return dutyUsers;
        }
        History last = allHistory.getLast();



        return List.of();
    }
}
