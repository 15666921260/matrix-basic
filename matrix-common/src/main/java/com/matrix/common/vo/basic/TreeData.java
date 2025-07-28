package com.matrix.common.vo.basic;

import lombok.Data;

import java.util.List;

/**
 * 获取树形数据的封装
 * @author liuweizhong
 * @since 2024-04-14
 */
@Data
public class TreeData {
    private Long id;
    private String label;
    private List<TreeData> children;
}
