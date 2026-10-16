package com.kdt.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FareController {
    private final FareService service;

    @Autowired
    public FareController(FareService service) {
        this.service = service;
    }
    @GetMapping("/fare")
    public String stat(){
        return this.service.price();
    }
}
