package com.matrix.admin.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.matrix.common.pojo.system.SysDict;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;
import com.matrix.common.vo.system.param.QueryDictItemParam;
import com.matrix.common.vo.system.param.QueryDictTypeParam;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 根据类型名查询字典类型
     * @param dictTypeParam 查询参数
     * @return 返回的数据
     */
    PageInfo<DictTypeVo> queryDictType(QueryDictTypeParam dictTypeParam);

    /**
     * 根据字典类型id查询字典项
     * @param typeId 字典类型id
     * @return 返回的数据
     */
    List<DictVo> queryDict(Integer typeId);

    /**
     * 根据字典类型id删除字典类型和相关字典项
     * @param dictTypeId 字典类型id
     * @return 返回的数据
     */
    BaseResponse<String> deleteDictTypeById(Integer dictTypeId);

    /**
     * 根据字典类型id分页查询字典项
     * @param queryDictItemParam 查询参数
     * @return 分页数据
     */
    PageInfo<DictVo> pageDictItem(QueryDictItemParam queryDictItemParam);

    /**
     * 根据字典项id查询字典详情
     * @param id 字典项id
     * @return 结果
     */
    DictVo getDictItemById(String id);

    /**
     * 添加或修改字典项
     * @param dictVo 字典项数据
     * @param loginId 登录用户的id
     * @return 结果
     */
    BaseResponse<String> addOrEditDictItem(DictVo dictVo, String loginId);

    /**
     * 根据字典项id删除字典项
     * @param dictItemId 字典项id
     * @return 结果
     */
    BaseResponse<String> deleteDictItemTypeById(String dictItemId);
}
