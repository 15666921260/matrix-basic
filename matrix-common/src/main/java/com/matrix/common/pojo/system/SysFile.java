package com.matrix.common.pojo.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 系统文件总表
 * @author liuweizhong
 * @since 2024-03-10
 */
@Data
@TableName("sys_file")
public class SysFile {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 文件类型 jpg、png、doc、pdf等
     */
    @TableField("file_type")
    private String fileType;

    /**
     * 文件保存路径
     */
    @TableField("file_url")
    private String fileUrl;

    /**
     * 文件临时名称 带后缀
     */
    @TableField("file_temp_name")
    private String fileTempName;

    /**
     * 文件源名称(上传时的，带后缀)
     */
    @TableField("file_source_name")
    private String fileSourceName;

    @TableField("remarks")
    private String remarks;

    @TableField("create_id")
    private String createId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_id")
    private String updateId;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableLogic(value="0",delval="1")
    private Integer deleted;

}
