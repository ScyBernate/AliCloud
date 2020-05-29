package com.prct.consumer.feign.fallback;

import com.prct.consumer.feign.ProviderFeign;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProviderFeignFallBack
 * @Description TODO
 * @Author User
 * @DATE 2020/5/28 14:40
 * @Version 1.0
 **/
@Component
public class ProviderFeignFallBack implements ProviderFeign {

    @Override
    public String getProviderUserName() {
        return "getProviderUserName  fallback!";
    }

    @Override
    public String testff() {
        return "testff fallback";
    }
}
