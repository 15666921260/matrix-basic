package com.matrix.common.vo.basic;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 获取树形数据的封装
 * @author liuweizhong
 * @since 2024-04-14
 */
@Data
@Schema(name = "TreeData", description = "获取树形数据的封装")
public class TreeData {
    @Schema(name = "id", description = "主键")
    private Long id;
    @Schema(name = "label", description = "主键")
    private String label;
    @Schema(name = "label", description = "主键")
    private List<TreeData> children;
}
