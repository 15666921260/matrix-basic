package com.matrix.admin.oj.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author liuweizhong
 * @since 2024-10-15 22:35
 */
@Getter
@AllArgsConstructor
public enum QuestionSubmitStatus {

    /**
     * 题目提交状态枚举
     */
    WAIT("等待中", 0),
    RUNNING("判题中", 1),
    SUCCEED("成功", 2),
    FAILED("失败", 3);

    private final String text;

    private final Integer code;

    public static List<Integer> getCodes() {
        return Arrays.stream(QuestionSubmitStatus.values()).map(QuestionSubmitStatus::getCode).collect(Collectors.toList());
    }

    public static QuestionSubmitStatus getByCode(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        for (QuestionSubmitStatus status : QuestionSubmitStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }
}
