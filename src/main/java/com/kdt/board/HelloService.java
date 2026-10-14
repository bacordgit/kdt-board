package com.kdt.board;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class HelloService implements com.kdt.board.Service{

    public String message(){
        return "kimbap";

    }
}
