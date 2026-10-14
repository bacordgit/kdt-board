package com.kdt.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Getter
public class HelloController {
    private final Service service;


    @GetMapping("/hello")
    public String hello(){
        return this.service.message();
    }
}
