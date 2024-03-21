package com.matrix.admin.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.matrix.common.pojo.system.SysDict;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;

import java.util.List;

/**
 * 系统字典服务
 * @author liuweizhong
 * @since 2024-03-21
 */
public interface SysDictService extends IService<SysDict> {

    /**
     * 添加字典类型
     * @param dictTypeVo 要添加的数据
     * @return 返回的数据
     */
    String addDictType(DictTypeVo dictTypeVo);

    /**
     * 添加字典项
     * @param dictVo 要添加的数据
     * @return 返回的数据
     */
    String addDict(DictVo dictVo);

    /**
     * 根据类型名查询字典类型
     * @param typeName 类型名
     * @return 返回的数据
     */
    List<DictTypeVo> queryDictType(String typeName);

    /**
     * 根据字典类型id查询字典项
     * @param typeId
     * @return
     */
    List<DictVo> queryDict(Integer typeId);

}
