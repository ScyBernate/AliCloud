package com.prct;

import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication
{
    @Bean
    public Retryer feignRetryer(){
        Retryer retryer = new Retryer.Default(100,1000,4);
        return retryer;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
