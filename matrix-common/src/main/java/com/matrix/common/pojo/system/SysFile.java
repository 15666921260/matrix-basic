package com.matrix.common.pojo.system;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 系统文件总表
 * @author liuweizhong
 * @since 2024-03-10
 */
@Data
@Table("sys_file")
public class SysFile {

    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @Column("id")
    private String id;
    /**
     * 文件类型 jpg、png、doc、pdf等
     */
    @Column("file_type")
    private String fileType;

    /**
     * 文件保存路径
     */
    @Column("file_url")
    private String fileUrl;

    /**
     * 文件临时名称 带后缀
     */
    @Column("file_temp_name")
    private String fileTempName;

    /**
     * 文件源名称(上传时的，带后缀)
     */
    @Column("file_source_name")
    private String fileSourceName;

    @Column("remarks")
    private String remarks;

    @Column("create_id")
    private String createId;

    @Column("create_time")
    private LocalDateTime createTime;

    @Column("update_id")
    private String updateId;

    @Column("update_time")
    private LocalDateTime updateTime;

    @Column(value="deleted", isLogicDelete = true)
    private Integer deleted;

}
