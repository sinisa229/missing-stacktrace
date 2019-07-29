package com.example.missing.stacktrace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
@SpringBootApplication
public class MissingStacktrace implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        SpringApplication.run(MissingStacktrace.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        while (true) {
            try {
                doNull();
            } catch (RuntimeException e) {
                log.info("", e);
            }
        }
    }

    private void doNull() {
        String s = null;
        try {
            s.substring(0, 1);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

}
