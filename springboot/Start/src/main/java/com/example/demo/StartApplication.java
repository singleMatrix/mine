package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StartApplication {

    @Value(value = "${book.author}")
    private String bookAuthor;

    @Autowired
    private BookBean bookBean;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(StartApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);
    }

    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String index() {
        return "Hello Spring Boot! This is " + bookBean.getName();
    }
}
