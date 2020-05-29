package com.prct.consumer.feign;

import com.prct.consumer.feign.fallback.ProviderFeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-provider",fallback = ProviderFeignFallBack.class)
public interface ProviderFeign {

    @RequestMapping("/getUserName")
    public String getProviderUserName();

    @RequestMapping("/testff")
    public String testff();

}
