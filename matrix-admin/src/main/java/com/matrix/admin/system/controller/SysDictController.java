package com.matrix.admin.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.matrix.admin.system.service.SysDictService;
import com.matrix.common.vo.basic.response.BaseResponse;
import com.matrix.common.vo.basic.response.PageResponse;
import com.matrix.common.vo.system.dict.DictTypeVo;
import com.matrix.common.vo.system.dict.DictVo;
import com.matrix.common.vo.system.param.QueryDictItemParam;
import com.matrix.common.vo.system.param.QueryDictTypeParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典类型与字典项控制层
 *
 * @author liuweizhong
 * @since 2024-03-21
 */
@Slf4j
@Tag(name = "SysDictController", description = "系统字典管理")
@RestController
@RequestMapping("/sysDict")
public class SysDictController {

    @Resource
    private SysDictService sysDictService;

    @PostMapping("/addOrEditDictType")
    @Operation(summary = "添加或修改字典类型")
    public BaseResponse<String> addOrEditDictType(@RequestBody DictTypeVo dictTypeVo) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return BaseResponse.success(sysDictService.addOrEditDictType(dictTypeVo, loginId));
    }

    @GetMapping("/getDictTypeDetail/{dictTypeId}")
    @Operation(summary = "获取字典类型详情字典类型")
    public BaseResponse<DictTypeVo> getDictTypeDetail(@PathVariable("dictTypeId") Integer dictTypeId) {
        return BaseResponse.success(sysDictService.getDictTypeDetail(dictTypeId));
    }

    @PostMapping("/pageDictType")
    @Operation(summary = "分页查询字典类型")
    public PageResponse<DictTypeVo> pageDictType(@RequestBody QueryDictTypeParam dictTypeParam) {
        return PageResponse.success(sysDictService.queryDictType(dictTypeParam));
    }

    @GetMapping("/deleteDictTypeById")
    @Operation(summary = "根据字典类型id删除字典类型和相关字典项")
    public BaseResponse<String> deleteDictTypeById(@RequestParam("dictTypeId") Integer dictTypeId) {
        return sysDictService.deleteDictTypeById(dictTypeId);
    }

    @PostMapping("/pageDictItem")
    @Operation(summary = "根据字典类型分页查询字典项")
    public PageResponse<DictVo> pageDictItem(@RequestBody QueryDictItemParam queryDictItemParam){
        return PageResponse.success(sysDictService.pageDictItem(queryDictItemParam));
    }

    @GetMapping("/getDictItemById")
    @Operation(summary = "根据字典项id查询字典项详情")
    public BaseResponse<DictVo> getDictItemById(@RequestParam("id") String id){
        return BaseResponse.success(sysDictService.getDictItemById(id));
    }

    @PostMapping("/addOrEditDictItem")
    @Operation(summary = "添加或修改字典项")
    public BaseResponse<String> addOrEditDictItem(@RequestBody DictVo dictVo) {
        // 获取当前登录用户的id
        String loginId = (String) StpUtil.getLoginId();
        return sysDictService.addOrEditDictItem(dictVo, loginId);
    }

    @GetMapping("/getDictDetail")
    @Operation(summary = "根据id查询字典项详情")
    public BaseResponse<DictVo> getDictDetail(@RequestParam("dictItemId") String dictItemId){
        return BaseResponse.success(sysDictService.getDictItemById(dictItemId));
    }

    @GetMapping("/deleteDictItemTypeById")
    @Operation(summary = "根据字典项id删除字典项")
    public BaseResponse<String> deleteDictItemTypeById(@RequestParam("dictItemId") String dictItemId) {
        return sysDictService.deleteDictItemTypeById(dictItemId);
    }

    @GetMapping("/selectDictItemByDictTypeId")
    @Operation(summary = "根据字典类型id查询字典项列表")
    public BaseResponse<List<DictVo>> selectDictItemByDictTypeId(@RequestParam("dictTypeId") Integer dictTypeId){
        return BaseResponse.success(sysDictService.queryDict(dictTypeId));
    }
}
