package com.cc.demo;

import org.springframework.web.bind.annotation.*;

/**
 * RESTful风格接口
 *
 * @author He Chunxiao
 * @date 2019-05-15 17:23
 * @desc
 */
@RestController("/demo/api")
public class RESTFulDemo {

    @GetMapping
    public String getMethod(){
        return "GET";
    }

    @PostMapping
    public String postMethod(){
        return "POST";
    }

    @PutMapping
    public String putMethod(){
        return "PUT";
    }

    @DeleteMapping
    public  String deleteMethod(){
        return "DELETE";
    }

    @DeleteMapping("/ad")
    public String de(){
        return "delete/";
    }
}
