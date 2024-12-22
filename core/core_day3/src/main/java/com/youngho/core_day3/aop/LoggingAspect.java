package com.youngho.core_day3.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.youngho.core_day3.bean..*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName() + "." + joinPoint.getSignature().getName();

        log.info("--> {}()", methodName);

        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            log.info("<-- {}()", methodName);
        }

        return result;
    }
}
