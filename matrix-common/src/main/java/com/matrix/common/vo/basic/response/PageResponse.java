package com.matrix.common.vo.basic.response;

import com.github.pagehelper.PageInfo;
import com.matrix.common.enums.system.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回对象
 * @author liuweizhong
 * @since 2024-03-19
 */
@Data
@Schema(name = "PageResponse", description = "分页返回对象")
public class PageResponse<T> implements Serializable {

    @Schema(name = "code", description = "状态码")
    private int code;

    @Schema(name = "data", description = "数据封装")
    private List<T> data;

    @Schema(name = "message", description = "提示信息")
    private String message;

    @Schema(name = "total", description = "总行数")
    private Long total;

    @Schema(name = "pages", description = "总页数")
    private Integer pages;

    @Schema(name = "pageSize", description = "分页大小")
    private Integer pageSize;

    @Schema(name = "pageNum", description = "页数")
    private Integer pageNum;

    public PageResponse() {
    }

    public PageResponse(HttpStatus httpStatus, List<T> data, Long total, Integer pageSize, Integer pageNum, Integer pages) {
        this.code = httpStatus.getCode();
        this.data = data;
        this.message = httpStatus.getMessage();
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.pages = pages;
    }

    public static <T> PageResponse<T> success(PageInfo<T> pageInfo) {
        return new PageResponse<>(HttpStatus.SUCCESS, pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPageSize(),
                pageInfo.getPageNum(), pageInfo.getPages());
    }

    public static <T> PageResponse<T> build(HttpStatus httpStatus, PageInfo<T> pageInfo) {
        return new PageResponse<>(httpStatus, pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPageSize(),
                pageInfo.getPageNum(), pageInfo.getPages());
    }
}
