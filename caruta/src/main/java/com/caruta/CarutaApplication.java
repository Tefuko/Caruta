package com.caruta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = false)
@ComponentScan(nameGenerator = AnnotationBeanNameGenerator.class)
@MapperScan(basePackages = {"com.caruta.kn.mapper", "com.caruta.mapper"}, nameGenerator = AnnotationBeanNameGenerator.class)
public class CarutaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarutaApplication.class, args);
    }

}