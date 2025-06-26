package com.matrix.common.vo.basic.response;

import com.matrix.common.enums.system.HttpStatus;
import com.mybatisflex.core.paginate.Page;
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

    @Schema(name = "msg", description = "提示信息")
    private String msg;

    @Schema(name = "total", description = "总行数")
    private Long total;

    @Schema(name = "pages", description = "总页数")
    private Long pages;

    @Schema(name = "pageSize", description = "分页大小")
    private Long pageSize;

    @Schema(name = "pageNum", description = "当前页数")
    private Long pageNum;

    public PageResponse() {
    }

    public PageResponse(HttpStatus httpStatus, List<T> data, Long total, Long pageSize, Long pageNum, Long pages) {
        this.code = httpStatus.getCode();
        this.data = data;
        this.msg = httpStatus.getMsg();
        this.total = total;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.pages = pages;
    }

    public static <T> PageResponse<T> success(Page<T> pageInfo) {
        return new PageResponse<>(HttpStatus.SUCCESS, pageInfo.getRecords(), pageInfo.getTotalRow(), pageInfo.getPageSize(),
                pageInfo.getPageNumber(), pageInfo.getTotalPage());
    }

    public static <T> PageResponse<T> build(HttpStatus httpStatus, Page<T> pageInfo) {
        return new PageResponse<>(httpStatus, pageInfo.getRecords(), pageInfo.getTotalRow(), pageInfo.getPageSize(),
                pageInfo.getPageNumber(), pageInfo.getTotalPage());
    }
}
