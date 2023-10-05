package com.caruta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.caruta.config.FQCNBeanNameGenerator;

@SpringBootApplication
@ComponentScan(nameGenerator = FQCNBeanNameGenerator.class)
@MapperScan(basePackages = { "com.caruta.mapper", "com.caruta.kn.mapper" }, nameGenerator = FQCNBeanNameGenerator.class)
public class CarutaUiApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(CarutaUiApplication.class);
    app.run(args);
  }
}