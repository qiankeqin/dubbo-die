package com.dubbowork.qrz;

import com.dubbowork.qrz.entity.People;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class QrzApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("people.xml");
        People p = (People)ctx.getBean("cutesource");
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getAge());


        SpringApplication.run(QrzApplication.class, args);
    }

}
