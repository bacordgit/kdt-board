package com.kdt.board;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxProbeAspect {

    @Before("execution(* com.kdt.board.BoardTxService.registerOk(..))")
    public void beforeOk(JoinPoint joinPoint) {
        System.out.println("aspect " + joinPoint.getSignature().getName());
    }

}