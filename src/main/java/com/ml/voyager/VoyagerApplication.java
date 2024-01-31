package com.ml.voyager;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class VoyagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(VoyagerApplication.class, args);
    }
}
