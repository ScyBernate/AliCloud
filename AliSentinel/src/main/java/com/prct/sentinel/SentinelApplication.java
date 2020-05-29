package com.prct.sentinel;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.prct.sentinel.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SentinelApplication {

    private Logger log = LoggerFactory.getLogger(SentinelApplication.class);

    @Autowired
    TestService testService;

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    //test block
    @RequestMapping("/testBlock")
    public String testBlock(){
        log.info("进入到方法中!");
        return testService.testBlock();
    }

    //快速失败test
    @RequestMapping("/testFail")
    public String testFail(){
        log.info("进入到方法中!");
        return testService.testFail();
    }

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }
}
