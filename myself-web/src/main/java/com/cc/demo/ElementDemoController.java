package com.cc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author He Chunxiao
 * @date 2019-03-12 15:34
 * @desc
 */
@Controller
public class ElementDemoController {

    @GetMapping("demo/page/element")
    public String getElementPage(){
        return "/demo/element";
    }
}
