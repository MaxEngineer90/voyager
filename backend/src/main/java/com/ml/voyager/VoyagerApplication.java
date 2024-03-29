package com.ml.voyager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VoyagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(VoyagerApplication.class, args);
    }


    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("directoryContents");
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
        };
    }
}
