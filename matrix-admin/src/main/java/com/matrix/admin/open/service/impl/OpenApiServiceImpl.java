package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.OpenApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author liuweizhong
 * @since 2024-02-11
 */
@Slf4j
@Service
public class OpenApiServiceImpl implements OpenApiService {
    @Override
    public String testFileStream() {
        long l = System.currentTimeMillis();
        Map<String, String> familyName = getParams("D:\\JSON.txt", Arrays.asList("图像", "维护单位", "主体"));
        log.info("familyName: {}", familyName);
        log.info("执行耗时: {}ms", System.currentTimeMillis() - l);
        return "success";
    }

    /**
     * 获取参数
     * @param physicalPath
     * @param keys 为不重复的key集合
     * @return
     */
    private Map<String, String> getParams(String physicalPath, List<String> keys) {
        Map<String, String> params = new HashMap<>();
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(physicalPath), StandardCharsets.UTF_8));
                ) {
            int charr;
            int[][] arr = getArr(keys);
            List<Integer> compareList = new ArrayList<>();
            String tag = "";
            while ((charr = br.read())!= -1) {
                if (charr == '{' || charr == '[' || charr == '}' || charr == ']' || charr == ' ') {
                    continue;
                } else if (charr == ',') {
                    if (tag.length() == 0) {
                        int[] currentArr = getCurrentArr(compareList);
                        for (int i = 0; i < arr.length; i++) {
                            int[] tempArr = arr[i];
                            if (Arrays.equals(tempArr, currentArr)) {
                                // 找到了对应的key
                                tag = keys.get(i);
                            }
                        }
                    } else {
                        params.put(tag, getCurrentStr(compareList));
                        tag = "";
                    }
                    compareList.clear();
                } else {
                    compareList.add(charr);
                }
                // 不全文检索，全文检索需要300-500ms执行时间
                if (params.keySet().size() == keys.size()) {
                    break;
                }
            }
        }catch (IOException e) {
            log.error("error", e);
        }
        return params;
    }

    private String getCurrentStr(List<Integer> compareList) {
        char[] charArray = new char[compareList.size()];
        for (int i = 0; i < compareList.size(); i++) {
            int integer = compareList.get(i);
            charArray[i] = (char) integer;
        }
        String s = new String(charArray);
        if (!s.contains("parValue")) {
            return "";
        }
        return s.replaceAll("\"", "").replace("parValue", "").replace(":", "");
    }

    private int[] getCurrentArr(List<Integer> compareList) {
        int[] arr = new int[compareList.size()];
        for (int i = 0; i < compareList.size(); i++) {
            arr[i] = compareList.get(i);
        }
        return arr;
    }

    private int[][] getArr(List<String> keys) {
        int[][] arrArr = new int[keys.size()][];
        for (String key : keys) {
            String value = "\"parName\":\""+key+"\"";
            int[] arr = new int[value.length()];
            char[] charArray = value.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                arr[i] = charArray[i];
            }
            arrArr[keys.indexOf(key)] = arr;
        }
        return arrArr;
    }
}
