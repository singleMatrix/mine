package com.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author single
 * @date 2017/12/24.
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/spring/data-provider.xml");
        System.out.println(context.getDisplayName() + ":here");
        context.start();
        System.out.println("service is staring...");
        System.in.read();
    }
}
