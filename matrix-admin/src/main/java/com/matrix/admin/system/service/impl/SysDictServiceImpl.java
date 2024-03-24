package com.matrix.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.admin.system.mappers.SysDictMapper;
import com.matrix.admin.system.mappers.SysDictTypeMapper;
import com.matrix.admin.system.service.SysDictService;
import com.matrix.common.pojo.system.SysDict;
import com.matrix.common.pojo.system.SysDictType;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;
import com.matrix.common.vo.system.param.QueryDictTypeParam;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    public String addOrEditDictType(DictTypeVo dictTypeVo, String loginId) {
        LocalDateTime now = LocalDateTime.now();
        if (Objects.isNull(dictTypeVo.getId())) {
            SysDictType sysDictType = dictTypeVo2SysDictType(dictTypeVo, loginId, now);
            sysDictType.setCreateId(loginId);
            sysDictType.setCreateTime(now);
            sysDictTypeMapper.insert(sysDictType);
        }else {
            sysDictTypeMapper.updateById(dictTypeVo2SysDictType(dictTypeVo, loginId, now));
        }
        return "success";
    }

    @Override
    public DictTypeVo getDictTypeDetail(Integer dictTypeId) {
        SysDictType sysDictType = sysDictTypeMapper.selectById(dictTypeId);
        DictTypeVo dictTypeVo = new DictTypeVo();
        dictTypeVo.setId(sysDictType.getId());
        dictTypeVo.setTypeName(sysDictType.getTypeName());
        dictTypeVo.setNeedEnum(sysDictType.getNeedEnum());
        dictTypeVo.setRemarks(sysDictType.getRemarks());
        dictTypeVo.setDisable(sysDictType.getDisable());
        return dictTypeVo;
    }

    private SysDictType dictTypeVo2SysDictType (DictTypeVo dictTypeVo, String loginId, LocalDateTime now) {
        SysDictType sysDictType = new SysDictType();
        sysDictType.setTypeName(dictTypeVo.getTypeName());
        sysDictType.setNeedEnum(dictTypeVo.getNeedEnum());
        sysDictType.setRemarks(dictTypeVo.getRemarks());
        sysDictType.setDisable(dictTypeVo.getDisable());
        sysDictType.setUpdateId(loginId);
        sysDictType.setUpdateTime(now);
        return sysDictType;
    }

    @Override
    public String addDict(DictVo dictVo) {
        return null;
    }

    @Override
    public PageInfo<DictTypeVo> queryDictType(QueryDictTypeParam dictTypeParam) {
        PageHelper.startPage(dictTypeParam.getPageNum(), dictTypeParam.getPageSize());
        List<DictTypeVo> dictTypeVos = sysDictTypeMapper.queryDictType(dictTypeParam.getTypeName());
        return new PageInfo<>(dictTypeVos);
    }

    @Override
    public List<DictVo> queryDict(Integer typeId) {
        return null;
    }
}
