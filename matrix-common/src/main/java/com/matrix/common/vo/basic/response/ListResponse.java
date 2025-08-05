package com.matrix.common.vo.basic.response;

import com.matrix.common.enums.system.HttpStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 列表响应对象
 * @author liuweizhong
 * @since 2025-03-16 05:51
 */
@Data
public class ListResponse<T> implements Serializable {

    private static final long serialVersionUID = 5364576275549295059L;

    private int code;

    private List<T> data = new ArrayList<>();

    private String msg;

    public ListResponse() {
    }

    public ListResponse(HttpStatus httpStatus, Collection<T> data) {
        this.code = httpStatus.getCode();
        this.msg = httpStatus.getMsg();
        this.data.addAll(data);
    }

    public ListResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static <T> ListResponse<T> success(HttpStatus httpStatus, List<T> data) {
        return new ListResponse<>(httpStatus, data);
    }

    public static <T> ListResponse<T> success(List<T> data) {
        return new ListResponse<>(HttpStatus.SUCCESS, data);
    }

    public static <T> ListResponse<T> error() {
        return new ListResponse<>(HttpStatus.ERROR.getCode(), HttpStatus.ERROR.getMsg());
    }


}
