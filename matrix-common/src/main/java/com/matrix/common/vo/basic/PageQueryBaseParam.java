package com.matrix.common.vo.basic;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础查询参数
 * @author liuweizhong
 * @since 2024-03-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PageQueryBaseParam", description = "基础分页查询参数对象")
public class PageQueryBaseParam {

    @Schema(name = "pageSize", description = "分页容量")
    private Integer pageSize;

    @Schema(name = "pageNum", description = "页数")
    private Integer pageNum;

}
