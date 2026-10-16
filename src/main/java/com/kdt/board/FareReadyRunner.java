package com.kdt.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FareReadyRunner implements ApplicationRunner {
    private final FareService service;
    @Autowired

    public FareReadyRunner(FareService service) {
        this.service = service;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("fare ready" + this.service.price());
    }
}
