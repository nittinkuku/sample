package com.swanix.sample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SampleService {

    public String sayHello() {
        log.info("Service Method sayHello called.");
        return "Hello!!!";
    }

}
