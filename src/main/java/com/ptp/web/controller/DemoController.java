package com.ptp.web.controller;


import com.ptp.mode.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller

public class DemoController extends  BaseController {

    @GetMapping("/welcome")
    public String welcome() {
    return "demo/test";
    }
    @GetMapping("/btoot")
    public String btoot() {
        return "btoot";
    }
    @GetMapping("demo/hello")
    @ResponseBody
    public RestResponse hello(String id) {
        log.info("hello：{}",id);
        return success();
    }
}
