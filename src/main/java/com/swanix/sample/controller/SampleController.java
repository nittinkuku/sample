package com.swanix.sample.controller;

import com.swanix.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/sample", produces = "application/json")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String sayHello() {
        log.info("Controller method sayHello called.");
        return sampleService.sayHello();
    }
}
