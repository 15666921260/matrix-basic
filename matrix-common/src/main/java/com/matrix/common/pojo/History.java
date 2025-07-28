package com.matrix.common.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2025-07-28 14:25
 */
@Data
public class History {

    private LocalDateTime date;

    private List<String> users;

    private String allUsers;

}
