package com.example.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ErrorAspect {

    @AfterThrowing(value = "execution(* *..*..*(..)) &&"
            + "(bean(*Controller) || bean(*Service) || bean(*Repository))",
            throwing = "ex")
    public void throwingNull(DataAccessException ex) {
        // 例外処理の内容（ログ出力）
        log.error("DataAccessExceptionが発生しました");
    }
}
