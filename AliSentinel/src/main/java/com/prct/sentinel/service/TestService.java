package com.prct.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private Logger log = LoggerFactory.getLogger(TestService.class);

    /**
     * @return
     * @SentinelResource注解灵活控制限流资源
     */
    @SentinelResource(value = "testBlockResource", blockHandler = "blockByTest")
    public String testBlock() {
        return "sentinel";
    }

    public String blockByTest(BlockException ex) {
        log.error("block by test");
        return "block by SentinelApplication";
    }


    @SentinelResource(value = "testFailResource", fallback = "fallTest")
    public String testFail() {
        return "sentinel";
    }

    public String fallTest() {
        log.error("fail by test");
        return "fail by SentinelApplication";
    }


}
