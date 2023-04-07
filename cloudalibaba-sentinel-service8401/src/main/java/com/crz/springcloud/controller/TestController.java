package com.crz.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        return "Hello Sentinel ==> test1";
    }

    @GetMapping("/test2")
    public String test2() {
        return "Hello Sentinel ==> test2";
    }

    @GetMapping("/testPfc")
    @SentinelResource(value = "testPfc", blockHandler = "testPfc_handler")
    public String testPfc(@RequestParam(value = "p1", required = false) String p1,
                          @RequestParam(value = "p2", required = false) String p2) {
        return "You succeed";
    }
    public String testPfc_handler(String p1, String p2, BlockException ex) {
        return "You've been restricted (￣▽￣)";
    }

}
