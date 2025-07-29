package com.matrix.admin.open.service.impl;

import com.martix.util.DateUtils;
import com.matrix.admin.open.service.FilterLogicService;
import com.matrix.admin.open.service.GetConfigValue;
import com.matrix.common.pojo.History;
import com.matrix.common.utils.HistorySettingsUtils;
import com.matrix.common.utils.RandomCollectionGenerator;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

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
        // 如果是第一次则取前两个
        if (CollectionUtils.isEmpty(allHistory)) {
            List<String> dutyUsers = allUsers.subList(0, dutyNumber);
            HistorySettingsUtils.addHistory(getConfigValue.getHistoryPath(), new History(dutyUsers, getConfigValue.getUsers()));
            return dutyUsers;
        }
        History last = allHistory.getLast();
        // 对比是时间是否是本周，如果是本周的则直接返回值日数据，否则获取新值日数据并存入历史文件中
        if (DateUtils.isSameWeekAsNow(last.getDate())) {
            return last.getUsers();
        } else {
            List<String> namesNotChanges = findNamesNotChanges(last.getUsers());
            HistorySettingsUtils.addHistory(getConfigValue.getHistoryPath(), new History(namesNotChanges, getConfigValue.getUsers()));
            return namesNotChanges;
        }
    }

    private List<String> findNamesNotChanges(List<String> targetNames) {
        String last = targetNames.getLast();
        List<String> allNames = getConfigValue.getAllUsers();
        int start = 0;
        for (int i = 0; i < allNames.size(); i++) {
            if (last.equals(allNames.get(i))) {
                start = ++i;
            }
        }
        Integer dutyNumber = getConfigValue.getDutyNumber();
        int tag = 0;
        List<String> strings = new ArrayList<>();
        int size = allNames.size();
        for(int i = 0; i < size; i++) {
            if (start > size) {
                strings = allNames.subList(0, dutyNumber);
                break;
            }
            if (start == i || (tag > 0 && tag < dutyNumber)) {
                tag++;
                strings.add(allNames.get(i));
            } else if (tag == dutyNumber) {
                break;
            }
        }
        if (strings.size() < dutyNumber) {
            int laseInt = dutyNumber - strings.size();
            List<String> lastName = allNames.subList(0, laseInt);
            strings.addAll(lastName);
        }
        return strings;
    }

    @Override
    public Map<String, List<String>> getDutyContent(List<String> dutyUsers) {
        List<String> maxItemList = getConfigValue.maxItemList();
        List<String> minItemList = getConfigValue.minItemList();

        int dutyNum = dutyUsers.size();

        List<Integer> maxItem = RandomCollectionGenerator.generate(dutyNum, 0, maxItemList.size()-1);
        List<Integer> minItem = RandomCollectionGenerator.generate(dutyNum, 0, minItemList.size()-1);
        Map<String, List<String>> dutyContent = new HashMap<>();
        for (int i = 0; i < dutyNum; i++) {
            List<String> items = new ArrayList<>();
            Integer maxTag = maxItem.get(i);
            Integer minTag = minItem.get(i);
            items.add(maxItemList.get(maxTag));
            items.add(minItemList.get(minTag));
            dutyContent.put(dutyUsers.get(i), items);
        }
        return dutyContent;
    }

    public static void main(String[] args) {
        List<Integer> generate = RandomCollectionGenerator.generate(2, 1, 2);
        System.out.println(generate);
    }
}
