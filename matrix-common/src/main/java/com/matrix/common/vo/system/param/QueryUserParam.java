package com.matrix.common.vo.system.param;

import com.matrix.common.vo.basic.PageQueryBaseParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询用户参数类
 * @author liuweizhong
 * @since 2024-03-19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "QueryUserParam", description = "用户查询封装类")
public class QueryUserParam extends PageQueryBaseParam {

    @Schema(name = "username", description = "用户名")
    private String username;



}
