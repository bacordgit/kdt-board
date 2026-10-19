package com.kdt.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardTxController {

    private final BoardTxService boardTxService;

    @Autowired
    public BoardTxController(BoardTxService boardTxService) {
        this.boardTxService = boardTxService;
    }


    @GetMapping("/tx/ok")
    public String ok() {
        return this.boardTxService.registerOk();
    }
    @GetMapping("/tx/fail")
    public String fail() {
        try{
            return this.boardTxService.registerFail();
        }catch(IllegalStateException e){
            return "rolled"+e.getMessage();
        }
    }
    @GetMapping("/tx/self")
    public String self() {
        try {
            return this.boardTxService.failBySelf();
        } catch (IllegalStateException ex) {
            return "left " + ex.getMessage();
        }
    }
    @GetMapping("/tx/open")
    public String open() {
        try{
            return this.boardTxService.registerOpen();
        }catch(IllegalStateException e){
            return "left"+e.getMessage();
        }
    }
    @GetMapping("/tx/proxy")
    public String proxyName(){
        return this.boardTxService.getClass().getName();
    }
    @GetMapping("/tx/dirty")
    public String dirty() {
        return this.boardTxService.registerDirty();
    }
    @GetMapping("/tx/flushed-fail")
    public String flushedFail() {
        try {
            return this.boardTxService.registerFlushFail();
        } catch (IllegalStateException ex) {
            return "rolled " + ex.getMessage();
        }
    }

}