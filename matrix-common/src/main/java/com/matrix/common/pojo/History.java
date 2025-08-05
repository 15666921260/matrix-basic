package com.matrix.common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2025-07-28 14:25
 */
@Data
@AllArgsConstructor
public class History {

    private LocalDateTime date;

    private String dateStr;

    private List<String> users;

    private String allUsers;

    public History(List<String> users, String allUsers) {
        this.users = users;
        this.allUsers = allUsers;
        this.date = LocalDateTime.now();
    }

}
