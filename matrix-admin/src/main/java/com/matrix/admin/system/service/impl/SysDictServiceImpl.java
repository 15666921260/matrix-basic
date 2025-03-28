package com.matrix.admin.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matrix.admin.system.mappers.SysDictMapper;
import com.matrix.admin.system.mappers.SysDictTypeMapper;
import com.matrix.admin.system.service.SysDictService;
import com.matrix.common.enums.DeletedEnum;
import com.matrix.common.enums.SysDefault;
import com.matrix.common.pojo.system.SysDict;
import com.matrix.common.pojo.system.SysDictType;
import com.matrix.common.utils.ThrowUtils;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;
import com.matrix.common.vo.system.param.QueryDictItemParam;
import com.matrix.common.vo.system.param.QueryDictTypeParam;
import com.mybatisflex.spring.service.impl.ServiceImpl;
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
            sysDictType = sysDictTypeMapper.selectOneById(dictTypeVo.getId());
            sysDictType.setTypeName(dictTypeVo.getTypeName());
            sysDictType.setDisable(dictTypeVo.getDisable());
            sysDictType.setRemarks(dictTypeVo.getRemarks());
            sysDictType.setNeedEnum(dictTypeVo.getNeedEnum());
            sysDictType.setUpdateId(loginId);
            sysDictType.setUpdateTime(now);
            sysDictTypeMapper.update(sysDictType);
        }
        return SysDefault.SUCCESS.getValue();
    }

    @Override
    public DictTypeVo getDictTypeDetail(Integer dictTypeId) {
        SysDictType sysDictType = sysDictTypeMapper.selectOneById(dictTypeId);
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
    public PageInfo<DictTypeVo> queryDictType(QueryDictTypeParam dictTypeParam) {
        Page<DictTypeVo> page = PageHelper.startPage(dictTypeParam.getPageNum(), dictTypeParam.getPageSize())
                .doSelectPage(() -> sysDictTypeMapper.queryDictType(dictTypeParam.getTypeName()));
        return page.toPageInfo();
    }

    @Override
    public List<DictVo> queryDict(Integer typeId) {
        return sysDictMapper.queryDictByTypeId(typeId);
    }

    @Override
    public BaseResponse<String> deleteDictTypeById(Integer dictTypeId) {
        ThrowUtils.throwIfNull(dictTypeId, "字典类型id为空");
        int i = sysDictTypeMapper.deleteById(dictTypeId);
        Integer integer = sysDictMapper.deleteDictByTypeId(dictTypeId);
        if ( i == 0 && integer.equals(0)) {
            return BaseResponse.success("未删除任何数据");
        }
        return BaseResponse.success(SysDefault.SUCCESS.getValue());
    }

    @Override
    public PageInfo<DictVo> pageDictItem(QueryDictItemParam dictItemParam) {
        Page<DictVo> page = PageHelper.startPage(dictItemParam.getPageNum(), dictItemParam.getPageSize()).doSelectPage(() ->
                sysDictMapper.queryDictByTypeId(dictItemParam.getTypeId())
        );
        return page.toPageInfo();
    }

    @Override
    public DictVo getDictItemById(String id) {
        return sysDictMapper.getDictById(id);
    }

    @Override
    public BaseResponse<String> addOrEditDictItem(DictVo dictVo, String loginId) {
        SysDictType sysDictType = sysDictTypeMapper.selectOneById(dictVo.getType());
        if (Objects.isNull(sysDictType) || DeletedEnum.DELETE_NO.getValue().equals(sysDictType.getDeleted())) {
            return BaseResponse.buildCustom("传入了一个非法的字典类型数据", "原因是可能该数据并不存在，或者已被删除");
        }
        LocalDateTime now = LocalDateTime.now();
        SysDict sysDict;
        if (StringUtils.isBlank(dictVo.getId())) {
            sysDict = new SysDict();
            dictVo2SysDict(dictVo, loginId, now, sysDict);
            sysDict.setCreateTime(now);
            sysDict.setCreateId(loginId);
            sysDictMapper.insert(sysDict);
        }else {
            sysDict = sysDictMapper.selectOneById(dictVo.getId());
            dictVo2SysDict(dictVo, loginId, now, sysDict);
            sysDictMapper.update(sysDict);
        }
        return BaseResponse.success(SysDefault.SUCCESS.getValue());
    }

    /**
     * dictVo 到 sysDict 转换
     * @param dictVo dictVo
     * @param loginId 登录用户的id
     * @param now 当前时间
     * @param sysDict sysDict
     */
    private void dictVo2SysDict(DictVo dictVo, String loginId, LocalDateTime now, SysDict sysDict) {
        sysDict.setType(dictVo.getType());
        sysDict.setDicName(dictVo.getDicName());
        sysDict.setDicValue(dictVo.getDicValue());
        sysDict.setRemarks(dictVo.getRemarks());
        sysDict.setUpdateTime(now);
        sysDict.setUpdateId(loginId);
        sysDict.setDisable(dictVo.getDisable());
        sysDict.setSortNum(dictVo.getSortNum());
    }

    @Override
    public BaseResponse<String> deleteDictItemTypeById(String dictItemId) {
        int i = sysDictMapper.deleteById(dictItemId);
        if (i != 0){
            return BaseResponse.success(SysDefault.SUCCESS.getValue());
        }else {
            return BaseResponse.success("没有数据被删除");
        }
    }


}
