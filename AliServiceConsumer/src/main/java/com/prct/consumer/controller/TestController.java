package com.prct.consumer.controller;

import com.prct.consumer.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ProviderFeign providerFeign;

    @GetMapping("/consumerTest")
    public String test(){
        return providerFeign.getProviderUserName();
    }

    @GetMapping("/testff")
    public String testff(){
        return providerFeign.testff();
    }

}
