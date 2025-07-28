package com.matrix.common.utils;

import cn.hutool.json.JSONUtil;
import com.matrix.common.pojo.History;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2025-07-28 14:06
 */
@Slf4j
public class HistorySettingsUtils {

    private static String readFileToString(String filePath) {
        Path path = Paths.get(filePath);
        try {
            // 检查并创建路径和文件（不存在时）
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                return ""; // 新文件返回空字符串
            }
            return Files.readString(path); // 读取全部内容
        } catch (IOException e) {
            log.error("读取历史文件时操作异常: {}", e.getMessage());
            return ""; // 异常时返回空字符串
        }
    }

    public static List<History> getAllHistory(String filePath) {
        String allHistoryStr = readFileToString(filePath);
        if (StringUtils.isBlank(allHistoryStr)) {
            return Collections.emptyList();
        }
        String[] split = allHistoryStr.split("\n");
        List<History> historyList = new ArrayList<>();
        for (int i = 0; i < split.length ; i++) {
            String item = split[i];
            try {
                History bean = JSONUtil.toBean(item, History.class);
                historyList.add(bean);
            } catch (Exception e) {
                log.error("JSON转换出错！{}", e.getMessage());
            }
        }
        return historyList;
    }

    public static boolean addHistory(String filePath, History history) {
        if (history == null) {
            log.error("要添加的历史记录为空");
            return false;
        }
        String content = JSONUtil.toJsonStr(history);
        Path path = Paths.get(filePath);
        try {
            // 检查并创建路径和文件（不存在时）
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            // 追加内容并自动添加换行符
            Files.writeString(
                    path,
                    content + "\n", // 追加换行符
                    StandardOpenOption.APPEND // 启用追加模式
            );
        } catch (IOException e) {
            log.error("文件追加失败: {}", e.getMessage());
            return false;
        }
        return true;
    }



}
