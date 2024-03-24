package com.matrix.admin.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.matrix.common.pojo.system.SysDict;
import com.matrix.common.vo.basic.BaseResponse;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;
import com.matrix.common.vo.system.param.QueryDictTypeParam;
import org.springframework.web.bind.annotation.PathVariable;

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
     * @param loginId 登录用户的id
     * @return 返回的数据
     */
    String addOrEditDictType(DictTypeVo dictTypeVo, String loginId);

    /**
     * 根据字典类型id查询详情
     * @param dictTypeId 字典类型id
     * @return 返回的数据
     */
    DictTypeVo getDictTypeDetail(Integer dictTypeId);

    /**
     * 添加字典项
     * @param dictVo 要添加的数据
     * @return 返回的数据
     */
    String addDict(DictVo dictVo);

    /**
     * 根据类型名查询字典类型
     * @param dictTypeParam 查询参数
     * @return 返回的数据
     */
    PageInfo<DictTypeVo> queryDictType(QueryDictTypeParam dictTypeParam);

    /**
     * 根据字典类型id查询字典项
     * @param typeId
     * @return
     */
    List<DictVo> queryDict(Integer typeId);

}
