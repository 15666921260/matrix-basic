package com.liu.matrixadmin.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweizhong
 * @since 2024-02-05
 */
@RestController
@RequestMapping("/Test")
public class TestController {


    @GetMapping("/test")
    public String testTask(){
        return "success!";
    }

}
