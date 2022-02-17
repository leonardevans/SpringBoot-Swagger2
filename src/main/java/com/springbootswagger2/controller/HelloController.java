package com.springbootswagger2.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, value = "/api/hello")
    @ApiOperation(value = "getGreeting", notes = "get getGreetings", nickname = "getGreeting")
    public String sayHello() {
        return "Swagger Hello World";
    }
}
