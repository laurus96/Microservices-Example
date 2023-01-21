package com.example.restfullapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestFullApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFullApiApplication.class, args);
    }

}
