package com.cc.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author He Chunxiao
 * @date 2019-05-06 10:44
 * @desc
 */
@RestController
public class OriginTest {

    @GetMapping("demo/api/originTest")
    public String originTest() {
        System.out.println("跨域测试");
        return "testOrigin";
    }
}
