package com.matrix.admin.system.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matrix.common.pojo.system.SysDict;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典mapper
 * @author liuweizhong
 * @since 2024-03-21
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 根据字典类型查询字典项
     * @param typeId 字典类型id
     * @return 字典项
     */
    List<DictVo> queryDictByTypeId(@Param("typeId") Integer typeId);

    /**
     * 根据字典类型id删除字典类型和相关字典项
     * @param typeId 字典类型id
     * @return 删除个数
     */
    Integer deleteDictByTypeId(@Param("typeId") Integer typeId);

    /**
     * 根据字典项id查询详情
     * @param itemId 字典项id
     * @return 详情
     */
    DictVo getDictById(@Param("itemId") String itemId);
}
