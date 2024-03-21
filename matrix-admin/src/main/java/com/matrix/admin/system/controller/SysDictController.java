package com.matrix.admin.system.controller;

import com.matrix.admin.system.service.SysDictService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
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

}
