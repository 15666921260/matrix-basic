package com.matrix.admin.system.mappers;

import com.matrix.common.pojo.system.SysDictType;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典类型mapper
 * @author liuweizhong
 * @since 2024-03-21
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
     * 根据类型名模糊查询字典类型
     * @param typeName 类型名
     * @return 结果集
     */
    List<DictTypeVo> queryDictType(@Param("typeName") String typeName);

}
