package com.yancy.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yancy
 * @create: 2019-04-29 21:57
 */

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello(String name) {
        return "Hello,"+name+"!!";
    }
}