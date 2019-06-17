package com.cc.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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


    @GetMapping("demo/api/jsonObject")
    @ResponseBody
    public JSONObject testJsonObject(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(date);
        Map<String,Object> map = new HashMap<>();
        map.put("today",s);
        map.put("yesterday","2019-06-16");
        return  new JSONObject(map);
    }
}
