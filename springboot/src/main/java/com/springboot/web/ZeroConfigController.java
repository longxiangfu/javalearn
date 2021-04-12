package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ZeroConfigController {

    /**
     * 测试是否可以访问
     */
    @RequestMapping("index")
    @ResponseBody
    public void index(){
        System.out.println("------ZeroConfigController--------");
    }


    /**
     * 测试消息转换器
     * @return
     */
    @RequestMapping("indexMap")
    @ResponseBody
    public Map<String, Object> indexMap(){
        System.out.println("------ZeroConfigController--------");
        System.out.println("返回为map");
        Map<String, Object> map = new HashMap<>();
        map.put("key", "value");
        return map;
    }


    /**
     * 测试内置字符串消息转换器
     * @return
     */
    @RequestMapping("indexStr")
    @ResponseBody
    public String indexStr(){
        System.out.println("------ZeroConfigController--------");
        System.out.println("返回为string");
        return "result";
    }
}
