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
import com.matrix.common.vo.system.param.QueryDictItemParam;
import com.matrix.common.vo.system.param.QueryDictTypeParam;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
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
        SysDictType sysDictType;
        if (Objects.isNull(dictTypeVo.getId())) {
            sysDictType = dictTypeVo2SysDictType(dictTypeVo, loginId, now);
            sysDictType.setCreateId(loginId);
            sysDictType.setCreateTime(now);
            sysDictTypeMapper.insert(sysDictType);
        }else {
            sysDictType = sysDictTypeMapper.selectById(dictTypeVo.getId());
            sysDictType.setTypeName(dictTypeVo.getTypeName());
            sysDictType.setDisable(dictTypeVo.getDisable());
            sysDictType.setRemarks(dictTypeVo.getRemarks());
            sysDictType.setNeedEnum(dictTypeVo.getNeedEnum());
            sysDictType.setUpdateId(loginId);
            sysDictType.setUpdateTime(now);
            sysDictTypeMapper.updateById(sysDictType);
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

    @Override
    public String deleteDictTypeById(Integer dictTypeId) {
        if (Objects.isNull(dictTypeId)) {
            return "字典类型id为空";
        }
        int i = sysDictTypeMapper.deleteById(dictTypeId);
        Integer integer = sysDictMapper.deleteDictByTypeId(dictTypeId);
        if ( i == 0 && integer.equals(0)) {
            return "未删除任何数据";
        }
        return "success";
    }

    @Override
    public PageInfo<DictVo> pageDictItem(QueryDictItemParam dictItemParam) {
        PageHelper.startPage(dictItemParam.getPageNum(), dictItemParam.getPageSize());
        List<DictVo> dictVos = sysDictMapper.queryDictByTypeId(dictItemParam.getTypeId());
        return new PageInfo<>(dictVos);
    }

    @Override
    public DictVo getDictItemById(String id) {
        SysDict sysDict = sysDictMapper.selectById(id);
        DictVo dictVo = new DictVo();
        dictVo.setId(sysDict.getId());
        dictVo.setTypeName(sysDict.getDicName());
        dictVo.setDicValue(sysDict.getDicValue());
        dictVo.setDicName(sysDict.getDicName());
        dictVo.setSortNum(sysDict.getSortNum());
        dictVo.setDisable(sysDict.getDisable());
        dictVo.setRemarks(sysDict.getRemarks());
        return dictVo;
    }

    @Override
    public String addOrEditDictItem(DictVo dictVo, String loginId) {
        LocalDateTime now = LocalDateTime.now();
        SysDict sysDict;
        if (StringUtils.isBlank(dictVo.getId())) {
            sysDict = new SysDict();
            dictVo2SysDict(dictVo, loginId, now, sysDict);
            sysDict.setCreateTime(now);
            sysDict.setCreateId(loginId);
            sysDictMapper.insert(sysDict);
        }else {
            sysDict = sysDictMapper.selectById(dictVo.getId());
            dictVo2SysDict(dictVo, loginId, now, sysDict);
            sysDictMapper.updateById(sysDict);
        }
        return "success";
    }

    /**
     * dictVo 到 sysDict 转换
     * @param dictVo dictVo
     * @param loginId 登录用户的id
     * @param now 当前时间
     * @param sysDict sysDict
     */
    private void dictVo2SysDict(DictVo dictVo, String loginId, LocalDateTime now, SysDict sysDict) {
        sysDict.setDicName(dictVo.getDicName());
        sysDict.setDicValue(dictVo.getDicValue());
        sysDict.setRemarks(dictVo.getRemarks());
        sysDict.setUpdateTime(now);
        sysDict.setUpdateId(loginId);
        sysDict.setDisable(dictVo.getDisable());
        sysDict.setSortNum(dictVo.getSortNum());
    }
}
