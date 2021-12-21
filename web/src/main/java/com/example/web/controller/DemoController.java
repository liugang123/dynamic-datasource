package com.example.web.controller;

import com.example.web.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器类
 *
 * @author liugang
 * @create 2021/12/21
 */
@RestController
@RequestMapping("/example/demo")
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public String test(@RequestParam String word) {
        String result = demoService.test(word);
        log.info("demoController result:{}", result);
        return result;
    }

}
