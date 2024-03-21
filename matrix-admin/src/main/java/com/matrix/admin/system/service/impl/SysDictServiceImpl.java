package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matrix.admin.system.mappers.SysDictMapper;
import com.matrix.admin.system.mappers.SysDictTypeMapper;
import com.matrix.admin.system.service.SysDictService;
import com.matrix.common.pojo.system.SysDict;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统字典服务
 * @author liuweizhong
 * @since 2024-03-21
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    @Override
    public String addDictType(DictTypeVo dictTypeVo) {
        return null;
    }

    @Override
    public String addDict(DictVo dictVo) {
        return null;
    }

    @Override
    public List<DictTypeVo> queryDictType(String typeName) {
        return sysDictTypeMapper.queryDictType(typeName);
    }

    @Override
    public List<DictVo> queryDict(Integer typeId) {
        return null;
    }
}
