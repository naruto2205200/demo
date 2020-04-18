package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author naruto
 * @data 2018/12/8.
 */
@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping("/helloController/hello")
    public String hello() throws Exception{
        logger.info("iopfessssssssss");
        throw new Exception("sssssssssssssssssss");
//        return "hello world!!!";
    }


    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
