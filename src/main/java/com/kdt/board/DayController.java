package com.kdt.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayController {
    @GetMapping("/am")
    public String open(){
        return "open";
    }
    @GetMapping("/pm")
    public String close(){
        return "closed";
    }
}
