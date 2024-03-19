package com.matrix.common.bo.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录信息
 * @author liuweizhong
 * @since 2024-02-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {

    private String userId;

    private String username;

    /**
     * 用户类型
     */
    private String userType;

}
