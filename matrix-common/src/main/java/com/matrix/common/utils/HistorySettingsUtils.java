package com.matrix.common.utils;

import cn.hutool.json.JSONUtil;
import com.martix.util.DateUtils;
import com.matrix.common.pojo.History;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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
            // 检查并创建文件（不存在时）
            checkFile(path);
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes, StandardCharsets.UTF_8); // 读取全部内容
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
        ThrowUtils.throwIf(CollectionUtils.isEmpty(history.getUsers()), "值日人员不能为空");
        ThrowUtils.throwIf(StringUtils.isBlank(history.getAllUsers()), "全部人员数据不能为空");
        LocalDateTime date = history.getDate();
        ThrowUtils.throwIfNull(date, "发送日期不能为空");
        history.setDateStr(DateUtils.localDateTime2Str(date, "yyyy-MM-dd HH:mm:ss"));
        String content = JSONUtil.toJsonStr(history);
        Path path = Paths.get(filePath);
        try {
            // 检查并创建路径和文件（不存在时）
            checkFile(path);
            // 追加内容并自动添加换行符
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(content);
            writer.newLine(); // 可选：追加换行符
            writer.flush();
            fileWriter.close();
        } catch (IOException e) {
            log.error("文件追加失败: {}", e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkFile(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }



}
