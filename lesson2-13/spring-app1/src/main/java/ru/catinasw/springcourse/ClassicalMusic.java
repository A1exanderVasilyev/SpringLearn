package ru.catinasw.springcourse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian rhapsody";
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("doMyInit");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("doMyDestroy");
    }
}
