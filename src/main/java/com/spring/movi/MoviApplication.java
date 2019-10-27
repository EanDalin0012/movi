package com.spring.movi;

import com.spring.movi.dto.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MoviApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviApplication.class, args);
    }

}
