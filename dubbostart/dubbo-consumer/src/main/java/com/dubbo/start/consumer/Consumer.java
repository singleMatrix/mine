package com.dubbo.start.consumer;

import com.dubbo.start.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author single
 * @date 2017/12/24.
 */
public class Consumer {
    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/WEB-INF/spring/spring.xml");
        context.start();
        System.out.println("consumer start");
        DemoService demoService = context.getBean(DemoService.class);
        System.out.println("consumer");
        System.out.println(demoService.getPermission(1L));
    }
}
