package com.springbootswagger2.controller;

import com.springbootswagger2.Hello;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, value = "/api/hello")
    @ApiOperation(value = "getGreeting", notes = "get getGreetings", nickname = "getGreeting")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval",
                    response = Hello.class, responseContainer = "List") })
    public String sayHello() {
        return "Swagger Hello World";
    }
}
