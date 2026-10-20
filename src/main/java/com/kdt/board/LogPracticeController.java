package com.kdt.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogPracticeController {
    private static final Logger log = LoggerFactory.getLogger(LogPracticeController.class);

    @GetMapping("/logs/check")
    public String check(){
        System.out.println("log practice println");
        log.debug("log practice debug");
        log.info("log practice info");
        return "logged";
    }
}
