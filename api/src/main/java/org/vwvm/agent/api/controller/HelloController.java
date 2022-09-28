package org.vwvm.agent.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        //通过 map 向前台页面传递数据
        System.out.println("\n \n \n");
        map.put("name", "郑锦鸿");
        return "index";
    }
}